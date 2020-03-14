package pages;

import org.openqa.selenium.Keys;

import projectbase.projectSpecificMethods;

public class EditPage extends projectSpecificMethods {

	public EditPage EditPage_Click() throws InterruptedException {
		driver.findElementByXPath("//img[@alt='Edit / Text Fields']").click();
		Thread.sleep(2000);
		return this;
	}

	public ButtonPage EditPage_Field() {

		driver.findElementById("email").sendKeys("test@gmail.com");

		driver.findElementByXPath("(//input[@type='text'])[2]").sendKeys("Appended text", Keys.TAB);
		
		System.out.println(driver.findElementByXPath("(//input[@name='username'])[1]").getAttribute("value"));

		driver.findElementByXPath("(//input[@name='username'])[2]").clear();
		
		if(driver.findElementByXPath("(//input[@type='text'])[5]").isEnabled()!=true)
			System.out.println("Not Enabled\n\n");
		
		driver.findElementByXPath("//img[@alt='logo Testleaf']").click();
		return new ButtonPage();
	}
	
}
