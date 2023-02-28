package tek.sdet.framework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;

import tek.sdet.framework.base.BaseSetup;

public class RetailSignInPage extends BaseSetup {

	public RetailSignInPage() {
		PageFactory.initElements(getDriver(), this);
	}

	// @FindBy(locatorType = "Value of Locator")
	// public WebElement elementName;

	@FindBy(id = "email")
	public WebElement emailField;

	@FindBy(css = "#password")
	public WebElement passwordField;

	@FindBy(xpath = "//button[text()='Login']")
	public WebElement loginButton;

	@FindBy(id = "newAccountBtn")
	public WebElement createNewAccountButton;

}
