package Excel;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadBlankCell {
	static String HeaderForBlank[][];
	static XSSFWorkbook wb;
	static XSSFSheet sheet1;
	static int maxCell;
	static int rowNum;
	public static void main(String args[]) {
	
//		File file = new File("C:\\Users\\fasupport\\Documents\\GSTRINProcess\\GSTR Upload -GSTR1\\Finished files\\GSTR1 Invalid - MandatoryNotFilled_AAA.xlsx");
		File file = new File("C:\\Users\\fasupport\\Documents\\ExcelToReadBlankSpace.xlsx");
		try {
//		System.out.println("---------Checking " + Name + "------");
			FileInputStream fis = new FileInputStream(file);
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sheet1 = wb.getSheetAt(0);

			int rowNum = sheet1.getLastRowNum();
			System.out.println("Rows= "+rowNum);
			Row r = sheet1.getRow(rowNum);
			
			int maxCell = r.getLastCellNum();
			System.out.println("Columns= " + maxCell);
			HeaderForBlank = new String[rowNum][maxCell];
			
			for (int i = 0; i < rowNum; i++) {
				System.out.print("\n");
				for (int j = 0; j < maxCell; j++) {
					Row row = sheet1.getRow(i);
					Cell cell = row.getCell(j);
					if (cell.getCellType() == CellType.BLANK) {
						HeaderForBlank[i][j] = sheet1.getRow(0).getCell(j).getStringCellValue();
						System.out.println(sheet1.getRow(0).getCell(j).getStringCellValue());
					} else {
						HeaderForBlank[i][j] ="No Blank";
					}

				}
			}

		} catch (Exception e) {

			e.printStackTrace();
		}
		
		
		for (int i = 0; i < rowNum; i++) {
			System.out.println();
			for (int j = 0; j <maxCell; j++) {
				System.out.print(HeaderForBlank[i][j]);
			}
			
		}
			
	}
}
