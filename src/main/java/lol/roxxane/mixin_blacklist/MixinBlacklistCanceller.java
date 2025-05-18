package lol.roxxane.mixin_blacklist;

import com.bawnorton.mixinsquared.api.MixinCanceller;

import java.util.List;

@SuppressWarnings("unused")
public class MixinBlacklistCanceller implements MixinCanceller {
	@Override
	public boolean shouldCancel(List<String> target_class_names, String mixin_class_name) {
		MixinBlacklist.LOGGER.info("EEEEEEEEEEEEEEEEEE");
		return true;
		/*
		MixinBlacklist.LOGGER.info("WEEEEEEEEEEEE");
		var is_client = FMLEnvironment.dist.isClient();
		for (var entry : MixinBlacklist.ENTRIES) {
			MixinBlacklist.LOGGER.info(entry.toString());

			if (!is_client && entry.is_client()) continue;
			if (entry.is_target() ? !target_class_names.contains(entry.class_name()) :
				!entry.class_name().equals(mixin_class_name)) continue;
			return true;
		}
		return false;*/
	}
}