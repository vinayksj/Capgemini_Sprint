package PomUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class EmployeePage {

    WebDriver driver;

    public EmployeePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Employees navigation
    @FindBy(xpath = "//a[text()='Employees']")
    private WebElement SelectEMP;

    // Add New Employee
    @FindBy(xpath = "//span[text()='Add New Employee']")
    private WebElement addEmp;

    // Employee details
    @FindBy(xpath = "//label[text()='Name*']/following-sibling::input")
    private WebElement Name;

    @FindBy(xpath = "//label[text()='Email*']/following-sibling::input")
    private WebElement Email;

    @FindBy(xpath = "//label[text()='Phone*']/following-sibling::input")
    private WebElement Phone;

    @FindBy(xpath = "//label[text()='Username*']/following-sibling::input")
    private WebElement UserN;

    @FindBy(xpath = "//label[text()='Designation*']/following-sibling::input")
    private WebElement Designtn;

    @FindBy(xpath = "//label[text()='Experience*']/following-sibling::input")
    private WebElement Exp;

    // Project dropdown
    @FindBy(xpath = "//select[option[normalize-space()='Select Project']]")
    private WebElement projectDropdown;

    // Cancel and Add buttons
    @FindBy(xpath = "//button[normalize-space()='Cancel']")
    private WebElement cancelButton;

    @FindBy(xpath = "//input[@value='Add']")
    private WebElement addButton;

    // Employee checkbox
    @FindBy(xpath = "(//input[@type='checkbox'])[2]")
    private WebElement check;

    // Delete buttons
    @FindBy(xpath = "//span[text()='Delete']")
    private WebElement deleteButton;

    @FindBy(xpath = "//*[@value='Delete']")
    private WebElement delete;

    
    public void SearchTf(String By) {
    	SearchBox.clear();
    	SearchBox.sendKeys(By);
    }
    @FindBy(xpath = "//input[@placeholder='Search by Email']")
    private WebElement SearchBox;
    
    public WebElement getName() {
        return Name;
    }
    
    @FindBy(xpath = "//input[@value='Delete']")
    private WebElement Confirmdel;
    
    public void ClickCfmDel() {
    	Confirmdel.click();
    }
    @FindBy(css = "table.table.table-striped.table-hover")
    private WebElement employeeTable;
    
    public String getTableText() {
        return employeeTable.getText();
    }
    @FindBy(xpath = "//i[@title='Delete']")
    private WebElement DelBox;
    
    public  void ClickDel() {
    	DelBox.click();
    }
    
    
    @FindBy(xpath = "//select[@class='form-control']")
    private WebElement SearchDD;
    
    public void selectSearchBy(String name) {
    	Select select= new Select(SearchDD);
    	select.selectByVisibleText(name);
    	
    }

    // Select project
    public void selectProject(String projectName) {
        Select select = new Select(projectDropdown);
        select.selectByVisibleText(projectName);
    }

    // Get selected project
    public String getSelectedProject() {
        Select select = new Select(projectDropdown);
        return select.getFirstSelectedOption().getText();
    }

    // Click Employees
    public void clickEmployees() {
        SelectEMP.click();
    }

    // Click Add New Employee
    public void clickAddEmployee() {
        addEmp.click();
    }

    // Enter employee details
    public void enterName(String name) {
        Name.sendKeys(name);
    }

    public void enterEmail(String email) {
        Email.sendKeys(email);
    }

    public void enterPhone(String phone) {
        Phone.sendKeys(phone);
    }

    public void enterUsername(String username) {
        UserN.sendKeys(username);
    }

    public void enterDesignation(String designation) {
        Designtn.sendKeys(designation);
    }

    public void enterExperience(String experience) {
        Exp.sendKeys(experience);
    }

    // Click Cancel
    public void clickCancel() {
        cancelButton.click();
    }

    // Click Add
    public void clickAdd() {
        addButton.click();
    }

    // Select employee checkbox
    public void selectEmployeeCheckbox() {
        check.click();
    }

    // Click Delete
    public void clickDeleteButton() {
        deleteButton.click();
    }

    // Confirm Delete
    public void confirmDelete() {
        delete.click();
    }
}