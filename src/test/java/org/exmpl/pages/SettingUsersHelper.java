package org.exmpl.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SettingUsersHelper extends PageBase{
    @FindBy (css = ".p-card-title")
    WebElement title;
    @FindBy (xpath = "//tr[./td]")
    List<WebElement> usersList;

    public SettingUsersHelper(WebDriver driver) {
        super(driver);
    }
    public void waitUntilPageIsLoaded(){
        waitUntilElementIsVisible(title,20);
        waitUntilAllElementsAreClickable(usersList,10);
    }

    public String getTitleScreen() {
        return title.getText();
    }
}
