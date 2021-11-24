package org.exmpl.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SettingDepartmentsHelper extends PageBase{
    @FindBy(xpath="//tr")
    List<WebElement> departmentsList;
    @FindBy(xpath = "//tr/td[1]")
    List<WebElement> departmentNamesList;
    @FindBy(xpath = "button.p-button-secondary")
    List<WebElement> xDepartmentList;
    @FindBy (xpath = "(//div[@class='card-title'])[1]")
    WebElement title;
    @FindBy (id = "btnCreateOrgUnit")
    WebElement addDepartmentButton;
    @FindBy (id = "orgUnitNameFld")
    WebElement nameDepartmentEditField;
    @FindBy (id = "btnOrgUnitSave")
    WebElement saveDepartmentButton;


    public SettingDepartmentsHelper(WebDriver driver) {
        super(driver);
    }

    public void waitUntilPageIsLoaded(){
        waitUntilTextToBePresentInElement(title,"Подразделение",10);
        //---- wait that the departments list started to load----
        waitUntilNumberOfElementsToBeMore(By.xpath("//tr"),2,15);
        waitUntilAllElementsAreClickable(departmentNamesList,20);
    }

    public String getTitleScreen(){
        return title.getText();
    }

    public void firstDepartmentClick() {
        //departmentsList.get(0).click();
        //waitUntilElementIsClickable(By.xpath("(//tr)[1]"),20);

        departmentNamesList.get(0).click();


    }

    public void addNewDepartment(String name){
        int departmentsQuantityBeg = departmentNamesList.size();
        firstDepartmentClick();
        waitUntilElementIsClickable(addDepartmentButton,10);
        addDepartmentButton.click();
        waitUntilElementIsClickable(nameDepartmentEditField,10);
        fillField(nameDepartmentEditField, name);
        waitUntilElementIsClickable(saveDepartmentButton,10);
        saveDepartmentButton.click();
        //------ wait until department items are more then...
        waitUntilNumberOfElementsToBeMore(By.xpath("//tr"),departmentsQuantityBeg+1,10);
        waitUntilAllElementsAreClickable(departmentNamesList,10);

    }

    public boolean existsDepartment(String nameDepartment) {
        boolean res = false;
        for(WebElement element: departmentNamesList){
            if(element.getText().equals(nameDepartment)) res=true;
        }
        return res;
    }


}
