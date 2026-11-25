package dev.shiftfix.mixin;

import dev.shiftfix.ModifierState;
import net.minecraft.client.gui.screens.Screen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Screen.class)
public class ScreenMixin {
    @Inject(method = "hasShiftDown", at = @At("RETURN"), cancellable = true, require = 0)
    private static void shiftfix$shift(CallbackInfoReturnable<Boolean> cir) {
        if ((ModifierState.extraModifiers() & ModifierState.MOD_SHIFT) != 0) {
            cir.setReturnValue(true);
        }
    }

    @Inject(method = "hasControlDown", at = @At("RETURN"), cancellable = true, require = 0)
    private static void shiftfix$control(CallbackInfoReturnable<Boolean> cir) {
        if ((ModifierState.extraModifiers() & ModifierState.MOD_CONTROL) != 0) {
            cir.setReturnValue(true);
        }
    }
}
