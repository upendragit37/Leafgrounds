package Excel;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadFromExcel {
	public static void main(String args[]) {

		File file = new File("C:\\Users\\fasupport\\Documents\\GSTRINProcess\\GSTR Upload -ITC\\ITC Valid.xlsx");
		try {
//		System.out.println("---------Checking " + Name + "------");
			FileInputStream fis = new FileInputStream(file);
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sheet1 = wb.getSheetAt(0);

			int rowNum = sheet1.getLastRowNum();
			Row r = sheet1.getRow(rowNum);

			int maxCell = r.getLastCellNum();
			System.out.println("Maxcell = " + maxCell);

			for (int i = 0; i < rowNum; i++) {
				System.out.print("\n");
				for (int j = 0; j < maxCell; j++) {
					Row row = sheet1.getRow(i);
					Cell cell = row.getCell(j);
					if (cell.getCellType() == CellType.NUMERIC) {
						Double value1 = cell.getNumericCellValue();
						System.out.print(value1 +"\t");
					}

					else if (cell.getCellType() == CellType.STRING) {
						String value = sheet1.getRow(i).getCell(j).getStringCellValue();
						System.out.print(value +"\t");
					}
					
					else if (cell.getCellType() == CellType.BLANK) {
						String value = sheet1.getRow(i).getCell(j).getStringCellValue();
						System.out.print(value +"\t");
					}				}
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

	}
}
