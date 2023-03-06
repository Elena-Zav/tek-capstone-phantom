package tek.sdet.framework.pages;

import tek.sdet.framework.base.BaseSetup;

public class POMFactory extends BaseSetup {
//	private static POMFactory POMFactory;
	private RetailHomePage homePage;
	private RetailSignInPage signInPage;
	private RetailAccountPage accountPage;
	private RetailOrderPage orderPage;
	private RetailSignUpPage signUpPage;

	// if Singleton DP - the constructor should be private
	public POMFactory() {
		this.homePage = new RetailHomePage();
		this.signInPage = new RetailSignInPage();
		this.accountPage = new RetailAccountPage();
		this.orderPage = new RetailOrderPage();
		this.signUpPage = new RetailSignUpPage();
	}

//	public static POMFactory getInstance() {
//		if (POMFactory == null)
//			POMFactory = new POMFactory();
//		return POMFactory;
//	}

	public RetailHomePage homePage() {
		return this.homePage;
	}

	public RetailSignInPage signInPage() {
		return this.signInPage;
	}

	public RetailAccountPage accountPage() {
		return this.accountPage;
	}

	public RetailOrderPage orderPage() {
		return this.orderPage;
	}

	public RetailSignUpPage signUpPage() {
		return this.signUpPage;
	}

}
