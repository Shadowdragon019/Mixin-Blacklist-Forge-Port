package lol.roxxane.mixin_blacklist;

import java.util.List;

public class MixinBlacklistConfig {
	public MixinList client = new MixinList();
	public MixinList common = new MixinList();

	public static class MixinList {
		public List<String> mixin_class_names = List.of();
		public List<String> target_class_names = List.of();
	}
}