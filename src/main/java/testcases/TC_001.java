package testcases;

import org.testng.annotations.Test;
import pages.*;
import testng.api.base.projectSpecificMethods;

public class TC_001 extends projectSpecificMethods{

	@Test(invocationCount=1,alwaysRun=true)
	public void Test_1() throws InterruptedException{
		new TablePage()
		.tablePage_Click()
		.tablePage_Field();
		
//		ButtonPage n = new ButtonPage();
//		n.ButtonPage_Click();
//		n.ButtonPage_Field();
	}
}
