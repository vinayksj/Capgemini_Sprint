package Hrm.Resources;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import BaseClass.Base;
import GenericUtility.ScreenshotUtility;
import PomUtility.ResourcePage;

public class ValidResource extends Base {

    
    @Test(priority = 1, groups = {"pos", "functional"})
    public void uploadValidFileTest() throws Exception {
    	Login();
        ResourcePage resources = new ResourcePage(driver);
        resources.getResourcesMenu();
        resources.clickUploadFile();
        resources.chooseFile("C:\\Users\\Lenovo\\Documents\\DBMS1.docx");
        resources.clickUploadFileSubmit();

        Thread.sleep(2000);
        Assert.assertTrue(driver.getPageSource().contains("DBMS1.docx"), "Uploaded file was not found");
        Reporter.log("Valid file upload test passed", true);
        ScreenshotUtility.takeScreenshot(driver,"uploaded");
    }

    @Test(priority = 2, groups = {"pos", "smoke"})
    public void searchExistingFileTest() throws Exception {

        Login();

        ResourcePage resources = new ResourcePage(driver);
        resources.getResourcesMenu();
        resources.searchFile("DBMS1.docx");

        Thread.sleep(2000);

        Assert.assertTrue(
        	    resources.getBox().contains("DBMS1.docx"),
        	    "DBMS1.docx is not present"
        	);

        Reporter.log("DBMS1.docx is present", true);
    }
}