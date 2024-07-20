package com.ex_auto.pages;

import com.ex_auto.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmployeeCreatePage extends BasePage{

    @FindBy(id = "Name")
    public WebElement nameInput;
    @FindBy(id = "Salary")
    public WebElement salaryInput;
    @FindBy(id = "DurationWorked")
    public WebElement durationWorkedInput;
    @FindBy(id = "Grade")
    public WebElement gradeInput;
    @FindBy(id = "Email")
    public WebElement emailInput;
    @FindBy(xpath = "//input[@type='submit']")
    public WebElement createBtn;

    public void newCreateEmployee(String name, int salary, int durationWorked, String grade, String email){
        nameInput.sendKeys(name);
        salaryInput.sendKeys(String.valueOf(salary));
        durationWorkedInput.sendKeys(String.valueOf(durationWorked));
        BrowserUtils.selectOption(gradeInput,grade);
        emailInput.sendKeys(email);
        createBtn.click();
    }
}
