package com.fbtw.book_export;

import org.apache.poi.ss.usermodel.*;

public class StyleBuilder {

    private CellStyle style;

    public StyleBuilder(Workbook workbook){
        style =  workbook.createCellStyle();

    }


   public  CellStyle buildNormal(){
        setBorder();
       return  style;
   }

   public CellStyle buildItalic(){
        setBorder();
        setColour();
        return style;
   }

   private void setColour(){
       style.setFillForegroundColor(IndexedColors.CORAL.index);
       style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
   }

   private void setBorder(){
       style.setBorderBottom(BorderStyle.THIN);
       style.setBorderTop(BorderStyle.THIN);
       style.setBorderLeft(BorderStyle.THIN);
       style.setBorderRight(BorderStyle.THIN);
   }


}
