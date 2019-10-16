package com.fbtw.book_utils;

import java.io.Serializable;

public class TablePatern {
    private String text;
    private int beginX;
    private int endX;
    private int beginY;
    private int endY;

    public TablePatern(String text, int x, int y)  {
        this.text = text;
        this.beginX = x;
        this.beginY = y;
        endX = x;
        endY = y;
    }

    public TablePatern(String text, int beginX, int endX, int beginY, int endY) {
        this.text = text;
        this.beginX = beginX;
        this.endX = endX;
        this.beginY = beginY;
        this.endY = endY;
    }

    public TablePatern(String text, final int[] coordinats) {
        this.text = text;
        this.beginX = coordinats[0];
        this.endX = coordinats[1];
        this.beginY = coordinats[2];
        this.endY = coordinats[3];

    }

    public String getText() {
        return text;
    }

    public int getBeginX() {
        return beginX;
    }

    public int getEndX() {
        return endX;
    }

    public int getBeginY() {
        return beginY;
    }

    public int getEndY() {
        return endY;
    }

    @Override
    public String toString() {
        return text +"\n" + beginX +"\n" + endX +"\n" + beginY +"\n" + endY +"\n";
    }
}
