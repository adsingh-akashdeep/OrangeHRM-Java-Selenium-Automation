package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeavePage {
    protected WebDriver driver ;

    public LeavePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(css = "div.oxd-sidepanel-body > ul > li:nth-of-type(3) > a >span.oxd-text")
    private WebElement leaveOption;

    @FindBy(css = "ul > li:nth-of-type(7) > a.oxd-topbar-body-nav-tab-item")
    private WebElement assignLeaveOption;

    @FindBy(css = "div.oxd-autocomplete-wrapper > div > input")
    private WebElement employeeNameInput;

    @FindBy(css = "i.oxd-icon.bi-caret-down-fill.oxd-select-text--arrow")
    private WebElement leaveTypeDropdown;

    @FindBy(css = "i.oxd-icon.bi-caret-down-fill.oxd-select-text--arrow")
    private WebElement maternityLeaveOption;

    @FindBy(xpath = "//div[@class = 'oxd-select-wrapper']/div/div[@class = 'oxd-select-option'][4]/span")
    private WebElement canFLMItemDropdown;

    @FindBy(css = "i.oxd-icon.bi-calendar.oxd-date-input-icon")
    private WebElement calendarButton;

    @FindBy(css = "div.oxd-calendar-dates-grid > div:nth-of-type(12)")
    private WebElement fromDateInput9Fill;

    @FindBy(css = "div.oxd-calendar-dates-grid > div:nth-of-type(9)")
    private WebElement toDateInput12Fill;

    @FindBy(css = "button[type = 'submit']")
    private WebElement assignButton;

    //Methods
    public WebElement getLeaveOption(){
        return leaveOption;
    }
    public WebElement getAssignLeaveOption(){
        return assignLeaveOption;
    }
    public WebElement getEmployeeNameInput(){
        return employeeNameInput;
    }
    public WebElement getLeaveTypeDropdown(){
        return leaveTypeDropdown;
    }
    public WebElement getCanFLMItemDropdown(){
        return canFLMItemDropdown;
    }
    public WebElement getMaternityLeaveOption(){
        return maternityLeaveOption;
    }
    public WebElement getFromDateInput9Fill(){
        return fromDateInput9Fill;
    }
    public WebElement getToDateInput12Fill(){
        return toDateInput12Fill;
    }
    public WebElement getCalendarButton(){
        return calendarButton;
    }
    public WebElement getAssignButton(){
        return assignButton;
    }

}
