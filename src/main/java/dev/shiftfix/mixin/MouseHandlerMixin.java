package dev.shiftfix.mixin;

import dev.shiftfix.ModifierState;
import net.minecraft.client.MouseHandler;
import net.minecraft.client.input.MouseButtonInfo;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(MouseHandler.class)
public class MouseHandlerMixin {
    @ModifyVariable(method = "onButton", at = @At("HEAD"), argsOnly = true)
    private MouseButtonInfo shiftfix$addModifiers(MouseButtonInfo info) {
        int extra = ModifierState.extraModifiers();
        if (extra == 0 || (info.modifiers() & extra) == extra) return info;
        return new MouseButtonInfo(info.button(), info.modifiers() | extra);
    }
}
