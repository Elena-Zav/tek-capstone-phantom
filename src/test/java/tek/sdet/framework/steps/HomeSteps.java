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

public class HomeSteps extends CommonUtility{
	
	POMFactory factory = POMFactory.getInstance();
	
	@When("User click on All section")
	public void userClickOnAllSection() {
		click(factory.homePage().AllIcone);
		logger.info("User clicked on All section");
	}
	
    @And("User on {string}")
    public void userOnDepartment(String department) {
    	List<WebElement> departments = factory.homePage().sideBar;   	
    	for (WebElement el : departments) {
    		System.out.println(el.getText() + " WE ARE HERE!!!");
    		String dept = el.getText();
    		if (el.getText().equals(department)) {
    			click(el);
    			logger.info("User clicked " + dept + " item on The Side Bar");
    			break;
    		}
    	}
    }
    
    @Then("below options are present in department")
    public void belowOptionsArePresentInDepartment(DataTable dataTable) {
    	List<List<String>> departmentOptions = dataTable.asLists(String.class);
    	System.out.println(departmentOptions);
    	List<WebElement> departments = factory.homePage().sideBar;
    	System.out.println(departmentOptions);
    	
    	for (int i=0; i<departmentOptions.get(0).size(); i++) {
    		for (WebElement element : departments) {
    			if (element.getText().equals(departmentOptions.get(0).get(i))) {
    				Assert.assertTrue(element.isDisplayed());
    				logger.info(element.getText() +" item is present");
    			}
        	}
    	}
    }		
    	
}
