package StepDefinition;

import Page.OrangehrmLiveDemoPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class OrangehrmLiveDemoStepDefinition {
    private final OrangehrmLiveDemoPage orangehrmLiveDemoPage;

    public OrangehrmLiveDemoStepDefinition(Hooks hooks) {
        orangehrmLiveDemoPage = new OrangehrmLiveDemoPage(hooks.getDriver());
    }

    @Given("user launch url in the browser {string}")
    public void UserLaunchUrlInTheBrowser(String url) {
        orangehrmLiveDemoPage.launchUrl(url);
    }

    @When("user enter username {string} and password {string}")
    public void UserEnterUsernameAndPassword(String username, String password) {
        orangehrmLiveDemoPage.enterCredentials(username, password);
    }

    @And("user click on login button")
    public void UserClickOnLoginButton() {
        orangehrmLiveDemoPage.clickLoginButton();
    }

    @Then("verify title of the page")
    public void VerifyTitleOfThePage() {
        orangehrmLiveDemoPage.getPageTitle();
    }

}
