
package Hrm.DashBoard;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import BaseClass.Base;

public class InvalidDashboard extends Base {

    @Test(groups = {"neg", "system"})
    public void TC_DASH_010_verifyDashboardAccessWithoutLogin() {

        driver.get("http://49.249.29.4:8091/dashboard/overview");

        WebDriverWait wait =
            new WebDriverWait(driver, Duration.ofSeconds(15));

        // Wait until redirected away from the dashboard
        wait.until(ExpectedConditions.not(
            ExpectedConditions.urlContains("/dashboard/overview")
        ));

        Assert.assertTrue(
        	    !driver.getCurrentUrl().contains("/dashboard/overview"),
        	    "Dashboard accessible without login"
        	);

        	Reporter.log("Dashboard Negative Test Passed", true);
    }
}
