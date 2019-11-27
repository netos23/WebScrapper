package com.fbtw.io;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileInputStream;
import java.io.IOException;

public class BookLoader {
    private Workbook workbook;
    private FileInputStream inputStream;

    public  BookLoader(String fileName)throws IOException {
        workbook = new HSSFWorkbook(new FileInputStream(fileName));
    }

    public Workbook getWorkbook() {
        return workbook;
    }
}
