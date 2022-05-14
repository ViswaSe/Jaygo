package advancedselenium;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderUsingMap {

	@DataProvider(name = "fetchData")
	public Object[][] getDataFromExcel() throws IOException
	{
		File file = new File("./data/Sample.xlsx");
		FileInputStream fis = new FileInputStream(file);
		
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(0);
		
		int rowSize = sheet.getLastRowNum();
		int cellSize = sheet.getRow(0).getLastCellNum();
		
		Map<String,String> map;
		String text;
		Object[][] data = new Object[rowSize][1];
		
		for(int i=1;i<=rowSize;i++)
		{
			XSSFRow row = sheet.getRow(i);
			map = new HashMap<String,String>();
			for(int j=0;j<cellSize;j++)
			{
				text = row.getCell(j).getStringCellValue();
				map.put(sheet.getRow(0).getCell(j).getStringCellValue(), text);
			}
			data[i-1][0] = map;
		}
		
		wb.close();
		return data;
	}
	
	@Test(dataProvider="fetchData")
	public void getDataUsingMap(Map<String,String> map)
	{
		System.out.println(map.get("username") +" - "+map.get("password"));
	}
}
