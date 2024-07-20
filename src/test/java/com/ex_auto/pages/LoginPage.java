package com.ex_auto.pages;

import com.ex_auto.utilities.ConfigurationReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    @FindBy(id = "UserName")
    public WebElement username;
    @FindBy(id = "Password")
    public WebElement password;
    @FindBy(xpath = "//input[@type='submit']")
    public WebElement log_in_btn;

    public void login(){
        loginBtn.click();
        username.sendKeys(ConfigurationReader.get("username"));
        password.sendKeys(ConfigurationReader.get("password"));
        log_in_btn.click();
    }
}
