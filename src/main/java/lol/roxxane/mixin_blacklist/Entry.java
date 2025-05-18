package lol.roxxane.mixin_blacklist;

import org.jetbrains.annotations.NotNull;

public record Entry(String class_name, boolean is_target, boolean is_client) {
	@Override
	public @NotNull String toString() {
		return "[" + (is_target ? "Target" : "Mixin") + ": " + class_name + (is_client ? " (client only)" : "") + "]";
	}
}