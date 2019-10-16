package com.fbtw.chrome_driver;


import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeGetter {
    private static String CHROME_PATH = "chromedriver.exe";


    public static void startDriver(){
        System.setProperty("webdriver.chrome.driver",CHROME_PATH);
    }
    public static ChromeOptions getOptions(){
        ChromeOptions options = new ChromeOptions()
                .addArguments("--lang=ru")
                .addArguments("start-maximized");
              //  .addArguments("headless");
        return options;

    }
}
