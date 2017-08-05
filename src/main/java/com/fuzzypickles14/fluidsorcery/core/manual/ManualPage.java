package com.fuzzypickles14.fluidsorcery.core.manual;

import com.fuzzypickles14.fluidsorcery.core.gui.GuiManual;
import com.fuzzypickles14.fluidsorcery.core.manual.button.PageBackButton;
import com.fuzzypickles14.fluidsorcery.core.manual.button.PageForwardButton;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;

import java.io.IOException;

/**
 * Created by Andrew Toomey on 8/4/2017.
 */
public class ManualPage extends GuiManual{
    private GuiScreen previousPage;
    private String info;
    int chapterId;

    public ManualPage(GuiScreen previousPage, String info, int chapterId)
    {
        this.previousPage = previousPage;
        this.info = info;
        this.chapterId = chapterId;
    }

    @Override
    public void initGui()
    {
        this.currentChapter = this.getChapterByButton(this.chapterId);
        if (!this.currentChapter.isLastPage()) {
            this.buttonList.add(this.pageForward = new PageForwardButton(0, (this.width - this.ImageWidth) / 2, 150, 18, 10, "Next", 130));
        }
        this.buttonList.add(this.pageBack = new PageBackButton(0, (this.width - this.ImageWidth)/2, 150, 18, 10,"Back", 40));
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks)
    {
        super.drawScreen(mouseX, mouseY, partialTicks);
        this.drawPopup();
    }

    private void drawPopup()
    {
        this.fontRenderer.drawSplitString(this.info, (this.width - this.ImageWidth)/2 + 50, 35, 100, 0);
    }

    @Override
    protected void actionPerformed(GuiButton button) throws IOException
    {
        if (button == this.pageBack)
        {
            currentChapter.SetPreviousPage();
            this.mc.displayGuiScreen(this.previousPage);
        }
        super.actionPerformed(button);
    }

    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }
}
