package com.ex_auto.pages;

import com.ex_auto.utilities.BrowserUtils;
import com.ex_auto.utilities.Driver;

import static org.junit.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;


public class EmployeeListPage extends BasePage {

    EmployeeDeletePage employeeDeletePage = new EmployeeDeletePage();

    @FindBy(xpath = "//a[text()='Create New']")
    public WebElement createNewBtn;
    @FindBy(xpath = "//table/tbody/tr")
    public List<WebElement> employeeRows;
    @FindBy(name = "searchTerm")
    public WebElement searchInput;
    @FindBy(xpath = "//input[@type='submit']")
    public WebElement searchBtn;
    @FindBy(xpath = "//table/tbody/tr[2]/td[5]")
    public WebElement emailInfo;


    public void searchWithName(String name) {
        searchInput.sendKeys(name);
        searchBtn.click();
    }

    public void verifyEmployeeDisplayed(String name) {
        searchWithName(name);
        BrowserUtils.verifyElementDisplayed(emailInfo);
    }

    public void employeeDelete(String name) {
        searchWithName(name);
        try {
            WebElement deleteBtn = Driver.get().findElement(By.xpath("//table/tbody/tr[2]/td[6]/a[3]"));
            BrowserUtils.waitForClickablility(deleteBtn, 5).click();
        } catch (Exception e) {
            BrowserUtils.clickWithWait(By.xpath("//table/tbody/tr[2]/td[6]/a[3]"), 5);
        }
        employeeDeletePage.employeeDeleteBtn.click();
        BrowserUtils.waitFor(2);
    }

    public void verifyEmployeeNotDisplayed(String email) {

        List<String> employeeList = new ArrayList<>();
        for (WebElement row : employeeRows) {
            employeeList.add(row.getText());
        }
        assertFalse(employeeList.contains(email));
    }
}
