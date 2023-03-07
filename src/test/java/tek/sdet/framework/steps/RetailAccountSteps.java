package tek.sdet.framework.steps;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tek.sdet.framework.pages.POMFactory;
import tek.sdet.framework.utilities.CommonUtility;

public class RetailAccountSteps extends CommonUtility{
	
//	POMFactory factory = POMFactory.getInstance();
	POMFactory factory = new POMFactory();
	
	@When("User click on Account option")
	public void userClickOnAccountOption() {
	    click(factory.homePage().accountOption);
	    logger.info("User clicked on Account");
	}
	
	@And("User update Name {string} and Phone {string}")
	public void userUpdateNameAndPhone(String name, String phone) {
		
		clear(factory.accountPage().nameInput);
		sendText(factory.accountPage().nameInput, name);
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
	    
	    //!!!! How to pass here String name, String phone from @And("User update Name {string} and Phone {string}")???
//	    waitTillInvisibile(factory.accountPage().personalInfoUpdateMessage);
//	    String actualName = getAttribute(factory.accountPage().nameInput, "value");
//	    String actualPhone = getAttribute(factory.accountPage().phoneInput, "value");
//	    Assert.assertEquals(name, actualName);
//	    Assert.assertEquals(phone, actualPhone);
	    	    
	    logger.info("User profile information was updated");
	}
	
	@And("User enter below information")
	public void userEnterBelowInformation(DataTable dataTable) {
	    List<Map<String,String>> credent = dataTable.asMaps(String.class, String.class);
	    for (Map<String, String> map : credent) {
	    	sendText(factory.accountPage().previousPasswordField, map.get("previousPassword"));
	    	Assert.assertEquals(map.get("previousPassword"), getAttribute(factory.accountPage().previousPasswordField, "value"));
	    	sendText(factory.accountPage().newPasswordField, map.get("newPassword"));
	    	Assert.assertEquals(map.get("newPassword"), getAttribute(factory.accountPage().newPasswordField, "value"));
	    	sendText(factory.accountPage().confirmPasswordField, map.get("confirmPassword"));
	    	Assert.assertEquals(map.get("confirmPassword"), getAttribute(factory.accountPage().confirmPasswordField, "value"));
	    	logger.info("User entered previous/new password and conformed password");
	        
	    }
	}
	
	@And("User click on Change Password button")
	public void userClickOnChangePasswordButton() {
	    click(factory.accountPage().changPasswordButton);
	    logger.info("User clicked on Change Password button");
	}
	
	@Then("a message should be displayed ‘Password Updated Successfully’")
	public void aMessageShouldBeDisplayedPasswordUpdatedSuccessfully() {
		waitTillPresence(factory.accountPage().passwordUpdatedSuccessMessage);
		Assert.assertTrue(isElementDisplayed(factory.accountPage().passwordUpdatedSuccessMessage));
		logger.info("Password Updated Successfully message is displayed");
	}


}
