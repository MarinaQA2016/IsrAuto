package org.exmpl.tests;

import org.exmpl.pages.LoginPageHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.PrintStream;

public class TestBase {
    public static final String LOGIN = "admin";
    public static final String PASSWORD = "hatul";
    WebDriver driver;
    LoginPageHelper loginPage;
    @BeforeSuite
    public void encodingSet(){
        String consoleEncoding = System.getProperty("consoleEncoding");
        if (consoleEncoding != null) {
            try {
                System.setOut(new PrintStream(System.out, true, consoleEncoding));
            } catch (java.io.UnsupportedEncodingException ex) {
                System.err.println("Unsupported encoding set for console: "+consoleEncoding);
            }
        }
    }
    @BeforeMethod
    public void startUp(){
        driver = new ChromeDriver();
        loginPage = PageFactory.initElements(driver, LoginPageHelper.class);
        driver.manage().window().maximize();
        driver.get("https://isra.sclub.in.ua/");
        loginPage.waitUntilPageIsLoaded();

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
