package stepDefinitions;


import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import PageObjects.NavigationPagePO;
import common.WebDriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class NavigationStepDef extends WebDriverManager {

	WebDriver driver;
	boolean result =  false;
	
	@Given("Open the browser and hit the URL {string}")
	public void open_the_browser_and_hit_the_url(String string) {
		driver = openChromeWithURL(string);
	}

	@When("customer click and navigates to {string}")
	public void customer_click_and_navigates_to(String string) {
		NavigationPagePO NavPO= new NavigationPagePO(driver);
		NavPO.clickCategory(string);
		
		}

	@Then("customer should navigate to {string}")
	public void customer_should_navigate_to(String string) {
		boolean result =  false;
		NavigationPagePO NavPO= new NavigationPagePO(driver);
		result = NavPO.verifyNaviagatePage(string);
		Assert.assertTrue(result);
		System.out.println(result + " : Navigation to category is success");
		driver.quit();
		
	}

	
	
}
