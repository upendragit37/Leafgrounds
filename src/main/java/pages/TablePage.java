package pages;

import java.util.List;

import javax.swing.event.ListDataEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import projectbase.projectSpecificMethods;

public class TablePage extends projectSpecificMethods {

	static int columns_count;
	static int rows_count;
	static List<WebElement> Columns_row;
	static List<WebElement> rows_table;
	static WebElement tableElem;
	static String Progress[];

	public TablePage tablePage_Click() throws InterruptedException {
		driver.findElementByXPath("//img[@alt='Table']").click();
		return this;
	}

	public TablePage tablePage_Field() {
		// Getting the table
		tableElem = driver.findElementById("table_id");

		// Getting all the rows in the table
		rows_table = tableElem.findElements(By.tagName("tr"));
		rows_count = rows_table.size();

		for (int row = 0; row < rows_count; row++) {

			// Getting all the data in a particular row
			Columns_row = rows_table.get(row).findElements(By.tagName("td"));
			columns_count = Columns_row.size();
		}
		// Get the count of number of columns
		System.out.println("The Count of Columns is :" + columns_count);

		// Get the count of number of rows
		System.out.println("The Count of Rows is :" + rows_count);

		// Get the progress value of 'Learn to interact with Elements'
		List<WebElement> row2Datas = rows_table.get(2).findElements(By.tagName("td"));
		WebElement index0Data = row2Datas.get(0);
		System.out.println(index0Data.getText());

		// Check the vital task for the least completed progress.
		Progress = new String[columns_count];
		for (int i = 1; i < rows_count; i++) {
			List<WebElement> specificRows = rows_table.get(i).findElements(By.tagName("td"));
			System.out.println(specificRows.get(1).getText());
			String temp = specificRows.get(1).getText();
			Progress[i] = temp;
		}

		for (String print : Progress)
			System.out.println(print);
		  
		
		List<WebElement> specificRows = rows_table.get(3).findElements(By.tagName("td"));
		WebElement webElement = specificRows.get(2);
		WebElement findElement = webElement.findElement(By.tagName("input"));
		boolean selected = findElement.isSelected();
		if (selected != true)
			findElement.click();

		// printing the table
		// System.out.println("Number of cells In Row " + row + " are " +
		// columns_count);
		// Loop will execute till the last cell of that specific row.
//			for (int column = 0; column < columns_count; column++) {
//				// To retrieve text from that specific cell.
//				String celtext = Columns_row.get(column).getText();
//				System.out.println("Cell Value of row number " + row + " and column number " + column + " Is " + celtext);
//			}
//			System.out.println("-------------------------------------------------- ");
//		}

		return new TablePage();
	}
}
