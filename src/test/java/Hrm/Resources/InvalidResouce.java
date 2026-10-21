
package Hrm.Resources;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import BaseClass.Base;
import PomUtility.ResourcePage;

public class InvalidResouce extends Base {

    @Test(groups = {"negative", "system"})
    public void searchInvalidFileTest() throws Exception {

    	Login();

        // Search invalid file
        ResourcePage resources = new ResourcePage(driver);

        resources.getResourcesMenu();

        String invalidFile = "file_not_found_12345.pdf";

        resources.searchFile(invalidFile);

        Thread.sleep(2000);

        Assert.assertTrue(
            driver.findElements(
                By.xpath("//*[normalize-space()='" + invalidFile + "']")
            ).isEmpty(),
            "Unexpected matching file found"
        );

        Reporter.log("Invalid file search test passed", true);

        System.out.println("Invalid file not found: " + invalidFile);
    }

}
