package testng.api.base;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class projectSpecificMethods {
ChromeDriver driver;
	@BeforeMethod
	public void startApp() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_80.exe");
		driver= new ChromeDriver();
		driver.get("https://leafgrounds.com/");
		
	}
	
	@AfterMethod
	public void endApp() {
		
	}
}

