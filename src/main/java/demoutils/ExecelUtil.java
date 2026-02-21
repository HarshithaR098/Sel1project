package demoutils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExecelUtil {
	private static FileInputStream fis;
	private static XSSFWorkbook workbook;
	private static XSSFSheet sheet;
	private static XSSFRow row;
	private static XSSFCell cell;

	public static void loadExcel(String filePath, String sheetName) throws IOException {
		fis = new FileInputStream(filePath);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet(sheetName);
	}
	public static String getCellData(int rowNum, int colNum) {
		row = sheet.getRow(rowNum);
		cell = row.getCell(colNum);
		String cellData = cell.getStringCellValue();
		return cellData;
	}
	public static int getLastRowNum() {
		return sheet.getLastRowNum();
	}
	public static int getLastCellNum(int rowNum) {
		row = sheet.getRow(rowNum);
		return row.getLastCellNum();
	}
	public static void closeExcel() throws IOException {
		workbook.close();
		fis.close();
	}

}
