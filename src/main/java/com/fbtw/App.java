package com.fbtw;


import com.fbtw.web.PathToElements;
import com.fbtw.web.WebExplorer;

import java.io.IOException;


/**
 * Hello world!
 *
 */
public class App 
{
    public static final int TIMEOUT= 70;
    public static void main( String[] args ) throws InterruptedException, IOException {
  /*      Workbook workbook = new HSSFWorkbook();

        FileOutputStream stream = new FileOutputStream("s.xls");

        Sheet lis = workbook.createSheet("shit");

        Row r = lis.createRow(0);
        Cell c = r.createCell(0);
        CellStyle style = workbook.createCellStyle();
      //  style.setFillBackgroundColor(IndexedColors.CORAL.index);


        c.setCellStyle(style);
        c.setCellValue("hello world");



        workbook.write(stream);
        stream.close();*/

        /*ChromeGetter.startDriver();
        ChromeDriver driver = new ChromeDriver(ChromeGetter.getOptions());

        driver.get("https://www.dns-shop.ru/search/?q="+id);



        WebElement element = driver.findElement(By.xpath("//a[@class='avail-text__link ui-link ui-link_blue ui-link_pseudolink']"));
       element.click();

        Thread.sleep(1000);

        WebElement checkBox = driver.findElement(By.xpath("//div[@class='shop-type type-tpShops']"));
        checkBox.click();
        checkBox = driver.findElement(By.xpath("//div[@class='shop-type type-dnsShops']"));
        checkBox.click();

        WebElement el = driver.findElement(By.xpath("//div[@class='base-modal__container base-modal__container_size_md']"));


        String [] str = el.getText().split("\n");
       // div class="shop-type type-tpShops"
        //div class="shop-type type-dnsShops"


        System.out.println(el.getText());*/

        WebExplorer explorer = new WebExplorer();
        int id = 1279787;
        explorer.openPage(PathToElements.SEQARCH_URL+id);
        explorer.clickAndWaitByXPath(PathToElements.TABLE,1000);
        explorer.clickByXPath(PathToElements.CHECKBOX_DNS);
        explorer.clickByXPath(PathToElements.CHECKBOX_TCHNOPOINT);

        String str = explorer.getElementInfo(PathToElements.ELEMENT_WHIS_INFO);

        String s = explorer.getElementInfo(PathToElements.DNS_CODE);

        System.out.println(s);
        System.out.println(str);


    }



}
