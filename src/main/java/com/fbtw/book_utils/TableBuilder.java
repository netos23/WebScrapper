package com.fbtw.book_utils;

import org.apache.poi.ss.usermodel.*;

public class TableBuilder {

    private Sheet tableSheet;

    private Row[] rows;
    private Cell[][] cels;

    public TableBuilder(Workbook workbook){
        tableSheet = workbook.createSheet();

    }

    public TableBuilder setSize(int w, int h){

        rows = new Row[h];
        cels = new Cell[h][w];

        for(int i=0;i<h;i++){
            rows[i] = tableSheet.createRow(i);
            for(int j=0;j<w;j++){
                    cels[i][j] = rows[i].createCell(j);
            }
        }
        return this;
    }

    public TableBuilder setStyle(CellStyle style, int x1, int x2, int y1, int y2) throws IllegalArgumentException{
        if(x2<x1||x2<0||x1<0||y2<y1||y1<0||y2<0){
            throw new IllegalArgumentException("incorrect coordinate");
        }
        for(int i=y1;i<=y2;i++){
            for(int j=x1;j<=x2;j++){
                cels[i][j].setCellStyle(style);
            }
        }


        return this;
    }

    public TableBuilder setStyle(CellStyle style){
        for(Cell[] row : cels){
            for(Cell c :row){
                c.setCellStyle(style);
            }
        }
        return this;
    }

    public TableBuilder setStyle(CellStyle style,int x1, int y1){
        setStyle(style,x1,x1,y1,y1);
        return this;
    }

    public TableBuilder set(String text, int x, int y){
        cels[y][x].setCellValue(text);
        return this;
    }
    public TableBuilder set(int number, int x, int y){
        cels[y][x].setCellValue(number);
        return this;
    }

    public TableBuilder fill(String text, int x1, int x2, int y1, int y2){

        for(int i=y1;i<=y2;i++){
            for(int j=x1;j<=x2;j++){
                cels[i][j].setCellValue(text);
            }
        }
        return this;
    }

    public TableBuilder applyPatern(TablePatern patern){
        fill(patern.getText(),patern.getBeginX(),patern.getEndX(),patern.getBeginY(),patern.getEndY());
        return this;
    }

    public TableBuilder setColumnWidth(int column, int w){
        tableSheet.setColumnWidth(column,w);
        return this;
    }
    public TableBuilder setColumnWidth(int columnBegin,int columnEnd, int w){
        for(int i=columnBegin;i<columnEnd+1;i++)
        tableSheet.setColumnWidth(i,w);
        return this;
    }



}
