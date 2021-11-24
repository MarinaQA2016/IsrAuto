package org.exmpl.tests;

import org.exmpl.pages.EmployeeCardHelper;
import org.exmpl.pages.LoginPageHelper;
import org.exmpl.pages.ManagerHomeHelper;
import org.exmpl.pages.SettingEmployeesHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class ForMeTests extends TestBase{
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


}
