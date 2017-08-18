package com.fuzzypickles14.fluidsorcery.core.attunement;

import com.fuzzypickles14.fluidsorcery.lib.LibModDetails;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by Andrew Toomey on 8/17/2017.
 */
public class ModPotion extends Potion {
    protected ResourceLocation iconTexture;

    protected ModPotion(boolean isBadEffectIn, int liquidColorIn, String name) {
        super(isBadEffectIn, liquidColorIn);
        this.setRegistryName(LibModDetails.MODID, name);
        this.setPotionName("effect." + this.getRegistryName().toString());
        iconTexture = new ResourceLocation(LibModDetails.MODID, "textures/potions/" + name + ".png");
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void renderInventoryEffect(final int x, final int y, final PotionEffect effect, final Minecraft mc) {
        if (mc.currentScreen != null) {
            mc.getTextureManager().bindTexture(iconTexture);
            Gui.drawModalRectWithCustomSizedTexture(x + 6, y + 7, 0, 0, 18, 18, 18, 18);
        }
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void renderHUDEffect(final int x, final int y, final PotionEffect effect, final Minecraft mc, final float alpha) {
        mc.getTextureManager().bindTexture(iconTexture);
        Gui.drawModalRectWithCustomSizedTexture(x + 3, y + 3, 0, 0, 18, 18, 18, 18);
    }
}
