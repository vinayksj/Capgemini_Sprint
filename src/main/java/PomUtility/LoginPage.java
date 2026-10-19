
package PomUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "username")
    private WebElement UN;

    @FindBy(name = "password")
    private WebElement PW;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement login;

    @FindBy(css = "[data-test='error']")
    private WebElement errorMessage;

    public void getUN(String value) {
        UN.clear();
        UN.sendKeys(value);
    }

    public void getPW(String value) {
        PW.clear();
        PW.sendKeys(value);
    }

    public void getLogin() {
        login.click();
    }

    public boolean isLoginPageDisplayed() {
        return UN.isDisplayed()
                && PW.isDisplayed()
                && login.isDisplayed();
    }

    public boolean isErrorMessageDisplayed() {
        return errorMessage.isDisplayed();
    }
}
