package tek.sdet.framework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import tek.sdet.framework.base.BaseSetup;

import org.openqa.selenium.support.FindBy;

public class RetailSignUpPage extends BaseSetup {

	public RetailSignUpPage() {
		PageFactory.initElements(getDriver(), this);
	}

	// @FindBy(locatorType = "Value of Locator")
	// public WebElement elementName;

	@FindBy(css = "#nameInput")
	public WebElement createNewAccountNameField;

	@FindBy(id = "emailInput")
	public WebElement createNewAccountEmailField;

	@FindBy(xpath = "//input[@id='passwordInput']")
	public WebElement createNewAccountPasswordField;

	@FindBy(id = "confirmPasswordInput")
	public WebElement createNewAccountConfPassField;

	@FindBy(xpath = "//button[text()='Sign Up']")
	public WebElement signUpButton;

}
