package common;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverManager {
	WebDriver driver;

//Open Chrome Browser	
	public WebDriver openChromeWithURL(String baseUrl) {
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.get(baseUrl);
    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    return driver;
	}
}
