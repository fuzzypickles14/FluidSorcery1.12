package com.fuzzypickles14.fluidsorcery.core.manual.button;

import com.fuzzypickles14.fluidsorcery.lib.LibModDetails;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;

import java.awt.*;

/**
 * Created by Andrew Toomey on 8/4/2017.
 */
public class PageBackButton extends ModButton {
    private static final ResourceLocation buttonTextures = new ResourceLocation(LibModDetails.MODID + ":textures/gui/ManualGui.png");
    protected int ImageWidth, ImageHeight, ImageWidthChanged;

    public PageBackButton(int buttonId, int x, int y, int widthIn, int heightIn, String buttonText, int offset) {
        super(buttonId, x, y, widthIn, heightIn, buttonText, offset);
        this.ImageWidth = 3;
        this.ImageWidthChanged = 26;
        this.ImageHeight = 207;
    }

    @Override
    public void drawButton(Minecraft mc, int mouseX, int mouseY, float partialTicks)
    {
        if(this.visible) {
            mc.getTextureManager().bindTexture(buttonTextures);
            GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
            this.hovered = mouseX >= this.x && mouseY >= this.y && mouseX < this.x + this.width && mouseY < this.y + this.height;
            int i = this.getHoverState(this.hovered);
            GlStateManager.enableBlend();
            GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
            GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
            this.drawTexturedModalRect(this.x, this.y, this.ImageWidth, this.ImageHeight, this.width, this.height);
            if (this.hovered) {
                mc.fontRenderer.drawString(this.displayString, (this.x), this.y + (this.height - 8) / 2, Color.blue.getRGB());
            }
            this.mouseDragged(mc, mouseX, mouseY);
        }
    }
}
