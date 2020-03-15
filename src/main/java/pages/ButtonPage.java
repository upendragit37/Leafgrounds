package pages;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import testng.api.base.projectSpecificMethods;


public class ButtonPage extends projectSpecificMethods{

	public ButtonPage ButtonPage_Click()   {
		//Thread.sleep(7000);
		driver.findElementByXPath("//img[@alt='Buttons']").click();
		return this;
	}
	
	public void ButtonPage_Field() throws InterruptedException {
		
		Thread.sleep(2000);
		driver.findElementByXPath("//button[@id='home']").click();//sendKeys(Keys.ENTER);
		System.out.println("Home");
		driver.findElementByXPath("//img[@alt='Buttons']").click();
		System.out.println("Buttons");

		
		System.out.println(driver.findElementByXPath("//button[@id='position']").getLocation());
		
		System.out.println(driver.findElementByXPath("//button[@id='color']").getAttribute("style"));
		System.out.println(driver.findElementByXPath("//button[@id='color']").getCssValue("background-color"));
		
		WebElement sizeElement = driver.findElementByXPath("//button[@id='size']");
		int width = sizeElement.getSize().getWidth();
		System.out.println("Width: "+ width);
		
		int height = sizeElement.getSize().getHeight();
		System.out.println("Height: "+ height);
		
	}
}
