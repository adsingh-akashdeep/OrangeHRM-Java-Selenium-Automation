package utils;

import org.openqa.selenium.WebDriver;
import pages.AdminPage;
import pages.DashboardPage;
import pages.LeavePage;
import pages.LoginPage;

public class PageObjectManager {

    protected WebDriver driver;
    protected LoginPage loginPage;
    protected AdminPage adminPage;
    protected DashboardPage dashboardPage;
    protected LeavePage leavePage;

    public PageObjectManager(WebDriver driver){
        this.driver = driver;
    }
    public AdminPage getAdminPage() {
       adminPage = new AdminPage(driver);
        return adminPage;
    }
    public LoginPage getLoginPage() {
        loginPage = new LoginPage(driver);
        return loginPage;
    }
    public DashboardPage getDashboardPage(){
        dashboardPage = new DashboardPage(driver);
        return dashboardPage;
    }
    public LeavePage getLeavePage(){
        leavePage = new LeavePage(driver);
        return leavePage;
    }

}
