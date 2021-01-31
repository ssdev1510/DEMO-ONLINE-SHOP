package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Keywords {
	WebDriver driver;

	// Click on element
	public void clickEle(WebElement ele) {
		try {
			ele.click();
			Thread.sleep(3000);
		} catch (Exception e) {
			System.out.println("Error in clicking webElement: Error - " + e);
		}
	}

	// Enter text in text box
	public void enterText(WebElement ele, String text) {
		try {
			ele.clear();
			ele.sendKeys(text);
			Thread.sleep(3000);

		} catch (Exception e) {
			System.out.println("Error in entering text: Error - " + e);
		}
	}

	// verify text
	public boolean verifyText(WebElement ele, String text) {
		boolean result = false;
		try {
			ele.getText().equalsIgnoreCase(text);
			result = true;
		} catch (Exception e) {
			System.out.println("Text does not matched with expecected text - " + e);
		}
		return result;
	}

	// IsDispayed
	public boolean verifyIsDisplayed(WebElement ele) {
		boolean result = false;
		try {
			ele.isDisplayed();
			result = true;
		} catch (Exception e) {
			System.out.println("Text does not matched with expecected text - " + e);
		}
		return result;
	}
	
	//get Text
	public String getText(WebElement ele) {
		String val = null;
		try {
			val = ele.getText();
			
		} catch (Exception e) {
			System.out.println("Text does not found - " + e);
		}
		return val;
	}
}
