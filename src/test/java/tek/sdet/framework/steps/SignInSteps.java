package tek.sdet.framework.steps;

import org.junit.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tek.sdet.framework.pages.POMFactory;
import tek.sdet.framework.utilities.CommonUtility;

public class SignInSteps extends CommonUtility{
	
	POMFactory factory = POMFactory.getInstance();
	
	@Given ("User is on retail website")
	public void userIsOnRetailWebsite() {
		String actualTitle = getTitle();
		String expectedTitle = "React App";
		Assert.assertEquals(expectedTitle, actualTitle);
		Assert.assertTrue(isElementDisplayed(factory.homePage().tekschoolLogo));
		logger.info("User is on retail website");
	}
	
    @When ("User click on Sign in option")
    public void userClickOnSignInOption() {
    	click(factory.homePage().signInLink);
		logger.info("user clicked on Sign in option");
    }
    
    @And ("User enter email {string} and password {string}")
    public void userEnterEmailAndPassword(String emailValue, String passValue) {
    	sendText(factory.signInPage().emailField, emailValue);
		sendText(factory.signInPage().passwordField, passValue);
		logger.info("user entered email and password");
    }
    
    @And ("User click on login button")
    public void userClickOnLoginButton() {
    	click(factory.signInPage().loginButton);
		logger.info("user clicked on login button");
    }
    
    @Then ("User should be logged in into Account")
    public void userShouldBeLoggedInIntoAccount() {
    	Assert.assertTrue(isElementDisplayed(factory.homePage().accountOption));
		logger.info("user is logged in into Account");
    }

}
