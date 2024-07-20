package com.ex_auto.pages;

import com.ex_auto.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    @FindBy(id = "loginLink")
    public WebElement loginBtn;
    @FindBy(linkText = "Employee List")
    public WebElement employeeListBtn;

    public BasePage() {
        PageFactory.initElements(Driver.get(),this);
    }
}
