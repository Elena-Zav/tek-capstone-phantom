package tek.sdet.framework.pages;

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
	public WebElement addYourCardBotton;

	@FindBy(xpath = "//div[text()='Payment Method added sucessfully']")
	public WebElement paymenMethodUpdatedSuccessfully;

}
