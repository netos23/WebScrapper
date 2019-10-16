package com.fbtw.core;

import com.fbtw.book_utils.StyleBuilder;
import com.fbtw.book_utils.TableBuilder;
import com.fbtw.book_utils.TablePatern;
import com.fbtw.io.BookOutputBuilder;
import com.fbtw.io.PreSet;
import com.fbtw.io.TablePaternLoader;
import com.fbtw.web.WebScrapper;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;


public class DataParser {

    private static final int OFFSET_X = 1;
    private static final int OFFSET_Y = 2;

    private static final String INTRO = "DNS Гипер ";

    private TableBuilder tableBuilder;
    private StyleBuilder styleBuilder;
    private WebScrapper webScrapper;

    private ArrayList<ItemInfo> itemInfos;
    private Workbook workbook;

    private BookOutputBuilder bookOutputBuilder;
    private TablePaternLoader paternLoader;
    private TablePatern [] paterns;

    private PreSet preSet;

    public DataParser(PreSet preSet){
        this.preSet = preSet;
        workbook = new HSSFWorkbook();
        webScrapper = new WebScrapper();
        itemInfos = new ArrayList<>();
        tableBuilder = new TableBuilder(workbook);
        bookOutputBuilder = new BookOutputBuilder();
        paternLoader = new TablePaternLoader();
        styleBuilder = new StyleBuilder();
    }

    private void assembleTable() throws FileNotFoundException {
        int h = preSet.getStoreName().size()+OFFSET_Y;
        int w = preSet.getKeyWordsForSearch().size()+OFFSET_X;

        // FIXME: офсеты переместить в пресет
        tableBuilder.setSize(w,h);

        CellStyle defoultStyle = styleBuilder.buildNormal(workbook);
        tableBuilder.setStyle(defoultStyle);

        CellStyle higthLigth = styleBuilder.buildItalic(workbook);
        tableBuilder.setStyle(higthLigth,OFFSET_X,w-1,0,0);

        paterns = paternLoader.load(preSet.getTablePaternName());
        tableBuilder.setColumnWidth(OFFSET_X,w-1,2500);

        for(TablePatern patern : paterns){
            tableBuilder.applyPatern(patern);
        }

        tableBuilder.setColumnWidth(0,6500);

    }

    private void convertData() throws InterruptedException {
      String[] datas = webScrapper.collect(preSet);
      for(String data : datas){
          itemInfos.add(new ItemInfo(data));
      }
    }

   private void fillHead(){
        ItemInfo tmp = itemInfos.get(0);

        for(int i=OFFSET_Y;i<preSet.getStoreName().size()+OFFSET_Y;i++){
            ItemInfo.StoreInfo  stores =  tmp.getStoreInfo(preSet.getStoreName().get(i-OFFSET_Y));
            tableBuilder.set(INTRO+stores.getName()+"\n"+stores.getAdress(),0,i);
        }
   }

   private void fillTable(){
        int maxI = preSet.getKeyWordsForSearch().size() + OFFSET_X;
        String text = "";
        for(int i=OFFSET_X;i<maxI;i++){
            text = itemInfos.get(i-OFFSET_X).getName() + ItemInfo.DNS_CODE_TEXT + itemInfos.get(i-OFFSET_X).getDnsCode();
            tableBuilder.set(text,i,0);
            for(int j=OFFSET_Y;j<preSet.getStoreName().size()+OFFSET_Y;j++){
                ItemInfo.StoreInfo  stores =  itemInfos.get(i-OFFSET_X).getStoreInfo(preSet.getStoreName().get(j-OFFSET_Y));

                int res;

                try {
                    res = Integer.parseInt(stores.count);
                }catch (NumberFormatException ex){
                    res =0;
                }

                tableBuilder.set(res,i,j);
            }
        }
   }


   private void buid() throws IOException {
        bookOutputBuilder.print(workbook,preSet);
   }


   public void parse() throws IOException, InterruptedException {
       assembleTable();
       convertData();
       fillHead();
       fillTable();
     buid();
   }

}
