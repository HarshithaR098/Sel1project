package dataproviderExcel;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import constants.ApplicationContants;
import demoutils.ExecelUtil;

public class DataProvideExcel implements ApplicationContants {

	@DataProvider(name="exceldata")
	public String[][] getExcelData() throws IOException {
		ExecelUtil.loadExcel(EXCEL_PATH,EXCEL_SHEETNAME);
		int rowCount = ExecelUtil.getLastRowNum();
		int colCount = ExecelUtil.getLastCellNum(1); // Get column count from first data row (1), not header (0)

		String[][] data = new String[rowCount+1][colCount];

		for(int i=0; i<=rowCount; i++) {
			for(int j=0; j<colCount; j++) {
				data[i][j] = ExecelUtil.getCellData(i, j); // Adjust index to start at 0
			}
		}
		ExecelUtil.closeExcel();
		return data;
	}
}
