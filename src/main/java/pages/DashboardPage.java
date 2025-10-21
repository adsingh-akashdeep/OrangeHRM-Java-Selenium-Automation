package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {
    protected WebDriver driver;

    public DashboardPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[@class='oxd-glass-button orangehrm-upgrade-button']")
    private WebElement upgradeButton;

    @FindBy (xpath = "//p[@class= 'oxd-userdropdown-name']")
    private WebElement userDropDownMenu;

    @FindBy (xpath = "//i[@class= 'oxd-icon bi-list oxd-topbar-header-hamburger' ]")
    private WebElement hamburgerMenuIcon;

    @FindBy (css = "ul.oxd-dropdown-menu > li:first-child")
    private WebElement aboutTextFromDropDownMenu;

    @FindBy (css = "div.oxd-main-menu-search > button")
    private WebElement menuSideBarButton;

    @FindBy (xpath = "//span[text() = 'Admin']")
    private WebElement adminSideBarItemButton;

    @FindBy (xpath = "//div[@class = 'oxd-grid-2 orangehrm-about']/div[4]/p")
    private WebElement versionElement;

    @FindBy (xpath = "//div[@class = 'oxd-topbar-header-userarea']/ul/li/ul/li[1]/a")
    private WebElement aboutItemButton;

    @FindBy (css = "div.oxd-topbar-body-nav-slot > button" )
    private WebElement helpIconButton;

    @FindBy (css = "div.oxd-sidepanel-header")
    private WebElement orangeHRMIconClickBtn;

    @FindBy (css = "input[placeholder = 'Search']")
    private WebElement searchInputBox;

    @FindBy (css = "div.oxd-sidepanel-body")
    private WebElement sidePanelBody;

    // methods to access and perform functions on the private variables
    public void clickUpgradeButton(){
        upgradeButton.click();
    }
    public void clickingUserDropDownMenu(){
        userDropDownMenu.click();
    }
    public void displayHamburger(){
        hamburgerMenuIcon.isDisplayed();
    }
    public void clickMenu(){
        menuSideBarButton.click();
    }

    // getters of private fields and clickable.
    public WebElement getUpgradeButton(){return upgradeButton;}
    public WebElement getUserDropDownMenuButton(){
        return userDropDownMenu;
    }
    public WebElement getHamburgerMenuIcon(){
        return hamburgerMenuIcon;
    }
    public WebElement getMenuSideBarButton() {return menuSideBarButton;}
    public WebElement getAdminSideBarItemButton(){return adminSideBarItemButton;}
    public WebElement getAboutItemButton(){return aboutItemButton;}
    public WebElement getAboutTextFromDropDownMenu(){return aboutTextFromDropDownMenu;}
    public WebElement getVersionElement() {return versionElement;}
    public WebElement getHelpIconButton(){return helpIconButton;}
    public WebElement getOrangeHRMIconClickBtn(){return orangeHRMIconClickBtn;}
    public WebElement getSearchInputBox(){return searchInputBox;}
    public WebElement getSidePanelBody(){return sidePanelBody;}


}
