package org.exmpl.tests;

import org.exmpl.model.Employee;
import org.exmpl.pages.*;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SettingEmployeesTests extends TestBase{
    LoginPageHelper loginPage;
    ManagerHomeHelper managerHomePage;
    SettingEmployeesHelper settingEmployees;
    EmployeeCardHelper employeeCard;

    @BeforeMethod
    public void initTests(){
        loginPage = PageFactory.initElements(driver, LoginPageHelper.class);
        managerHomePage = PageFactory.initElements(driver, ManagerHomeHelper.class);
        settingEmployees = PageFactory.initElements(driver, SettingEmployeesHelper.class);
        employeeCard = PageFactory.initElements(driver,EmployeeCardHelper.class);

        loginPage.logIn(LOGIN,PASSWORD);
        managerHomePage.waitUntilPageIsLoaded();
        managerHomePage.openEmployeesPage();
        settingEmployees.waitUntilPageIsLoaded();
    }

    @Test
    public void createNewEmployee(){
       Employee ivanPetroff = new Employee("Ageev","IIvan","Продавец","0535299971");
        System.out.println("new empl: " + ivanPetroff.toString());
        settingEmployees.createNewEmployee();
        employeeCard.waitUntilPageIsLoaded();
        employeeCard.fillInAllRequiredFields(ivanPetroff);
        employeeCard.saveEmployee();
        employeeCard.closeEmployee();
        settingEmployees.waitUntilPageIsLoaded();
        settingEmployees.refreshWindow();
        settingEmployees.waitUntilPageIsLoaded();
        Assert.assertTrue(settingEmployees.existsSuchEmployee(ivanPetroff));



    }

    }
