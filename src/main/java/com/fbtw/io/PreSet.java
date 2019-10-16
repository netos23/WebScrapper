package com.fbtw.io;

import java.io.Serializable;
import java.util.ArrayList;

public class PreSet implements Serializable {

    private static final long serialVersionUID = 1L;

    // private String fileName;

    private ArrayList<String> storeName;
    private ArrayList<String> keyWordsForSearch;

    private String  exportName;
    private String tablePaternName;

    public PreSet(/*String fileName,*/ ArrayList<String> storeName, ArrayList<String> keyWordsForSearch, String exportName, String tablePaternName) {
        //this.fileName = fileName;
        this.storeName = storeName;
        this.keyWordsForSearch = keyWordsForSearch;
        this.exportName = exportName;
        this.tablePaternName = tablePaternName;
    }

  /*  public String getFileName() {
        return fileName;
    }*/

    public ArrayList<String> getStoreName() {
        return storeName;
    }

    public ArrayList<String> getKeyWordsForSearch() {
        return keyWordsForSearch;
    }

    public String getExportName() {
        return exportName;
    }

    public String getTablePaternName() {
        return tablePaternName;
    }
}

