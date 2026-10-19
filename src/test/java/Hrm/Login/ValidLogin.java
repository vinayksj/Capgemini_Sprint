
package Hrm.Login;

import java.time.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import BaseClass.Base;

public class ValidLogin extends Base {

    @Test(groups = {"smoke", "functional", "integration"})
    public void TC_LOGIN_01_verifyLogin() throws Exception {
    	Login();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.urlContains("dashboard"));

        Assert.assertTrue(driver.getCurrentUrl().contains("/dashboard/overview"), "Dashboard not displayed");
        Assert.assertTrue(driver.getPageSource().contains("Employees"), "Employees panel not found");
        Assert.assertTrue(driver.getPageSource().contains("Projects"), "Projects panel not found");

        System.out.println("Login Test Passed");
    }
}
