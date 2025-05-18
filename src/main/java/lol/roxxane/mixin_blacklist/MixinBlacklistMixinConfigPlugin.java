package lol.roxxane.mixin_blacklist;

import com.bawnorton.mixinsquared.canceller.MixinCancellerRegistrar;
import org.objectweb.asm.tree.ClassNode;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;

import java.util.List;
import java.util.Set;

public class MixinBlacklistMixinConfigPlugin implements IMixinConfigPlugin {
	@Override
	public void onLoad(String $) {
		MixinCancellerRegistrar.register(new MixinBlacklistCanceller());
	}

	@Override
	public String getRefMapperConfig() {
		return null;
	}

	@Override
	public boolean shouldApplyMixin(String $, String $1) {
		return false;
	}

	@Override
	public void acceptTargets(Set<String> $, Set<String> $1) {

	}

	@Override
	public List<String> getMixins() {
		return List.of();
	}

	@Override
	public void preApply(String $, ClassNode $1, String $2, IMixinInfo $3) {

	}

	@Override
	public void postApply(String $, ClassNode $1, String $2, IMixinInfo $3) {

	}
}
