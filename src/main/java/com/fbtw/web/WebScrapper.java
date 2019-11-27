package com.fbtw.web;

import com.fbtw.io.PreSet;

import java.util.ArrayList;

public class WebScrapper {
    private WebExplorer explorer;

    public WebScrapper(){
        explorer = new WebExplorer();
    }

    public String[] collect(PreSet preSet) throws InterruptedException {

        ArrayList<String> codes = preSet.getKeyWordsForSearch();
        int count = codes.size();
        String[] responses = new String[count];
        String id;

        for(int i=0;i<count;i++){

            id = codes.get(i);
            explorer.openPage(PathToElements.SEQARCH_URL+id);
            Thread.sleep(1500);
            boolean confirm1 = true;
            int counter = 0;
            while (confirm1) {
                try {
                    explorer.clickAndWaitByXPath(PathToElements.TABLE, 1000);
                    confirm1 = false;
                }catch (Exception ex){
                    counter++;
                    System.out.println(id+" track 1 "+counter );
                    Thread.sleep(2000);
                    if(counter>3) throw new RuntimeException("out of conection");

                }
            }
            boolean confirm2 = true;
            int counter2 = 0;
            while (confirm2) {
                try {
                    explorer.clickByXPath(PathToElements.CHECKBOX_DNS);
                    confirm2 = false;
                }catch (Exception ex){
                    counter2++;
                    System.out.println(id+" track 2 "+counter2 );
                    if(counter2>3) throw new RuntimeException("out of conection");
                    Thread.sleep(1000);
                }
            }
            boolean confirm3 = true;
            int counter3 = 0;
            while (confirm3) {
                try {
                    explorer.clickByXPath(PathToElements.CHECKBOX_TCHNOPOINT);
                    confirm3 = false;
                }catch (Exception ex){
                    counter3++;
                    System.out.println(id+" track 2 "+counter3 );
                    if(counter3>3) throw new RuntimeException("out of conection");
                    Thread.sleep(1000);
                }
            }




           responses[i] = explorer.getElementInfo(PathToElements.ELEMENT_WHIS_INFO);
           responses[i] += "\n" + explorer.getElementInfo(PathToElements.DNS_CODE);



        }

        explorer.closePage();

        return responses;
    }
    public String[] collect(ArrayList<String> ids) throws InterruptedException {

        ArrayList<String> codes =   ids;
        int count = codes.size();
        String[] responses = new String[count];
        String id;

        for(int i=0;i<count;i++){

            id = codes.get(i);
            explorer.openPage(PathToElements.SEQARCH_URL+id);
            Thread.sleep(1500);
            boolean confirm1 = true;
            int counter = 0;
            while (confirm1) {
                try {
                    explorer.clickAndWaitByXPath(PathToElements.TABLE, 1000);
                    confirm1 = false;
                }catch (Exception ex){
                    counter++;
                    System.out.println(id+" track 1 "+counter );
                    Thread.sleep(2000);
                    if(counter>3) throw new RuntimeException("out of conection");

                }
            }
            boolean confirm2 = true;
            int counter2 = 0;
            while (confirm2) {
                try {
                    explorer.clickByXPath(PathToElements.CHECKBOX_DNS);
                    confirm2 = false;
                }catch (Exception ex){
                    counter2++;
                    System.out.println(id+" track 2 "+counter2 );
                    if(counter2>3) throw new RuntimeException("out of conection");
                    Thread.sleep(1000);
                }
            }
            boolean confirm3 = true;
            int counter3 = 0;
            while (confirm3) {
                try {
                    explorer.clickByXPath(PathToElements.CHECKBOX_TCHNOPOINT);
                    confirm3 = false;
                }catch (Exception ex){
                    counter3++;
                    System.out.println(id+" track 2 "+counter3 );
                    if(counter3>3) throw new RuntimeException("out of conection");
                    Thread.sleep(1000);
                }
            }




           responses[i] = explorer.getElementInfo(PathToElements.ELEMENT_WHIS_INFO);
           responses[i] += "\n" + explorer.getElementInfo(PathToElements.DNS_CODE);



        }

        explorer.closePage();

        return responses;
    }


}
