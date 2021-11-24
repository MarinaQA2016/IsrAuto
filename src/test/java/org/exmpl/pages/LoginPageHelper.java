package org.exmpl.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class LoginPageHelper extends PageBase{


    public LoginPageHelper(WebDriver driver) {
        super(driver);
    }
    @FindBy (id = "username") WebElement loginField;
    @FindBy (id = "password") WebElement passwordField;
    @FindBy (css = ".p-button") List<WebElement> loginButtonsList;



    public void waitUntilPageIsLoaded(){
        waitUntilElementIsClickable(loginButtonsList.get(0),30);
        waitUntilElementIsClickable(loginButtonsList.get(1),30);
    }
    public void logIn(String login, String pass){
        fillField(loginField,login);
        fillField(passwordField,pass);
        loginButtonsList.get(1).click();
    }




}
