package com.ex_auto.stepDefs;

import com.ex_auto.pages.EmployeeCreatePage;
import com.ex_auto.pages.EmployeeDeletePage;
import com.ex_auto.pages.EmployeeListPage;
import com.ex_auto.pages.LoginPage;
import com.ex_auto.utilities.BrowserUtils;
import com.ex_auto.utilities.ConfigurationReader;
import com.ex_auto.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class CreateDelete_stepDefs {
    LoginPage loginPage = new LoginPage();
    EmployeeListPage employeeListPage = new EmployeeListPage();
    EmployeeCreatePage employeeCreatePage = new EmployeeCreatePage();
    EmployeeDeletePage employeeDeletePage = new EmployeeDeletePage();

    @Given("I navigate to website")
    public void ıNavigateToWebsite() {
        Driver.get().get(ConfigurationReader.get("url"));
    }

    @When("I login as admin")
    public void ıLoginAsAdmin() {
       loginPage.login();
    }

    @And("I go to the Employee List page")
    public void ıGoToTheEmployeeListPage() {
        loginPage.employeeListBtn.click();
    }

    @And("I create a new employee with {string} and {int} and {int} and {string} and {string}")
    public void ıCreateANewEmployeeWithAndAndAndAnd(String name, int salary, int durationWorked, String grade, String email) {
        employeeListPage.createNewBtn.click();
        employeeCreatePage.newCreateEmployee(name,salary,durationWorked,grade,email);
    }
    @Then("Verify new employee information with {string} on the Employee List page")
    public void verifyNewEmployeeInformationWithOnTheEmployeeListPage(String name) {
        employeeListPage.verifyEmployeeDisplayed(name);
    }

    @When("I search for the new employee by {string} and delete it.")
    public void ıSearchForTheNewEmployeeByAndDeleteIt(String name) {
        employeeListPage.employeeDelete(name);
    }

    @Then("Verify the new deleted employee with {string} on the Employee List page")
    public void verifyTheNewDeletedEmployeeWithOnTheEmployeeListPage(String email) {
        employeeListPage.verifyEmployeeNotDisplayed(email);
    }
}
