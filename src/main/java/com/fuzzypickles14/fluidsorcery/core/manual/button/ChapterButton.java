package com.fuzzypickles14.fluidsorcery.core.manual.button;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.GlStateManager;

import java.awt.*;

/**
 * Created by Andrew Toomey on 8/4/2017.
 */
public class ChapterButton extends ModButton {
    public ChapterButton(int buttonId, int x, int y, int widthIn, int heightIn, String buttonText, int offset) {
        super(buttonId, x, y, widthIn, heightIn, buttonText, offset);
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
            fontrenderer.drawString(this.displayString, (this.x), this.y + (this.height - 8) / 2, j);
        }
    }
}
