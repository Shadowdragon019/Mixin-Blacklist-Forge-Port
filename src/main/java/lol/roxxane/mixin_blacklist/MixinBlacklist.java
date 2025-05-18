package lol.roxxane.mixin_blacklist;

import com.google.common.collect.Streams;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.mojang.logging.LogUtils;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.loading.FMLPaths;
import org.slf4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// TODO: Disable refmap
@Mod(MixinBlacklist.ID)
public class MixinBlacklist {
    public static final String ID = "mixin_blacklist";
    public static final Logger LOGGER = LogUtils.getLogger();

    public static final Path CONFIG_PATH =
        Path.of(FMLPaths.CONFIGDIR.get().toString() + "/mixin_blacklist.json");

    public static final Gson BUILDER = new GsonBuilder()
        .serializeNulls()
        .setPrettyPrinting()
        .create();

    public static final List<Entry> ENTRIES = new ArrayList<>();

    static {
        LOGGER.debug("Reading config");

        MixinBlacklistConfig config = null;

        try {
            config = BUILDER.fromJson(Files.newBufferedReader(CONFIG_PATH), MixinBlacklistConfig.class);
        } catch (NoSuchFileException e) {
            LOGGER.info("Creating empty config");

            try {
                Files.writeString(CONFIG_PATH, BUILDER.toJson(new MixinBlacklistConfig()));
            } catch (IOException e2) {
                LOGGER.error("Could not write config", e2);
            }
        } catch (IOException | JsonSyntaxException | JsonIOException e) {
            LOGGER.error("Could not read config", e);
        }

        if (config != null)
            Streams.concat(
                config.common.mixin_class_names.stream().map(it -> new Entry(it, false, false)),
                config.common.target_class_names.stream().map(it -> new Entry(it, true, false)),
                config.client.mixin_class_names.stream().map(it -> new Entry(it, false, true)),
                config.client.target_class_names.stream().map(it -> new Entry(it, true, true))
            ).collect(Collectors.toCollection(() -> ENTRIES));
    }
}