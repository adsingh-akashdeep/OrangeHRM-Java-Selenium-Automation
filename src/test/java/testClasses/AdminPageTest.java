package testClasses;

import base.BaseClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import testListener.TestListener;
import utils.ConfigReader;
import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

@Listeners(TestListener.class)
public class AdminPageTest extends BaseClass {
    String username = ConfigReader.getProperty("username");
    String password = ConfigReader.getProperty("password");

    @Test(priority = 0, groups = {"regression"})
    @Description("Verify that the User Management dropdown displays all available options.")
    public void verifyUserManagementDropdownDisplaysItems(){
        waitUtils.waitForElementToBeVisible(pageObjectManager.getLoginPage().getLoginButton());
        pageObjectManager.getLoginPage().doLogin(username, password);
        waitUtils.waitForElementToBeClickable(pageObjectManager.getDashboardPage().getAdminSideBarItemButton());
        pageObjectManager.getDashboardPage().getAdminSideBarItemButton().click();
        waitUtils.waitForElementToBeClickable(pageObjectManager.getAdminPage().getUserManagementDropdownNavigator());
        pageObjectManager.getAdminPage().getUserManagementDropdownNavigator().click();
        String usersText = pageObjectManager.getAdminPage().getUsersItem().getText();

        Assert.assertEquals(usersText, "Users", "Text should match...");
        System.out.println("User Management DropDown is functioning well.");

    }

    @Test(priority = 1, groups = {"regression"})
    @Description("Verify that clicking on the Job dropdown shows all available options.")
    public void verifyJobDropdownDisplaysAllOptions(){
        waitUtils.waitForElementToBeVisible(pageObjectManager.getLoginPage().getLoginButton());
        pageObjectManager.getLoginPage().doLogin(username, password);
        waitUtils.waitForElementToBeClickable(pageObjectManager.getDashboardPage().getAdminSideBarItemButton());
        pageObjectManager.getDashboardPage().getAdminSideBarItemButton().click();
        waitUtils.waitForElementToBeClickable(pageObjectManager.getAdminPage().getJobDropdownNavigator());
        pageObjectManager.getAdminPage().getJobDropdownNavigator().click();
        List<WebElement> results = driver.findElements(By.cssSelector("ul.oxd-dropdown-menu > li"));
        System.out.println("Size of the List: " + results.size());

        Assert.assertEquals(results.size(), 5, "Count should match...");
        System.out.println("This drop down has 5 items in total");
        Assert.assertEquals(results.get(0).getText(), "Job Titles", "First Item text should match");
        System.out.println("Job Dropdown is functioning well as the text of first item matched well.");
    }

    @Test(priority = 2, groups = {"regression"})
    @Description("Verify that entering data in the system users search inputs returns the accurate user results.")
    public void verifySystemUsersInputsFindAccurateUser() throws InterruptedException{
        waitUtils.waitForElementToBeClickable(pageObjectManager.getLoginPage().getLoginButton());
        pageObjectManager.getLoginPage().doLogin(username, password);
        waitUtils.waitForElementToBeClickable(pageObjectManager.getDashboardPage().getAdminSideBarItemButton());
        pageObjectManager.getDashboardPage().getAdminSideBarItemButton().click();
        waitUtils.waitForElementToBeClickable(pageObjectManager.getAdminPage().getUsernameInputInSystemUsersForm());
        pageObjectManager.getAdminPage().getUsernameInputInSystemUsersForm().sendKeys("admin");
        waitUtils.waitForElementToBeClickable(pageObjectManager.getAdminPage().getSubmitButtonInSystemUserForm());
        pageObjectManager.getAdminPage().getSubmitButtonInSystemUserForm().click();
        Thread.sleep(3000);
        waitUtils.waitForElementToBeVisible(pageObjectManager.getAdminPage().getUserInTheSearchResult());
        String text = pageObjectManager.getAdminPage().getUserInTheSearchResult().getText();

        Assert.assertEquals(text,"Admin","Text should be matched");

    }


}
