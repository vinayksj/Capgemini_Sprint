package Hrm.DashBoard;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import BaseClass.Base;
import GenericUtility.ScreenshotUtility;
import PomUtility.DashboardPage;

public class Dashboard extends Base {

    @Test(groups = {"pos", "smoke", "functional"})
    public void TC_DASH_001_verifyDashboard() throws Exception {

    	Login();

        DashboardPage dashboard = new DashboardPage(driver);
        dashboard.getDash();

        Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"),
                "Dashboard page was not opened");

        Assert.assertTrue(driver.getPageSource().contains("Employees"),
                "Employees section not found");

        Assert.assertTrue(driver.getPageSource().contains("Projects"),
                "Projects section not found");

        Reporter.log("Dashboard Positive Test Passed", true);
        ScreenshotUtility.takeScreenshot(driver,"DashBoard");
    }
}
