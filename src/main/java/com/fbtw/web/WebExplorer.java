package com.fbtw.web;

import com.fbtw.chrome_driver.ChromeGetter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebExplorer {
    private ChromeDriver driver;
    public static final int TIMEOUT = 70;

    public WebExplorer(){
        ChromeGetter.startDriver();
        driver = new ChromeDriver(ChromeGetter.getOptions());
        Wait<WebDriver> wait = new WebDriverWait(driver,TIMEOUT);
    }

    public void clickByXPath(String xpath){
        WebElement el  = driver.findElement(By.xpath(xpath));
        el.click();
    }

    public void clickAndWaitByXPath(String xpath,long milis) throws InterruptedException {
        clickByXPath(xpath);
        Thread.sleep(milis);
    }


    public WebElement getByXPath(String xpath){
        return  driver.findElement(By.xpath(xpath));
    }

    public String getElementInfo(WebElement element){
        return  element.getText();
    }

    public String getElementInfo(String xpath){
      return   getByXPath(xpath).getText();
    }

    public void openPage(String url){
        driver.get(url);
    }

    public void closePage(){
        driver.close();
    }

}
