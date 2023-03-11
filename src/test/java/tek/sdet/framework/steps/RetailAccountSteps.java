package tek.sdet.framework.steps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tek.sdet.framework.pages.POMFactory;
import tek.sdet.framework.utilities.CommonUtility;

public class RetailAccountSteps extends CommonUtility {

	private Map<String, String> sharedDataMap = new HashMap<>();

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

		// !!!! How to pass here String name, String phone from @And("User update Name
		// {string} and Phone {string}")???
//	    waitTillInvisibile(factory.accountPage().personalInfoUpdateMessage);
//	    String actualName = getAttribute(factory.accountPage().nameInput, "value");
//	    String actualPhone = getAttribute(factory.accountPage().phoneInput, "value");
//	    Assert.assertEquals(name, actualName);
//	    Assert.assertEquals(phone, actualPhone);

		logger.info("User profile information was updated");
	}

	@And("User enter below information")
	public void userEnterBelowInformation(DataTable dataTable) {
		List<Map<String, String>> credent = dataTable.asMaps(String.class, String.class);
		for (Map<String, String> map : credent) {
			sendText(factory.accountPage().previousPasswordField, map.get("previousPassword"));
			Assert.assertEquals(map.get("previousPassword"),
					getAttribute(factory.accountPage().previousPasswordField, "value"));
			sendText(factory.accountPage().newPasswordField, map.get("newPassword"));
			Assert.assertEquals(map.get("newPassword"), getAttribute(factory.accountPage().newPasswordField, "value"));
			sendText(factory.accountPage().confirmPasswordField, map.get("confirmPassword"));
			Assert.assertEquals(map.get("confirmPassword"),
					getAttribute(factory.accountPage().confirmPasswordField, "value"));
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

	// There are no link, it's p. It's a bug?
	@And("User click on Add a payment method link")
	public void userClickOnAddAPaymentMethodLink() {
		click(factory.accountPage().addPaymentMethodLink);
		logger.info("User clicked on Add a payment method link");
	}

	@And("User fill Debit or credit card information")
	public void userFillDebitOrCreditCardInformation(DataTable dataTable) {
		List<Map<String, String>> cardInfo = dataTable.asMaps(String.class, String.class);
		sendText(factory.accountPage().cardNumberField, cardInfo.get(0).get("cardNumber"));
		sendText(factory.accountPage().nameOnCardField, cardInfo.get(0).get("nameOnCard"));
		selectByVisibleText(factory.accountPage().expirationMonth, cardInfo.get(0).get("expirationMonth"));
		selectByVisibleText(factory.accountPage().expirationYear, cardInfo.get(0).get("expirationYear"));
		sendText(factory.accountPage().securityCodeField, cardInfo.get(0).get("securityCode"));
		logger.info("User filled debit or credit card information");
	}
//I have this method below as "user click on {string} button"
//	@And("User click on Add your card button")
//	public void userClickOnAddYourCardButton() {
//		click(factory.accountPage().paymentButton);
//		logger.info("User clicked on Add your card button");
//	}

	@Then("a message should be displayed ‘Payment Method added successfully’")
	public void aMessageShouldBeDisplayedPaymentMethodAddedSuccessfully() {
		String expectedMessage = "Payment Method added successfully";
		waitTillPresence(factory.accountPage().paymentMethodAddedSuccessfully);
		Assert.assertEquals(expectedMessage, getText(factory.accountPage().paymentMethodAddedSuccessfully));
		logger.info("The message 'Payment Method added successfully' is displayed");
	}

	@And("User click on Edit option of card section")
	public void userClickOnEditOptionOfCardSection() {
		click(factory.accountPage().cardsAndAccountsItemOne);
		click(factory.accountPage().editPayment);
		logger.info("User clicked on Edit option of card section");
	}

	@And("User edit information with below data")
	public void userEditInformationWithBelowData(DataTable dataTable) {
		List<Map<String, String>> cardInfo = dataTable.asMaps(String.class, String.class);
		clear(factory.accountPage().cardNumberField);
		sendText(factory.accountPage().cardNumberField, cardInfo.get(0).get("cardNumber"));
		clear(factory.accountPage().nameOnCardField);
		sendText(factory.accountPage().nameOnCardField, cardInfo.get(0).get("nameOnCard"));
		selectByVisibleText(factory.accountPage().expirationMonth, cardInfo.get(0).get("expirationMonth"));
		selectByVisibleText(factory.accountPage().expirationYear, cardInfo.get(0).get("expirationYear"));
		clear(factory.accountPage().securityCodeField);
		sendText(factory.accountPage().securityCodeField, cardInfo.get(0).get("securityCode"));
		logger.info("user edit information with new data");
	}

	@And("User click on {string} button")
	public void userClickOnButton(String buttonMessage) {
		Assert.assertEquals(buttonMessage, getText(factory.accountPage().paymentButton));
		click(factory.accountPage().paymentButton);
		logger.info("user clicked on " + buttonMessage + " button");
	}

	@Then("a message should be displayed ‘Payment Method updated Successfully‘")
	public void aMessageShouldBeDisplayedPaymentMethodUpdatedSuccessfully() {
		String expectedMessage = "Payment Method updated Successfully";
		waitTillPresence(factory.accountPage().paymentMethodUpdatedSuccessfully);
		Assert.assertEquals(expectedMessage, getText(factory.accountPage().paymentMethodUpdatedSuccessfully));
		logger.info("The message 'Payment Method updated successfully' is displayed");

	}

	@When("User click on remove option of card section")
	public void userClickOnRemoveOptionOfCardSection() {

		if (factory.accountPage().cardsAndAccountsItems.size() > 0) {

			click(factory.accountPage().cardsAndAccountsItemOne);
			Assert.assertTrue(isElementDisplayed(factory.accountPage().cardsAndAccountSelectedItem));
			Assert.assertTrue(isElementDisplayed(factory.accountPage().removePayment));
			waitTillClickable(factory.accountPage().removePayment);
			String removedCardNumber = getText(factory.accountPage().cardsAndAccountsItemOne)
					.substring(getText(factory.accountPage().cardsAndAccountsItemOne).length() - 4);
			sharedDataMap.put("removedCardNumber", removedCardNumber);
			click(factory.accountPage().removePayment);
			waitTillInvisibile(factory.accountPage().removePayment);
			logger.info("User clicked on remove link to remove " + sharedDataMap.get("removedCardNumber"));

		} else {
			Assert.assertTrue(factory.accountPage().cardsAndAccountsItems.size() > 0);
		}

	}

	@Then("payment details should be removed")
	public void paymentDetailsShouldBeRemoved() {
		List<WebElement> removedCard = getDriver()
				.findElements(By.xpath(String.format("//*[text()='%s']", sharedDataMap.get("removedCardNumber"))));

		if (removedCard.size() == 0) {
			Assert.assertTrue(true);
			logger.info("payment card " + (String) sharedDataMap.get("removedCardNumber") + " is removed");
		} else {
			Assert.assertTrue(false);
		}

	}

}
