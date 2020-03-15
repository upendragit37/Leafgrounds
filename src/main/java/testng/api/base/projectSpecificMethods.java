package testng.api.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class projectSpecificMethods {
public static ChromeDriver driver;
	@BeforeMethod
	public void startApp1() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_80.exe");
		driver= new ChromeDriver();
		driver.get("http://www.leafground.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}
	
	@AfterMethod
	public void endApp1() {
		System.out.println("THE END");
		//driver.quit();
	}
}

