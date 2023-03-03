package tek.sdet.framework.steps;

import org.junit.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tek.sdet.framework.pages.POMFactory;
import tek.sdet.framework.utilities.CommonUtility;

public class RetailAccountSteps extends CommonUtility{
	
	POMFactory factory = POMFactory.getInstance();
	
	@When("User click on Account option")
	public void userClickOnAccountOption() {
	    click(factory.homePage().accountOption);
	    logger.info("User clicked on Account");
	}
	
	@And("User update Name {string} and Phone {string}")
	public void userUpdateNameAndPhone(String name, String phone) {
//		clearTextUsingSendKeys(factory.accountPage().nameInput);
		clear(factory.accountPage().nameInput);
		sendText(factory.accountPage().nameInput, name);
//		clearTextUsingSendKeys(factory.accountPage().phoneInput);
		clear(factory.accountPage().phoneInput);
		sendText(factory.accountPage().phoneInput, phone);
		logger.info("User entered updated Name and Phone");
	}
	
	@And("User click on Update button")
	public void userClickOnUpdateButton() {
	    click(factory.accountPage().updateBotton);
	    logger.info("User clicked on Update button");
	}
	
	@Then("User profile information should be updated")
	public void userProfileInformationShouldBeUpdated() {
	    waitTillPresence(factory.accountPage().personalInfoUpdateMessage);
	    Assert.assertTrue(isElementDisplayed(factory.accountPage().personalInfoUpdateMessage));
	    logger.info("User profile has 'Personal Information Updated Successfully' message");
	}
	
	@And("User Name is {string} and Phone is {string}")
	public void userNameIsAndPhoneIs(String name, String phone) {
		waitTillInvisibile(factory.accountPage().personalInfoUpdateMessage);
	    String actualName = getAttribute(factory.accountPage().nameInput, "value");
	    String actualPhone = getAttribute(factory.accountPage().phoneInput, "value");
	    Assert.assertEquals(name, actualName);
	    Assert.assertEquals(phone, actualPhone);
	    logger.info("User has updated Name and Email");
	}

}
