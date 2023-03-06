package tek.sdet.framework.steps;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tek.sdet.framework.pages.POMFactory;
import tek.sdet.framework.utilities.CommonUtility;

public class SignInSteps extends CommonUtility{
	
//	POMFactory factory = POMFactory.getInstance();
	POMFactory factory = new POMFactory();
	
	@Given("User is on retail website")
	public void userIsOnRetailWebsite() {
		String actualTitle = getTitle();
		String expectedTitle = "React App";
		Assert.assertEquals(expectedTitle, actualTitle);
		Assert.assertTrue(isElementDisplayed(factory.homePage().tekschoolLogo));
		logger.info("User is on retail website");
	}
	
    @When("User click on Sign in option")
    public void userClickOnSignInOption() {
    	click(factory.homePage().signInLink);
		logger.info("user clicked on Sign in option");
    }
    
    @And("User enter email {string} and password {string}")
    public void userEnterEmailAndPassword(String emailValue, String passValue) {
    	sendText(factory.signInPage().emailField, emailValue);
		sendText(factory.signInPage().passwordField, passValue);
		logger.info("user entered email and password");
    }
    
    @And("User click on login button")
    public void userClickOnLoginButton() {
    	click(factory.signInPage().loginButton);
		logger.info("user clicked on login button");
    }
    
	@Then("User should be logged in into Account")
    public void userShouldBeLoggedInIntoAccount() {
    	Assert.assertTrue(isElementDisplayed(factory.homePage().accountOption));
		logger.info("user is logged in into Account");
    }
    
    @And("User click on Create New Account button")
	public void userClickOnCreateNewAccountButton() {
		click(factory.signInPage().createNewAccountButton); 
		logger.info("user clicked on Create New Account button");
	}

	@And("User fill the signUp information with below data")
	public void userFillTheSignUpInformationWithBelowData(DataTable dataTable) {
		List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
		sendText(factory.signUpPage().createNewAccountNameField, data.get(0).get("name"));
		sendText(factory.signUpPage().createNewAccountEmailField, data.get(0).get("email"));
		sendText(factory.signUpPage().createNewAccountPasswordField, data.get(0).get("password"));
		sendText(factory.signUpPage().createNewAccountConfPassField, data.get(0).get("confirmPassword"));
		logger.info("user filled up the signUp information form");
	}

	@And("User click on SignUp button")
	public void userClickOnSignUpButton() {
		click(factory.signUpPage().signUpButton);
		logger.info("user clicked on SignUp button");
	}

	@Then("User should be logged into account page")
	public void userShouldBeLoggedIntoAccountPage() {
		Assert.assertTrue(isElementDisplayed(factory.accountPage().accountProfilePicture));
		logger.info("user is logged into account page");
	}

}
