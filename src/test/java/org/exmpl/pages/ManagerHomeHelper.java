package org.exmpl.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ManagerHomeHelper extends PageBase {
    @FindBy(xpath = "//a[@href='/summary']")
    WebElement summaryIcon;
    @FindBy(xpath = "(//li[@role='menuitem']/button)[1]")
    WebElement scheduleIcon;
    @FindBy(xpath = "(//li[@role='menuitem']/button)[2]")
    WebElement settingIcon;
    @FindBy(id = "chooseEmployeeFld")
    WebElement employeerField;
    @FindBy(css = "button.p-button")
    WebElement arrowDownEmplButton;
    @FindBy(xpath = "//tr[./td]")
    List<WebElement> summaryLinesList;
    @FindBy(css = ".p-col-5")
    WebElement totalEmplInfo;
    @FindBy(xpath = "//a[@href='/orgunit-list']")
    WebElement departmentMenu;
    @FindBy(xpath = "//a[@href = '/employees-all']")
    WebElement employeesMenu;
    @FindBy(xpath = "//a[@href = '/employees-fired']")
    WebElement employeesFiredMenu;
    @FindBy(xpath = "//a[@href = '/titles-dictionary']")
    WebElement positionsMenu;
    @FindBy(xpath = "//a[@href = '/users']")
    WebElement usersMenu;


    public ManagerHomeHelper(WebDriver driver) {
        super(driver);
    }
     public void waitUntilPageIsLoaded(){
        waitUntilElementIsClickable(summaryIcon,30);
        waitUntilElementIsClickable(scheduleIcon,30);
        waitUntilElementIsClickable(settingIcon,30);
        waitUntilElementIsClickable(employeerField,15);
        waitUntilAllElementsAreClickable(summaryLinesList,10);
        waitUntilElementIsClickable(totalEmplInfo,10);

     }
    public boolean isCorrectPage(){
        return summaryIcon.getText().equals("Сводка");
    }


    public void buildSummary() {
        summaryIcon.click();

    }

    public void fillSummaryParametersDateCurrent(String empl)  {
        //---- current month/year here ----
        waitUntilElementIsClickable(employeerField,20);
        waitUntilElementIsClickable(arrowDownEmplButton,20);
        arrowDownEmplButton.click();
        implWait(500);
        waitUntilAllElementsArePresent(By.xpath("//li[@role='option']"),20);
        WebElement employeer = driver
                .findElement(By.xpath("//li[@role='option'][contains(text(),'"+empl+"')]"));
        employeer.click();
        implWait(500);
        waitUntilElementIsVisible(employeerField,10);
        waitUntilAllElementsAreVisible(summaryLinesList,15);


    }

    public boolean summaryNotEmpty() {

        return summaryLinesList.size()>1
                || !summaryLinesList.get(0).getText().contains("Нет сведений для данного сотрудника");
    }

    public void openDepartmentPage() {
        settingIcon.click();
        waitUntilElementIsClickable(departmentMenu,10);
        departmentMenu.click();

    }

    public void openEmployeesPage() {
        settingIcon.click();
        waitUntilElementIsClickable(employeesMenu,10);
        employeesMenu.click();
    }

    public void openPositionPage() {
        settingIcon.click();
        waitUntilElementIsClickable(positionsMenu,10);
        positionsMenu.click();
    }

    public void openUsersPage() {
        settingIcon.click();
        waitUntilElementIsClickable(usersMenu,10);
        usersMenu.click();
    }
}
