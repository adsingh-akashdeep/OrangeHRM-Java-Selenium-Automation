package testClasses;

import base.BaseClass;
import constants.AppConstants;
import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ConfigReader;

import java.util.List;
import java.util.WeakHashMap;

public class LoginPageTest extends BaseClass {
    String username = ConfigReader.getProperty("username");
    String password = ConfigReader.getProperty("password");

    @Test(priority = 0, groups = {"Smoke"})
    @Description("Verify that user can log in with the valid credentials")
    public void verifySuccessfulLoginRedirectsToDashboardPage() {
        waitUtils.waitForElementToBeClickable(pageObjectManager.getLoginPage().getLoginButton());
        pageObjectManager.getLoginPage().doLogin(username,password);
        waitUtils.waitForTitleToBe(AppConstants.HomePageTitle);
        Assert.assertEquals("OrangeHRM", AppConstants.HomePageTitle, "Titles should be matched");
        System.out.println(AppConstants.HomePageTitle);
    }

    @Test(priority = 1, groups = {"Smoke"})
    @Description("Verify that user can see the logo when landed at loginPage")
    public void verifyOrangeHRMLogoIsDisplayedInLoginPage(){
        waitUtils.waitForElementToBeVisible(pageObjectManager.getLoginPage().getLogo());
        Assert.assertTrue(pageObjectManager.getLoginPage().logoDisplay(driver), "Logo should be displayed");
    }

    @Test(priority = 2, groups = {"Smoke"})
    @Description("Verify that user can see the credentials sample to login")
    public void verifySampleCredentialsDisplayedAtLoginPage() {
        waitUtils.waitForElementToBeVisible(pageObjectManager.getLoginPage().getCredentialsUsername());
        waitUtils.waitForElementToBeVisible(pageObjectManager.getLoginPage().getCredentialsPassword());
        String[] creds =(pageObjectManager.getLoginPage().credentialsSampleDisplay());
        Assert.assertEquals(creds[0], "Username : Admin");
        Assert.assertEquals(creds[1], "Password : admin123");
        System.out.println(creds[0]);
        System.out.println(creds[1]);
    }

    @Test(priority = 3, groups = {"Smoke"})
    @Description("Verify that user can't login with empty credential boxes")
    public void verifyEmptyCredentialInputsFailsLogin(){
        waitUtils.waitForElementToBeClickable(pageObjectManager.getLoginPage().getLoginButton());
        pageObjectManager.getLoginPage().doLogin("","");
        List<WebElement> errorMessage = pageObjectManager.getLoginPage().requiredMessageDisplay();
        Assert.assertEquals(errorMessage.size(),2,"Count of Strings should match");
        for(WebElement element : errorMessage){
            System.out.println("Text found: " + element.getText());
        }
    }
}
