package org.exmpl.tests;

import org.exmpl.pages.LoginPageHelper;
import org.exmpl.pages.ManagerHomeHelper;
import org.exmpl.pages.SettingDepartmentsHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SettingsDepartmentTests extends TestBase{
    LoginPageHelper loginPage;
    ManagerHomeHelper managerHomePage;
    SettingDepartmentsHelper settingDepartment;

    @BeforeMethod
    public void initTests(){
        loginPage = PageFactory.initElements(driver, LoginPageHelper.class);
        managerHomePage = PageFactory.initElements(driver, ManagerHomeHelper.class);
        settingDepartment = PageFactory.initElements(driver, SettingDepartmentsHelper.class);

        loginPage.logIn(LOGIN,PASSWORD);
        managerHomePage.waitUntilPageIsLoaded();
        managerHomePage.openDepartmentPage();
        settingDepartment.waitUntilPageIsLoaded();
    }


    @Test
    public void createNewDepartment(){
        String nameDepartment = "newDep" + System.currentTimeMillis();
        settingDepartment.addNewDepartment(nameDepartment);
        Assert.assertTrue(settingDepartment.existsDepartment(nameDepartment));
    }
}
