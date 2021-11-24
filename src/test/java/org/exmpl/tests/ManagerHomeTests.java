package org.exmpl.tests;

import org.exmpl.pages.*;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ManagerHomeTests extends TestBase{
    LoginPageHelper loginPage;
    ManagerHomeHelper managerHomePage;
    SettingDepartmentsHelper settingDepartment;
    SettingEmployeesHelper settingEmployees;
    SettingPositionsHelper settingPositions;
    SettingUsersHelper settingUsers;

    @BeforeMethod
    public void initTests(){
        loginPage = PageFactory.initElements(driver, LoginPageHelper.class);
        managerHomePage = PageFactory.initElements(driver, ManagerHomeHelper.class);
        settingDepartment = PageFactory.initElements(driver, SettingDepartmentsHelper.class);
        settingEmployees = PageFactory.initElements(driver, SettingEmployeesHelper.class);
        settingPositions = PageFactory.initElements(driver, SettingPositionsHelper.class);
        settingUsers = PageFactory.initElements(driver, SettingUsersHelper.class);
        loginPage.logIn(LOGIN,PASSWORD);
        managerHomePage.waitUntilPageIsLoaded();
    }

    @Test
    public void summarySmokeTest(){
        managerHomePage.buildSummary();
        managerHomePage.waitUntilPageIsLoaded();
        managerHomePage.fillSummaryParametersDateCurrent("Дорош");
        Assert.assertTrue(managerHomePage.summaryNotEmpty());
    }

    @Test
    public void openDepartmentPageTest(){
        managerHomePage.openDepartmentPage();
        settingDepartment.waitUntilPageIsLoaded();
        Assert.assertEquals("Подразделение", settingDepartment.getTitleScreen());
    }

    @Test
    public void openEmployeesPageTest(){
        managerHomePage.openEmployeesPage();
        settingEmployees.waitUntilPageIsLoaded();
        Assert.assertTrue(settingEmployees.isEmployessPage());
    }

    @Test
    public void openPositionsPageTest(){
        managerHomePage.openPositionPage();
        settingPositions.waitUntilPageIsLoaded();
        Assert.assertEquals("Название должности",settingPositions.getTitleScreen());
    }
    @Test
    public void openUsersPageTest(){
        managerHomePage.openUsersPage();
        settingUsers.waitUntilPageIsLoaded();
        Assert.assertEquals("Данные пользователя", settingUsers.getTitleScreen());

    }
}
