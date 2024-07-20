package com.ex_auto.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmployeeDeletePage extends BasePage{

    @FindBy(css = "[value='Delete']")
    public WebElement employeeDeleteBtn;

}
