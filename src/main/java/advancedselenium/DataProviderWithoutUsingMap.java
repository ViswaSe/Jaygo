package advancedselenium;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderWithoutUsingMap {
	
	@DataProvider(name="fetchData")
	public Object[][] readValuesFromExcelWithoutUsingMap() throws IOException
	{
		File file = new File("./data/Sample.xlsx");
		FileInputStream fis =  new FileInputStream(file);
		
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(0);
		
		int rowSize = sheet.getLastRowNum();
		int cellSize = sheet.getRow(0).getLastCellNum();
		
		Object[][] data = new Object[rowSize][cellSize];
		
		for(int i=1;i<=rowSize;i++)
		{
			XSSFRow row = sheet.getRow(i);
			for(int j=0;j<cellSize;j++)
			{
				String text = row.getCell(j).getStringCellValue();
				data[i-1][j] = text;
			}
		}
		
		wb.close();
		return data;
	}
	
	@Test(dataProvider = "fetchData")
	public static void getData(String username,String password)
	{
		System.out.println(username+ " - "+ password);
	}

}
