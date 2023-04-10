package com.diamondgoobird.mixin;

import com.diamondgoobird.ToggleTitleMod;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiIngame;
import net.minecraftforge.client.GuiIngameForge;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GuiIngameForge.class)
public class GuiIngameForgeMixin extends GuiIngame {
    public GuiIngameForgeMixin(Minecraft mcIn) {
        super(mcIn);
    }

    @Inject(method = "renderTitle", at = @At("HEAD"), cancellable = true, remap = false)
    protected void renderTitle(int width, int height, float partialTicks, CallbackInfo ci) {
        if (!ToggleTitleMod.isEnabled()) {
            ci.cancel();
        }
        System.out.print("It's enabled!");
    }
}
