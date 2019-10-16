package com.fbtw.core;

import com.fbtw.web.PathToElements;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class ItemInfo {

    private static final String COUNT_SYMBOL_1 = ":";
    private static final String COUNT_SYMBOL_2 = "шт";
    public static final String DNS_CODE_TEXT = " код днс: ";

    class StoreInfo {


        String name;
        String adress;
        String count;

        StoreInfo(String name, String adress, @NotNull String count) {
            this.name = name;
            this.adress = adress;

            int endIndex = count.indexOf(COUNT_SYMBOL_2);
            int beginIndex = count.indexOf(COUNT_SYMBOL_1);

            if (endIndex > 0) {
                this.count = count.substring(beginIndex + 1, endIndex).trim();

            } else {
                //this.count = count.substring(beginIndex + 1).trim();
                this.count = "0";
            }

        }

        public String getName() {
            return name;
        }

        public String getAdress() {
            return adress;
        }

        public String getCount() {
            return count;
        }
    }

    private ArrayList<StoreInfo> storeInfos;
    private String dnsCode;
    private String name;

    public ItemInfo(@NotNull String data) {
        storeInfos = new ArrayList<>();
        String[] lines = data.split("\n");

        String name = "", address = "", count = "";
        int j = 0;

        for (int i = 9; i < lines.length - 5; i++) {
            switch (j) {
                case 0:
                    name = lines[i];
                    j++;
                    break;
                case 1:
                    address = lines[i];
                    j++;
                    break;
                case 2:
                    j++;
                    break;
                case 3:
                    j++;
                    break;
                case 4:
                    count = lines[i];
                    j = 0;
                    storeInfos.add(new StoreInfo(name, address, count));
                    break;

            }
        }

        if (lines[lines.length - 5].contains("[")){
            this.name = lines[lines.length - 6];
        }else{
            this.name = lines[lines.length-5];
        }

        dnsCode = lines[lines.length - 1];
    }

    public StoreInfo getStoreInfo(String storeName) {
        for (StoreInfo info : storeInfos) {
            if (info.name.equals(storeName)) {

                return info;
            }
        }

        return null;
    }

    public ArrayList<StoreInfo> getStoreInfos() {
        return storeInfos;
    }

    public String getDnsCode() {
        return dnsCode;
    }

    public String getName() {
        return name;
    }
}
