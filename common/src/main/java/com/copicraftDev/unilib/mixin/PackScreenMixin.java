package com.copicraftDev.unilib.mixin;

import net.minecraft.client.gui.screens.packs.PackSelectionScreen;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.server.packs.repository.Pack;
import net.minecraft.resources.ResourceLocation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PackSelectionScreen.class)
public abstract class PackScreenMixin {

    @Inject(
            method = "loadPackIcon(Lnet/minecraft/client/renderer/texture/TextureManager;Lnet/minecraft/server/packs/repository/Pack;)Lnet/minecraft/resources/ResourceLocation;",
            at = @At("HEAD"),
            cancellable = true
    )
    private void unilib$loadPackIcon(
            TextureManager textureManager,
            Pack resourcePackProfile,
            CallbackInfoReturnable<ResourceLocation> cir
    ) {
        if ("file/UnilibGenerated".equals(resourcePackProfile.getId())) {
            cir.setReturnValue( ResourceLocation.fromNamespaceAndPath("unilib", "logo.png"));
            cir.cancel();
        }
    }

}
