package com.fuzzypickles14.fluidsorcery.core.gui;

import com.fuzzypickles14.fluidsorcery.core.manual.ManualChapter;
import com.fuzzypickles14.fluidsorcery.core.manual.ManualPage;
import com.fuzzypickles14.fluidsorcery.core.manual.button.ChapterButton;
import com.fuzzypickles14.fluidsorcery.core.manual.button.PageBackButton;
import com.fuzzypickles14.fluidsorcery.core.manual.button.PageForwardButton;
import com.fuzzypickles14.fluidsorcery.lib.LibChapters;
import com.fuzzypickles14.fluidsorcery.lib.LibModDetails;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;

import java.io.IOException;
import java.util.List;

/**
 * Created by Andrew Toomey on 8/4/2017.
 */
public class GuiManual extends GuiScreen {
    protected int ImageWidth = 192;
    protected int ImageHeigth = 192;

    public static final ResourceLocation texture = new ResourceLocation(LibModDetails.MODID + ":textures/gui/ManualGui.png");

    protected ManualChapter currentChapter;
    protected PageBackButton pageBack;
    protected PageForwardButton pageForward;

    protected static List<ManualChapter> chapters = LibChapters.ChapterList;

    private int guiWidth = 0;


    @Override
    public void initGui()
    {
        guiWidth = (this.width - this.ImageWidth) / 2;
        int buttonId = 1;
        int yPosition = 50;
        for (ManualChapter chapter : chapters)
        {
            this.buttonList.add(new ChapterButton(buttonId, guiWidth, yPosition, 40, 5,String.format("Chapter %d", buttonId), 40));
            yPosition += 20;
            buttonId++;
        }
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks)
    {
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(texture);
        guiWidth =  (this.width - this.ImageWidth) / 2;
        int j = 2;
        for (GuiButton button: buttonList)
        {
            if (button instanceof ChapterButton)
            {
                button.x = guiWidth + ((ChapterButton)button).getOffset();
            }
        }
        this.drawTexturedModalRect(guiWidth, j, 0, 0, this.ImageWidth, this.ImageHeigth);
        this.fontRenderer.drawString("Fluimancer's Manual", guiWidth + 40, j + 20, 0);
        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    @Override
    protected void actionPerformed(GuiButton button) throws IOException
    {
        if (button.id >= 1)
        {
            this.currentChapter = this.getChapterByButton(button.id);
            this.mc.displayGuiScreen(currentChapter.FirstPage());
        }
        else if (button == this.pageForward)
        {
            this.mc.displayGuiScreen(currentChapter.getNextPage());
        }
    }

    protected ManualChapter getChapterByButton(int id)
    {
        return chapters.get(id - 1);
    }

    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }
}
