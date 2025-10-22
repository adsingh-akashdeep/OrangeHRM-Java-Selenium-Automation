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
import java.util.Set;

@Listeners(TestListener.class)
public class DashboardPageTest extends BaseClass {
    String username = ConfigReader.getProperty("username");
    String password = ConfigReader.getProperty("password");

    @Test(priority = 0, groups = {"Smoke"})
    @Description("Verify that clicking on upgrade button redirects the user to the upgrade plan page.")
    public void verifyUpgradeButtonRedirectsUserToUpgradePage(){
        waitUtils.waitForElementToBeClickable(pageObjectManager.getLoginPage().getLoginButton());
        pageObjectManager.getLoginPage().doLogin(username,password);
        waitUtils.waitForElementToBeClickable(pageObjectManager.getDashboardPage().getUpgradeButton());
        String parentWindow = driver.getWindowHandle();
        pageObjectManager.getDashboardPage().clickUpgradeButton();
        for(String windowHandle : driver.getWindowHandles()){
            if(!windowHandle.equals(parentWindow)){
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        Assert.assertEquals(driver.getTitle(), "Upgrade to Advanced from Open Source | OrangeHRM","Title should be matched");
        System.out.println(driver.getTitle());
        System.out.println("Title is successfully retrieved");

    }

    @Test(priority = 1, groups = {"Smoke"})
    @Description("Verify that clicking on the user dropdown shows all available options")
    public void verifyUserDropdownDisplaysAllOptions(){
        waitUtils.waitForElementToBeClickable(pageObjectManager.getLoginPage().getLoginButton());
        pageObjectManager.getLoginPage().doLogin(username,password);
        waitUtils.waitForElementToBeClickable(pageObjectManager.getDashboardPage().getUserDropDownMenuButton());
        pageObjectManager.getDashboardPage().clickingUserDropDownMenu();
        waitUtils.waitForElementToBeVisible(pageObjectManager.getDashboardPage().getAboutTextFromDropDownMenu());
        String textDropDown = pageObjectManager.getDashboardPage().getAboutTextFromDropDownMenu().getText();
        Assert.assertEquals(textDropDown, "About","Item text should match");
        System.out.println("Text is successfully retrieved");
    }

    @Test(priority = 2, groups = {"Smoke"})
    @Description("Verify that selecting the about option from menu navigates to the about page")
    public void verifyAboutItemOpensAboutPage() throws InterruptedException{
        waitUtils.waitForElementToBeClickable(pageObjectManager.getLoginPage().getLoginButton());
        pageObjectManager.getLoginPage().doLogin(username, password);
        waitUtils.waitForElementToBeClickable(pageObjectManager.getDashboardPage().getUserDropDownMenuButton());
        pageObjectManager.getDashboardPage().clickingUserDropDownMenu();
        waitUtils.waitForElementToBeClickable(pageObjectManager.getDashboardPage().getAboutItemButton());
        pageObjectManager.getDashboardPage().getAboutItemButton().click();
        waitUtils.waitForElementToBeVisible(pageObjectManager.getDashboardPage().getVersionElement());

        String version = pageObjectManager.getDashboardPage().getVersionElement().getText();
        Assert.assertEquals(version, "OrangeHRM OS 5.7", "Text should match.");
        System.out.println("Text is successfully retrieved");
    }

    @Test(priority = 3, groups = {"Smoke"})
    @Description("Verify that clicking on the menu button expands the sidebar menu options.")
    public void verifyMenuButtonExpandsSidebarMenu(){
        waitUtils.waitForElementToBeClickable(pageObjectManager.getLoginPage().getLoginButton());
        pageObjectManager.getLoginPage().doLogin(username, password);
        waitUtils.waitForElementToBeClickable(pageObjectManager.getDashboardPage().getMenuSideBarButton());
        pageObjectManager.getDashboardPage().clickMenu();
        waitUtils.waitForElementToBeVisible(pageObjectManager.getDashboardPage().getMenuSideBarButton());
        boolean adminOptionButtonText = pageObjectManager.getDashboardPage().getAdminSideBarItemButton().isDisplayed();
        Assert.assertFalse(adminOptionButtonText, "Item should not be visible");
        System.out.println("The Sidebar menu gets collapsed successfully.");
    }

    @Test(priority = 4, groups = {"Smoke"})
    @Description("Verify if help button is directing the user to support page in a new page.")
    public void verifyHelpIconsOpenHelpPage() throws InterruptedException{
        waitUtils.waitForElementToBeClickable(pageObjectManager.getLoginPage().getLoginButton());
        pageObjectManager.getLoginPage().doLogin(username, password);
        String mainWindow = driver.getWindowHandle();
        waitUtils.waitForElementToBeClickable(pageObjectManager.getDashboardPage().getHelpIconButton());
        pageObjectManager.getDashboardPage().getHelpIconButton().click();
        Set<String> allWindows = driver.getWindowHandles();
        for(String window : allWindows){
            if(!window.equals(mainWindow)){
                driver.switchTo().window(window);
            }
        }
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getCurrentUrl(), "https://starterhelp.orangehrm.com/hc/en-us","url should match with current tab");
        System.out.println("Help page is opened successfully");
    }

    @Test(priority = 5, groups = {"Smoke"})
    @Description("Verify that clicking on OrangeHRM icon redirects user to the HRMS homepage.")
    public void verifyOrangeHRMIconNavigatesToHRMSPage(){
        waitUtils.waitForElementToBeClickable(pageObjectManager.getLoginPage().getLoginButton());
        pageObjectManager.getLoginPage().doLogin(username, password);
        waitUtils.waitForElementToBeClickable(pageObjectManager.getDashboardPage().getOrangeHRMIconClickBtn());
        pageObjectManager.getDashboardPage().getOrangeHRMIconClickBtn().click();
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(), "Human Resources Management Software | HRMS | OrangeHRM", "Title should be exactly same");
    }

    @Test(priority = 6, groups = {"Smoke"})
    @Description("Verify that entering a valid input in the search box redirects to the corresponding page.")
    public void verifyInputInSearchBoxRedirectsToCorrespondingPage(){
        waitUtils.waitForElementToBeClickable(pageObjectManager.getLoginPage().getLoginButton());
        pageObjectManager.getLoginPage().doLogin(username, password);
        waitUtils.waitForElementToBeClickable(pageObjectManager.getDashboardPage().getSearchInputBox());
        pageObjectManager.getDashboardPage().getSearchInputBox().sendKeys("Time");
        List <WebElement> results = driver.findElements(By.cssSelector("div.oxd-sidepanel-body"));
        Assert.assertEquals(results.size(),1, "Item count should match");
        System.out.println(results.size());
        Assert.assertEquals(results.get(0).getText(),"Time", "Item count should match");
        System.out.println(results.get(0).getText());
    }

}
