package com.fuzzypickles14.fluidsorcery.lib;

import com.fuzzypickles14.fluidsorcery.core.gui.GuiManual;
import com.fuzzypickles14.fluidsorcery.core.manual.ManualChapter;
import com.fuzzypickles14.fluidsorcery.core.manual.ManualPage;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Andrew Toomey on 8/4/2017.
 */
public class LibChapters {
    private static ManualPage Chapter1Page1 = new ManualPage(new GuiManual(), "As you journey through the world you will find pools of naturally occurring magic fluid. These types you will find will be Scorch, Mist, Terrene and Aer", 1);
    private static ManualPage Chapter1Page2 = new ManualPage(Chapter1Page1, "The basic item of this mod is the Stone Gem. To obtain these, mine stone while sneaking", 1);
    private static ManualPage Chapter1Page3 = new ManualPage(Chapter1Page2, "To morph the Stone Gem into something craftable you will need to drop the gem into a pool of magic fluid until it becomes a gem infused with the fluid you used.", 1);
    private static ManualPage Chapter1Page4 = new ManualPage(Chapter1Page3, "This is Page 4", 1);
    private static ManualChapter Chapter1 = new ManualChapter("Chapter 1", Chapter1Page1, Chapter1Page2, Chapter1Page3, Chapter1Page4);


    public static List<ManualChapter> ChapterList = Arrays.asList(Chapter1);
}
