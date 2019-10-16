package com.fbtw.io;

import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class BookOutputBuilder {

    FileOutputStream outputStream;

    public void print(Workbook workbook, PreSet preSet) throws IOException {
        outputStream = new FileOutputStream(preSet.getExportName());
        workbook.write(outputStream);
    }
}
