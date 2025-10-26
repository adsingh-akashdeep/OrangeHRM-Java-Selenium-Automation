package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LoginPage {
    protected WebDriver driver;

    public LoginPage (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[contains(@name,'username')]")
    private WebElement usernameInputBox;
    @FindBy(xpath = "//input[starts-with(@name,'pass')]")
    private WebElement passwordInputBox;
    @FindBy(css = "[type='submit']")
    private WebElement loginButton;
    @FindBy(css = "div.orangehrm-login-branding > img")
    private WebElement logo;
    @FindBy(css = "div.orangehrm-login-error > div > p:nth-of-type(1)")
    private WebElement credentialsUsername;
    @FindBy(css = "div.orangehrm-login-error > div > p:nth-of-type(2)")
    private WebElement credentialsPassword;

    public void doLogin(String username, String password) {
        this.usernameInputBox.sendKeys(new CharSequence[]{username});
        this.passwordInputBox.sendKeys(new CharSequence[]{password});
        this.loginButton.click();
    }

    public boolean logoDisplay(WebDriver driver) {
        return this.logo.isDisplayed();
    }

    public String[] credentialsSampleDisplay() {
        return new String[]{this.credentialsUsername.getText(), this.credentialsPassword.getText()};
    }

    public List<WebElement> requiredMessageDisplay(){
        return driver.findElements(By.xpath("//span[text()='Required']"));
    }

    public WebElement getCredentialsUsername() {
        return this.credentialsUsername;
    }

    public WebElement getCredentialsPassword() {
        return this.credentialsPassword;
    }

    public WebElement getLoginButton() {
        return this.loginButton;
    }

    public WebElement getLogo() {
        return this.logo;
    }

}
