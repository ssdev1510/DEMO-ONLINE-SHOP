package PageObjects;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import common.Keywords;

public class PurchaseLaptopPO extends Keywords {

	WebDriver driver;
	boolean result1 = false;
	private static String CartAmount = null;
	private static Logger Log = LogManager.getLogger();
	
	public PurchaseLaptopPO(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Add to cart")
	private WebElement addToCart;

	@FindBy(xpath = ".//a[@id='nava']")
	private WebElement homeLink;

	@FindBy(linkText = "Cart")
	private WebElement cartLink;

	@FindBy(xpath = "/html/body/div[6]/div/div[1]/div/table/tbody/tr")
	private List<WebElement> productList;

	@FindBy(linkText = "Laptops")
	private WebElement categoriesLaptops;

	@FindBy(xpath = ".//button[text()= 'Place Order']")
	private WebElement buttonPlaceOrder;

	@FindBy(xpath = ".//label[@id='totalm']")
	private WebElement totalAmountEle;

	@FindBy(xpath = "(.//label[@id='totalm']//parent::form/div/input)[1]")
	private WebElement detailstListName;

	@FindBy(xpath = "(.//label[@id='totalm']//parent::form/div/input)[2]")
	private WebElement detailstListContry;

	@FindBy(xpath = "(.//label[@id='totalm']//parent::form/div/input)[3]")
	private WebElement detailstListCity;

	@FindBy(xpath = "(.//label[@id='totalm']//parent::form/div/input)[4]")
	private WebElement detailstListCard;

	@FindBy(xpath = "(.//label[@id='totalm']//parent::form/div/input)[5]")
	private WebElement detailstListMonth;

	@FindBy(xpath = "(.//label[@id='totalm']//parent::form/div/input)[6]")
	private WebElement detailstListYear;

	@FindBy(xpath = "//*[@onclick='purchaseOrder()']")
	private WebElement purchaseEle;

	@FindBy(xpath = ".//p[@class = 'lead text-muted ']")
	private WebElement orderDetailEle;

	@FindBy(xpath = ".//button[text()= 'OK']")
	private WebElement buttonOK;

	public void addProductToCart(String productName) throws InterruptedException {
		clickEle(categoriesLaptops);
		Thread.sleep(3000);
		WebElement addProduct = driver.findElement(By.linkText(productName));
		clickEle(addProduct);
		Thread.sleep(5000);
		clickEle(addToCart);
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		clickEle(homeLink);
		Log.info("Product- " + productName + " -successfully added");
	}

	public void delteProduct(String productName) throws InterruptedException {
		clickEle(cartLink);
		Thread.sleep(2000);
		for (WebElement rowEle : productList) {
			List<WebElement> blocks = rowEle.findElements(By.xpath("td"));
			if (blocks.get(1).getText().equalsIgnoreCase(productName)) {
				blocks.get(3).findElement(By.linkText("Delete")).click();
				Log.info("Product- " + productName + " -successfully deleted");
				break;
			}
		}
		Thread.sleep(5000);
	}

	public void clickPlaceOrder() throws InterruptedException {
		clickEle(buttonPlaceOrder);
		Thread.sleep(2000);
	}

	public void addDetails() throws InterruptedException {
		CartAmount = getText(totalAmountEle);
		enterText(detailstListName, "Sahil Singla");
		enterText(detailstListContry, "India");
		enterText(detailstListCity, "Gurgaon");
		enterText(detailstListCard, "41111111111111");
		enterText(detailstListMonth, "12");
		enterText(detailstListYear, "2021");
	}

	public void clickPurchase() throws InterruptedException {
		clickEle(purchaseEle);
		Thread.sleep(3000);
	}

	public void captureOrder() {
		String placedOrderDetails = orderDetailEle.getText();
		Log.info("Order Details : /n " + placedOrderDetails);
	}

	public boolean getOrderDetails() {

		String[] actualCapturedAmount = CartAmount.split(" ");
		String placedOrderDetails = orderDetailEle.getText();
		String[] split = placedOrderDetails.split("\n");
		String[] confirmationResult = null;
		for (String temp : split) {
			if (temp.contains("Amount")) {
				confirmationResult = temp.split(":");
				confirmationResult = confirmationResult[1].trim().split(" ");
			}
		}
		if (confirmationResult[0].equals(actualCapturedAmount[1])) {
			result1 = true;
			Log.info("Success: Actual Amount and Order Amount Matched");
		} else {
			result1 = false;
		}
		return result1;
	}

	public void clickOK() throws InterruptedException {
		clickEle(buttonOK);
		Thread.sleep(2000);
		driver.quit();
	}
}
