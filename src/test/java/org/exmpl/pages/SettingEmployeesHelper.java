package org.exmpl.pages;

import org.exmpl.model.Employee;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.LinkedList;
import java.util.List;

public class SettingEmployeesHelper extends PageBase{
    @FindBy(xpath = "//tr[./td]")
    List<WebElement> employeesList;
    @FindBy(css = ".p-inputtext.p-column-filter")
    List<WebElement> inputForFiltersFieldsList;
    @FindBy(xpath = "(//th[@class='p-sortable-column']/span[@class='p-column-title'])[1]")
    WebElement positionColumnTitle;
    @FindBy(xpath = "(//th[@class='p-sortable-column']/span[@class='p-column-title'])[2]")
    WebElement workPlaceColumnTitle;
    @FindBy(css = ".p-button-rounded")
    WebElement addNewEmployeeButton;
    @FindBy (xpath = "//tr[./td]/td[2]")
    List<WebElement> surnameNameEmplColumnList;

    public SettingEmployeesHelper(WebDriver driver) {
        super(driver);
    }

    public  void waitUntilPageIsLoaded(){
        waitUntilAllElementsAreClickable(inputForFiltersFieldsList,15);
        waitUntilAllElementsAreClickable(employeesList,20);
    }

    public boolean isEmployessPage() {
        return positionColumnTitle.getText().equals("Должность")
                &&workPlaceColumnTitle.getText().equals("Место работы");
    }

    public void createNewEmployee() {
        this.pressCreateEmployeeButton();

        // --- here to describe employee creation process---
        //--- I don't know from what to call the employee and where to use th helper
        //---
        //-----
        //------
    }

    private void pressCreateEmployeeButton() {
        waitUntilElementIsClickable(addNewEmployeeButton,10);
        addNewEmployeeButton.click();
    }


    public boolean existsSuchEmployee(Employee empl) {
        boolean res = false;
        implWait(1000);
        waitUntilAllElementsAreVisible(employeesList,10);
        for (WebElement element : surnameNameEmplColumnList){
            if (element.getText().equals(empl.getSurname()+" " + empl.getName()))
                res = true;
        }

        return res;
    }


}
