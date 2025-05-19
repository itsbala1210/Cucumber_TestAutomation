package StepDefinition;

import Page.AdminSitePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AdminSiteStepDefinition {
    private final AdminSitePage adminSitePage;

    public AdminSiteStepDefinition(Hooks hooks) {
        adminSitePage = new AdminSitePage(hooks.getDriver());
    }

    @And("selects the admin tab in dashboard")
    public void SelectsTheAdminTabInDashboard() {
        adminSitePage.adminMenu();
    }

    @Then("user click add button in admin page")
    public void UserClickAddButtonInAdminPage() {
        adminSitePage.addAdminBtn();
    }

    @When("user selects the user role {string}")
    public void UserSelectsTheUserRole(String userOptions) {
        adminSitePage.userRole(userOptions);
    }

    @Given("enters the employee name {string}")
    public void EntersTheEmployeeName(String employeeName) {
        adminSitePage.userName(employeeName);
    }

    @Then("selects the status {string}")
    public void SelectsTheStatus(String statusOptions) {
        adminSitePage.status(statusOptions);
    }

    @And("user sends the username {string}")
    public void UserSendsTheUsername(String addUsername) {
        adminSitePage.addUsername(addUsername);
    }


    @When("sends the password {string} and confirm password {string}")
    public void UserSendsThePasswordAndConfirmPassword(String userPassword, String confirmPassword) {
        adminSitePage.enterPasswordAndConfirm(userPassword, confirmPassword);
    }

    @And("user click on save button")
    public void UserClickOnSaveButton() {
        adminSitePage.saveBtn();
    }

    @And("user click on search button in admin page")
    public void userClickOnSearchButtonInAdminPage() {
        adminSitePage.searchBtn();
    }

    @Then("user verify user data {string} in admin page")
    public void userVerifyUserData(String username) {
        adminSitePage.verifyUserData(username);
    }

    @And("takes a verified screenshot in page")
    public void takesAVerifiedScreenshotInPage() {
        adminSitePage.takeScreenShot();
    }

    @Then("user deletes a user data")
    public void userDeletesAUserData() {
        adminSitePage.deleteUserData();
    }
}
