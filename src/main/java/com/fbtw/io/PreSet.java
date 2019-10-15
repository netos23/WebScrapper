package com.fbtw.io;

import java.util.ArrayList;

public class PreSet {
    private String fileName;

    private ArrayList<String> storeName;
    private ArrayList<String> keyWordsForSearch;

    private String  exportName;

    public PreSet(String fileName, ArrayList<String> storeName, ArrayList<String> keyWordsForSearch, String exportName) {
        this.fileName = fileName;
        this.storeName = storeName;
        this.keyWordsForSearch = keyWordsForSearch;
        this.exportName = exportName;
    }

    public String getFileName() {
        return fileName;
    }

    public ArrayList<String> getStoreName() {
        return storeName;
    }

    public ArrayList<String> getKeyWordsForSearch() {
        return keyWordsForSearch;
    }

    public String getExportName() {
        return exportName;
    }
}
