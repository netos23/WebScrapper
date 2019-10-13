package com.fbtw.book_export;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileOutputStream;
import java.io.IOException;

public class BookBuilder {

    private FileOutputStream outputStream;
    private Workbook book;

    public BookBuilder (String filePath) throws IOException {
        book = new HSSFWorkbook();
        outputStream = new FileOutputStream(filePath);
    }

    public void build() throws  IOException{
        book.write(outputStream);
        outputStream.close();
    }

    public Workbook getBook() {
        return book;
    }
}
