package stepDefinitions;



import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import PageObjects.NavigationPagePO;
import PageObjects.PurchaseLaptopPO;
import common.WebDriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PurchaseLaptopStepDef extends WebDriverManager {

	WebDriver driver;
	boolean result = false;

	@Given("Open the browser and hits the URL {string}")
	public void open_the_browser_and_hit_the_url(String string) {
		driver = openChromeWithURL(string);
	}

	@When("customer clicks and navigates to {string}")
	public void customer_click_and_navigates_to(String string) {
		NavigationPagePO NavPO= new NavigationPagePO(driver);
		NavPO.clickCategory(string);
		}


	@When("Add the first product {string} to cart")
	public void add_the_first_product_to_cart(String string) throws InterruptedException {
		PurchaseLaptopPO purPO = new PurchaseLaptopPO(driver);
		purPO.addProductToCart(string);
	}

	@When("Add the second product {string} to cart")
	public void add_the_second_product_to_cart(String string) throws InterruptedException {
		PurchaseLaptopPO purPO = new PurchaseLaptopPO(driver);
		purPO.addProductToCart(string);
	}

	@When("Delete added product {string} from cart")
	public void delete_added_product_from_cart(String string) throws InterruptedException {
		PurchaseLaptopPO purPO = new PurchaseLaptopPO(driver);
		purPO.delteProduct(string);
	}

	@When("Click on Place order")
	public void click_on_place_order() throws InterruptedException {
		PurchaseLaptopPO purPO = new PurchaseLaptopPO(driver);
		purPO.clickPlaceOrder();
	}

	@When("Fill all the required details")
	public void fill_all_the_required_details() throws InterruptedException {
		PurchaseLaptopPO purPO = new PurchaseLaptopPO(driver);
		purPO.addDetails();
	}

	@When("Click on Purchase to Complete the order")
	public void click_on_purchase_to_complete_the_order() throws InterruptedException {
		PurchaseLaptopPO purPO = new PurchaseLaptopPO(driver);
		purPO.clickPurchase();
	}

	@When("Capture the log purchase Id and Amount.")
	public void capture_the_log_purchase_id_and_amount() throws InterruptedException {
		PurchaseLaptopPO purPO = new PurchaseLaptopPO(driver);
		purPO.captureOrder();
	}

	@Then("Check Order amount should be equal to product price")
	public void check_order_amount_should_be_equal_to_product_price() {
		PurchaseLaptopPO purPO = new PurchaseLaptopPO(driver);
		result = purPO.getOrderDetails();
		Assert.assertTrue(result);
		System.out.println("Success: Acutal Amount and Order Amount Matched");
	}

	@Then("Click on Ok")
	public void click_on_ok() throws InterruptedException {
		PurchaseLaptopPO purPO = new PurchaseLaptopPO(driver);
		purPO.clickOK();
		
	}

}
