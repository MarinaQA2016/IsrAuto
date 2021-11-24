package org.exmpl.tests;

import org.exmpl.pages.LoginPageHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {
    public static final String LOGIN = "admin";
    public static final String PASSWORD = "hatul";
    WebDriver driver;
    LoginPageHelper loginPage;
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
