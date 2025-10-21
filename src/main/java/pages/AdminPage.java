package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminPage {
    protected WebDriver driver;

    public AdminPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css ="ul > li.oxd-topbar-body-nav-tab:nth-of-type(1)" )
    private WebElement userManagementDropdownNavigator;

    @FindBy(css = "a[role = 'menuitem']")
    private WebElement usersText;

    @FindBy(css ="ul > li.oxd-topbar-body-nav-tab:nth-of-type(2)")
    private WebElement jobDropdownNavigator;
    @FindBy(css ="ul > li.oxd-topbar-body-nav-tab:nth-of-type(2) > ul > li:nth-of-type(1)")
    private WebElement jobTitlesItem;

    @FindBy(css ="ul > li.oxd-topbar-body-nav-tab:nth-of-type(3)")
    private WebElement organizationDropdownNavigator;

    @FindBy(css ="ul > li.oxd-topbar-body-nav-tab:nth-of-type(4)")
    private WebElement qualificationDropdownNavigator;

    @FindBy(css ="ul > li.oxd-topbar-body-nav-tab:nth-of-type(5)")
    private WebElement nationalitiesNavigator;

    @FindBy(css ="ul > li.oxd-topbar-body-nav-tab:nth-of-type(6)")
    private WebElement corporateBrandingNavigator;

    @FindBy(css ="ul > li.oxd-topbar-body-nav-tab:nth-of-type(7)")
    private WebElement configurationDropdownNavigator;

    @FindBy(xpath = "//div[@id='app']//div//div[2]//div//div//div//div[2]//form//div//div//div//div//div[2]//input[@class]")
    private WebElement usernameInputInSystemUsersForm;

    @FindBy(css = "button[type = 'submit']")
    private WebElement submitButtonInSystemUserForm;

    @FindBy(xpath = "//*[@id='app']/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div/div/div[2]/div")
    private WebElement userInTheSearchResult;

    // Elements getters
    public WebElement getUserManagementDropdownNavigator(){
        return userManagementDropdownNavigator;
    }
    public WebElement getUsersItem(){
        return usersText;
    }
    public WebElement getJobDropdownNavigator(){
        return jobDropdownNavigator;
    }
    public WebElement getJobTitlesItem(){
        return jobTitlesItem;
    }
    public WebElement getUsernameInputInSystemUsersForm(){
        return usernameInputInSystemUsersForm;
    }
    public WebElement getSubmitButtonInSystemUserForm(){
        return submitButtonInSystemUserForm;
    }
    public WebElement getUserInTheSearchResult() {
        return userInTheSearchResult;}

}
