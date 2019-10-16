package com.fbtw.book_utils;

import org.apache.poi.ss.usermodel.*;

public class StyleBuilder {

   public  CellStyle buildNormal(Workbook workbook){
       CellStyle style = workbook.createCellStyle();
        setAligementCentr(style);
        setWrap(style);
        setThinBorder(style);
        setVerticalAligmentCentr(style);
       return  style;
   }

   public CellStyle buildItalic(Workbook workbook) {
       CellStyle style = workbook.createCellStyle();
       setWrap(style);
       setAligementCentr(style);
       setThinBorder(style);
       setColour(style);
       setVerticalAligmentCentr(style);
       return style;
   }

   private void setColour(CellStyle style){
       style.setFillForegroundColor(IndexedColors.CORAL.index);
       style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
   }

   private void setThinBorder(CellStyle style){
       style.setBorderBottom(BorderStyle.THIN);
       style.setBorderTop(BorderStyle.THIN);
       style.setBorderLeft(BorderStyle.THIN);
       style.setBorderRight(BorderStyle.THIN);
   }

    private void setWrap(CellStyle style){
        style.setWrapText(true);
    }

    private void setAligementCentr(CellStyle style){
        style.setAlignment(HorizontalAlignment.CENTER);
    }

    private void setVerticalAligmentCentr(CellStyle style){
       style.setVerticalAlignment(VerticalAlignment.CENTER);
    }




}
