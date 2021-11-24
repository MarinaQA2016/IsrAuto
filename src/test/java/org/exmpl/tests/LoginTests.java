package org.exmpl.tests;

import org.exmpl.pages.LoginPageHelper;
import org.exmpl.pages.ManagerHomeHelper;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{

    LoginPageHelper loginPage;
    ManagerHomeHelper managerHomeHelper;
    @BeforeMethod
    public void initTests(){
        loginPage = PageFactory.initElements(driver, LoginPageHelper.class);
        managerHomeHelper = PageFactory.initElements(driver, ManagerHomeHelper.class);
    }
    @Test
    public void loginTestPositiveAsManager(){
        loginPage.logIn(LOGIN,PASSWORD);
        managerHomeHelper.waitUntilPageIsLoaded();
        Assert.assertTrue(managerHomeHelper.isCorrectPage());

    }


}
