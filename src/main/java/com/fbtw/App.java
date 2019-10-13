package com.fbtw;

import com.fbtw.chrome_driver.ChromeGetter;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

        ChromeGetter.startDriver();
        ChromeDriver driver = new ChromeDriver(ChromeGetter.getOptions());
        int id = 1279787;
        driver.get("https://www.dns-shop.ru/search/?q="+id);

        Wait<WebDriver> wait = new WebDriverWait(driver,TIMEOUT);

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


        System.out.println(el.getText());
    }



}
