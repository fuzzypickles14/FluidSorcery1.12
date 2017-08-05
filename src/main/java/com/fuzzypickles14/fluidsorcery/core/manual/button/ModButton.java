package com.fuzzypickles14.fluidsorcery.core.manual.button;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.GlStateManager;

import java.awt.*;

/**
 * Created by Andrew Toomey on 8/4/2017.
 */
public class ModButton extends GuiButton {

    private int offset;
    public ModButton(int buttonId, int x, int y, int widthIn, int heightIn, String buttonText)
    {
        super(buttonId, x, y, widthIn, heightIn, buttonText);
    }

    public ModButton(int buttonId, int x, int y, int widthIn, int heightIn, String buttonText, int offset)
    {
        super(buttonId, x + offset, y, widthIn, heightIn, buttonText);
        this.offset = offset;
    }

    public int getOffset()
    {
        return this.offset;
    }

    protected void drawButtonLogic(Minecraft mc, int mouseX, int mouseY) {
        mc.getTextureManager().bindTexture(BUTTON_TEXTURES);
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        this.hovered = mouseX >= this.x && mouseY >= this.y && mouseX < this.x + this.width && mouseY < this.y + this.height;
        GlStateManager.enableBlend();
        GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
        GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
        this.mouseDragged(mc, mouseX, mouseY);
    }

    @Override
    public void drawButton(Minecraft mc, int mouseX, int mouseY, float partialTicks)
    {
        if(this.visible) {
            FontRenderer fontrenderer = mc.fontRenderer;
            drawButtonLogic(mc, mouseX, mouseY);
            int j = Color.black.getRGB();
            if (this.hovered) {
                j = Color.blue.getRGB();
            }
            fontrenderer.drawString(this.displayString, (this.x + this.width) / 2 + 55, this.y + (this.height - 8) / 2, j);
        }
    }
}
