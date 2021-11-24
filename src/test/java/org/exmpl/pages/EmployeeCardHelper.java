package org.exmpl.pages;

import org.exmpl.model.Employee;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmployeeCardHelper extends PageBase{
    @FindBy(id = "lastNameFld")
    WebElement lastNameField;
    @FindBy (id = "firstNameFld")
    WebElement firstNameField;
    @FindBy (css = "#jobTitleFld input")
    WebElement inputPositionsField;
    @FindBy (id = "phoneFld")
    WebElement inputPhoneField;
    @FindBy (id = "daysInWeekFld")
    WebElement daysInWeekField;
    @FindBy (id ="shiftDurFld")
    WebElement shiftDurField;
    @FindBy (xpath = "//*[contains(text(),'Сохранить')]/..")
    WebElement saveButton;
    @FindBy (xpath = "//*[contains(text(),'Закрыть')]/..")
    WebElement closeButton;

    public EmployeeCardHelper(WebDriver driver) {
        super(driver);
    }

    public void waitUntilPageIsLoaded(){
       waitUntilElementIsClickable(inputPositionsField,20);
       waitUntilElementIsClickable(inputPhoneField,20);
       // waitUntilElementIsClickable(firstName,20);

    }
    public void fillInAllRequiredFields(Employee empl ){
        //this.fillField(lastField,empl.getSurname());
        //lastField.click();
        this.fillLastNameField(empl.getSurname());
        this.fillFirstNameField(empl.getName());


        this.fillField(inputPositionsField,empl.getPosition());
        // ------- The selenium doesn't fill in the field----
        this.fillField(inputPhoneField,empl.getPhone());
        //inputPhoneField.click();
        //implWait(3000);
        //Keys.HOME
        inputPhoneField.sendKeys( empl.getPhone());
        //implWait(3000);
        //inputPhoneField.sendKeys(Keys.ENTER);
        //implWait(3000);
        daysInWeekField.click();
        implWait(1000);

        //this.fillField(daysInWeekField, ""+ empl.getQuantityDays());
        //this.fillField(shiftDurField, ""+ empl.getShiftHours());

    }

    public void saveEmployee(){
        waitUntilElementIsClickable(saveButton,10);
        saveButton.click();
    }

    private void fillFirstNameField(String name) {
        waitUntilElementIsVisible(firstNameField,10);
        firstNameField.sendKeys(name);
    }

    private void fillLastNameField(String name) {
        waitUntilElementIsVisible(lastNameField,10);
        lastNameField.sendKeys(name);
    }

    public void closeEmployee() {
        closeButton.click();
    }
}
