
package Hrm.Employee;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import BaseClass.Base;
import GenericUtility.ExcelUtility;
import PomUtility.EmployeePage;

public class InvalidEmployee extends Base {

    @Test(groups = {"neg", "functional"})
    public void TC_EMP_12_addInvalidEmployees() throws Exception {

        ExcelUtility E = new ExcelUtility();
        EmployeePage emp = new EmployeePage(driver);

        WebDriverWait wait =
            new WebDriverWait(driver, Duration.ofSeconds(10));

        // Login
        Login();

        // Open Employees page
        emp.clickEmployees();

        // Read invalid employee data from Sheet2
        String name = E.readData("emp_data.xlsx", "Sheet2", 1, 0);
        String email = E.readData("emp_data.xlsx", "Sheet2", 1, 1);
        String phone = E.readData("emp_data.xlsx", "Sheet2", 1, 2);
        String username = E.readData("emp_data.xlsx", "Sheet2", 1, 3);
        String designation = E.readData("emp_data.xlsx", "Sheet2", 1, 4);
        String experience = E.readData("emp_data.xlsx", "Sheet2", 1, 5);
        String project = E.readData("emp_data.xlsx", "Sheet2", 1, 6);

        // Open Add Employee form
        emp.clickAddEmployee();

        // Enter invalid employee data
        emp.enterName(name);
        emp.enterEmail(email);
        emp.enterPhone(phone);
        emp.enterUsername(username);
        emp.enterDesignation(designation);
        emp.enterExperience(experience);
        emp.selectProject(project);

        // Submit invalid data
        emp.clickAdd();

        // Verify the form remains open
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(emp.getName())).isDisplayed(),
        		"Form closed after invalid employee data submission");

        Reporter.log("Invalid Employee Test Passed", true);
    }
}
