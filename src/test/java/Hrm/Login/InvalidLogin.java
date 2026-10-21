
package Hrm.Login;

import java.time.Duration;

import org.openqa.selenium.Alert;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import BaseClass.Base;
import GenericUtility.ExcelUtility;
import GenericUtility.ScreenshotUtility;
import PomUtility.LoginPage;

public class InvalidLogin extends Base {

	LoginPage l=new LoginPage(driver);
	
    @Test(groups = {"functional", "negative"})
    public void TC_LOGIN_03_verifyBlankPassword() throws Exception {

        ExcelUtility E = new ExcelUtility();
        String username = E.readData("Login_Test_Data.xlsx", "Sheet2", 2, 0);
        String password = E.readData("Login_Test_Data.xlsx", "Sheet2", 2, 1);

        login(username, password);

        Assert.assertFalse(driver.getCurrentUrl().contains("/dashboard/overview"),"Login succeeded with blank password");

        Reporter.log("Blank Password Test Passed",true);
    }
    
    @Test(groups = {"functional", "negative"})
    public void TC_LOGIN_02_verifyWrongPassword() throws Exception {

        ExcelUtility E = new ExcelUtility();
        String username = E.readData("Login_Test_Data.xlsx", "Sheet2", 4, 0);
        String password = E.readData("Login_Test_Data.xlsx", "Sheet2", 4, 1);

        login(username, password);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());

        String alertText = alert.getText();
        Assert.assertTrue(alertText.contains("Invalid Credentials"),
                "Unexpected alert message: " + alertText);

        alert.accept();
        Reporter.log("Wrong Password Test Passed", true);
        ScreenshotUtility.takeScreenshot(driver, "invalidlogin");
    }
    @Test(groups = {"functional", "negative"})
    public void TC_LOdGIN_04_blank() throws Exception {
        loginPage.getLogin();
        Assert.assertFalse(driver.getCurrentUrl().contains("/dashboard/overview"),"User should not be logged in with blank credentials");
        Reporter.log("Blank Test Passed",true);
    }

}
