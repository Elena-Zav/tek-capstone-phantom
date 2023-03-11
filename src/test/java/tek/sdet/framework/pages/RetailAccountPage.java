package tek.sdet.framework.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tek.sdet.framework.base.BaseSetup;

public class RetailAccountPage extends BaseSetup {

	public RetailAccountPage() {
		PageFactory.initElements(getDriver(), this);
	}

	@FindBy(xpath = "//img[@alt='profile pic']")
	public WebElement accountProfilePicture;

	@FindBy(id = "nameInput")
	public WebElement nameInput;

	@FindBy(id = "personalPhoneInput")
	public WebElement phoneInput;

	@FindBy(id = "personalUpdateBtn")
	public WebElement updateBotton;

	@FindBy(xpath = "//div[text()='Personal Information Updated Successfully']")
	public WebElement personalInfoUpdateMessage;

	@FindBy(id = "previousPasswordInput")
	public WebElement previousPasswordField;

	@FindBy(id = "newPasswordInput")
	public WebElement newPasswordField;

	@FindBy(id = "confirmPasswordInput")
	public WebElement confirmPasswordField;

	@FindBy(id = "credentialsSubmitBtn")
	public WebElement changPasswordButton;

	@FindBy(xpath = "//div[text()='Password Updated Successfully']")
	public WebElement passwordUpdatedSuccessMessage;

	@FindBy(xpath = "//p[text()='Add a payment method']")
	public WebElement addPaymentMethodLink;

	@FindBy(id = "cardNumberInput")
	public WebElement cardNumberField;

	@FindBy(id = "nameOnCardInput")
	public WebElement nameOnCardField;

	@FindBy(id = "expirationMonthInput")
	public WebElement expirationMonth;

	@FindBy(id = "expirationYearInput")
	public WebElement expirationYear;

	@FindBy(id = "securityCodeInput")
	public WebElement securityCodeField;

	@FindBy(id = "paymentSubmitBtn")
	public WebElement paymentButton;

	@FindBy(xpath = "//div[text()='Payment Method added sucessfully']")
	public WebElement paymentMethodAddedSuccessfully;

	@FindBy(xpath = "//div[@class='account__payments-wrapper']/div[1]")
	public WebElement cardsAndAccountsItemOne;

	@FindBy(xpath = "//div[@class='account__payment-selected account__payment-item']")
	public WebElement cardsAndAccountSelectedItem;

	@FindBy(xpath = "//div[@class='account__payment-selected account__payment-item']//p[@class='account__payment__sub-text']")
	public WebElement cardsAndAccountsNumberSelectedItem;

	@FindBy(xpath = "//div[@class='account__payment-detail']//p[2]")
	public WebElement cardNumberForEditOrRemove;

	@FindBy(xpath = "//div[@class='account__payment-detail']//button[text()='Edit']")
	public WebElement editPayment;

	@FindBy(xpath = "//div[text()='Payment Method updated Successfully']")
	public WebElement paymentMethodUpdatedSuccessfully;

	@FindBy(xpath = "//div[@class='account__payment']//button[text()='remove']")
	public WebElement removePayment;

	@FindBy(xpath = "//div[@class='account__payment-sub']")
	public List<WebElement> cardsAndAccountsItems;

}
