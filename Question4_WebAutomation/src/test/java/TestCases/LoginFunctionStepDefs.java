package TestCases;

import Pages.LoginPage;
import Utilities.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

import static org.testng.AssertJUnit.assertEquals;

public class LoginFunctionStepDefs extends DriverSetup {

    private final SoftAssert softAssert = new SoftAssert();
    LoginPage login = new LoginPage();

    @Given("User open testu website")
    public void user_open_testu_website() throws IOException {
        driverInitiate();
        driver.get(ProperityFileSetup.propInitiate("URL"));
    }

    @When("User send invalid username and password")
    public void user_send_invalid_username_and_password() throws IOException {
        login.UsernameTextArea().sendKeys(ProperityFileSetup.propInitiate("Username"));
        login.PasswordTextArea().sendKeys(ProperityFileSetup.propInitiate("Password"));
    }

    @When("Click on Login Button")
    public void click_on_login_button() {
       login.Login_Button().click();
    }

    @Then("Verify error message appeared")
    public void verify_error_message_appeared() throws IOException {
        String Actual_errorMessage = login.LoginErrorMessage().getText();
        String Expected_errorMessage = ProperityFileSetup.propInitiate("ErrorMessage");
        assertEquals(Actual_errorMessage, Expected_errorMessage );
    }



}
