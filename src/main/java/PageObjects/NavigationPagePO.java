package PageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import common.Keywords;

public class NavigationPagePO extends Keywords {

	WebDriver driver;
	boolean result1 = false;
	private static Logger Log = LogManager.getLogger();

	public NavigationPagePO(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Phones")
	private WebElement categoriesPhones;

	@FindBy(linkText = "Laptops")
	private WebElement categoriesLaptops;

	@FindBy(linkText = "Monitors")
	private WebElement categoriesMonitors;

	@FindBy(xpath = "(.//div[@id=\"tbodyid\"]/div/div/div/h4/a)[1]")
	private WebElement firstProductName;

	public void clickCategory(String catName) {
		if (catName.equalsIgnoreCase("Phones")) {
			clickEle(categoriesPhones);
			Log.info("Success- Navigated to Phones page");
		} else if (catName.equalsIgnoreCase("Laptops")) {
			clickEle(categoriesLaptops);
			Log.info("Successs- Navigated to Laptops page");
		} else if (catName.equalsIgnoreCase("Monitors")) {
			clickEle(categoriesMonitors);
			Log.info("Success- Navigated to Monitors page");
		} else {
			Log.info("Fail- Category page is not available");
		}

	}

	public boolean verifyNaviagatePage(String catName) {
		result1 = verifyText(firstProductName, catName);
		return result1;
	}

}
