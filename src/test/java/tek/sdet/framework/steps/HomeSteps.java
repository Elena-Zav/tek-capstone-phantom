package tek.sdet.framework.steps;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tek.sdet.framework.pages.POMFactory;
import tek.sdet.framework.utilities.CommonUtility;

public class HomeSteps extends CommonUtility {

//	POMFactory factory = POMFactory.getInstance();
	POMFactory factory = new POMFactory();

	@When("User click on All section")
	public void userClickOnAllSection() {
		click(factory.homePage().AllIcone);
		logger.info("User clicked on All section");
	}

	@And("User on {string}")
	public void userOnDepartment(String department) {
		System.out.println(department + " item from Cucucmber");
		List<WebElement> departments = factory.homePage().sideBar;
		boolean eguality = false;
		for (WebElement el : departments) {
			String dept = el.getText();
			System.out.println(dept + " actual item in SideBar");
			if (el.getText().equals(department)) {
				eguality = true;
				click(el);
				logger.info("User clicked " + dept + " item on The Side Bar");
				break;
			}
		}
		Assert.assertTrue(eguality);
	}

	@Then("below options are present in department")
	public void belowOptionsArePresentInDepartment(DataTable dataTable) {
		List<List<String>> optionsDataTable = dataTable.asLists(String.class);
		List<WebElement> actualOptions = factory.homePage().sideBar;

		for (int i = 0; i < optionsDataTable.get(0).size(); i++) {
			if (actualOptions.get(i).getText().equals(optionsDataTable.get(0).get(i))) {
				Assert.assertTrue(actualOptions.get(i).isDisplayed());
				logger.info(actualOptions.get(i).getText() + " option presents in department");
			} else {
				Assert.assertTrue(false);
			}

		}

	}
}
