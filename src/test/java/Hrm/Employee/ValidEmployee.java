package Hrm.Employee;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import BaseClass.Base;
import GenericUtility.ExcelUtility;
import PomUtility.EmployeePage;
import PomUtility.LoginPage;

public class ValidEmployee extends Base {
	LoginPage log = new LoginPage(driver);

    @Test(priority=1,groups = {"pos", "smoke", "functional"})
    public void TC_EMP_04_addValidEmployees() throws Exception {

        ExcelUtility E = new ExcelUtility();
        EmployeePage emp = new EmployeePage(driver);

        Login();

        emp.clickEmployees();

        String name = E.readData("emp_data.xlsx", "Sheet1", 1, 0);
        String email = E.readData("emp_data.xlsx", "Sheet1", 1, 1);
        String phone = E.readData("emp_data.xlsx", "Sheet1", 1, 2);
        String username = E.readData("emp_data.xlsx", "Sheet1", 1, 3);
        String designation = E.readData("emp_data.xlsx", "Sheet1", 1, 4);
        String experience = E.readData("emp_data.xlsx", "Sheet1", 1, 5);
        String project = E.readData("emp_data.xlsx", "Sheet1", 1, 6);

        // Check whether the employee already exists
        String page = driver.getPageSource();

        if (page.contains(username) || page.contains(email)) {
            Reporter.log(
                "Employee already exists. Skipping: " + username, true
            );
            return;
        }

        // Add employee only if not already present
        emp.clickAddEmployee();
        emp.enterName(name);
        emp.enterEmail(email);
        emp.enterPhone(phone);
        emp.enterUsername(username);
        emp.enterDesignation(designation);
        emp.enterExperience(experience);
        emp.selectProject(project);
        emp.clickAdd();

        Thread.sleep(5000);

        Assert.assertTrue(
            driver.getPageSource().contains(name),
            "Employee was not found after submission: " + name
        );

        Reporter.log("Valid Employee Test Completed: " + name, true);
    }

        @Test(priority=2,groups = {"functional", "system"})
        public void DeleteEmployee() throws Exception {
        	ExcelUtility E= new ExcelUtility();
        	
            Login();
            
            EmployeePage emp = new EmployeePage(driver);
            emp.clickEmployees();
            
            String email = E.readData("emp_data.xlsx", "Sheet1", 1, 1);
            emp.selectSearchBy("Search by Email");
            emp.SearchTf(email);
            emp.ClickDel();
            emp.ClickCfmDel();
            
            emp.selectSearchBy("Search by Email");
            Thread.sleep(2000);
            emp.SearchTf(email);
            
            String tableText = emp.getTableText();

            Assert.assertTrue(tableText.contains(email),"Employee email is not present in the table");
            
            
        }  
}