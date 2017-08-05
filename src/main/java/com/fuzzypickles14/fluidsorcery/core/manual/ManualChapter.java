package com.fuzzypickles14.fluidsorcery.core.manual;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Andrew Toomey on 8/4/2017.
 */
public class ManualChapter
{
    private ArrayList<ManualPage> ChapterPages;
    private String name;
    private int currentPage = 0;
    public ManualChapter(String name,  ManualPage... Pages)
    {
        this.name = name;
        this.ChapterPages = new ArrayList<ManualPage>();
        Collections.addAll(this.ChapterPages, Pages);
    }

    public ArrayList<ManualPage> getChapterPages() {
        return this.ChapterPages;
    }

    public String getName() {
        return this.name;
    }

    public ManualPage FirstPage()
    {
        this.currentPage = 1;
        return this.ChapterPages.get(0);
    }

    public ManualPage getNextPage()
    {
        if (this.currentPage == this.getChapterPages().size()) {
            System.out.print(this.currentPage);
            return this.ChapterPages.get(this.currentPage - 1);
        }
        return this.ChapterPages.get(this.currentPage++);
    }

    public boolean isLastPage()
    {
        return this.currentPage == this.getChapterPages().size();
    }

    public void SetPreviousPage()
    {
        this.currentPage--;
    }
}
