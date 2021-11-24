package org.exmpl.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SettingPositionsHelper extends PageBase{
    @FindBy(css = ".p-column-title")
    WebElement title;
    @FindBy(xpath = "//tr[./td]")
    List<WebElement> positionsList;
    @FindBy(css = ".p-button")
    List<WebElement> allButtonLists;

    public SettingPositionsHelper(WebDriver driver) {
        super(driver);
    }
    public void waitUntilPageIsLoaded(){
        waitUntilElementIsVisible(title,10);
        waitUntilAllElementsAreClickable(allButtonLists,15);
        waitUntilAllElementsAreClickable(positionsList,10);
    }
    public String getTitleScreen(){
        return title.getText();
    }

}
