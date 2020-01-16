package org.selenium.utils;

import java.util.HashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.selenium.base.SeMethods;

public class ExcelUtils extends SeMethods{
	
	public Object[][] readExcel(String fileName)
	{
		
		XSSFWorkbook wb;XSSFSheet sheet;XSSFRow row;
		
		Map<Object,Object> map;
		
		String text;
		
		try 
		{
			wb=new XSSFWorkbook("./data/"+fileName+".xlsx");
			sheet=wb.getSheetAt(0);
			
			int rows=sheet.getLastRowNum();
			int cols=sheet.getRow(0).getLastCellNum();
			
			Object[][] data=new Object[rows][1];
			
			for(int i=1;i<=rows;i++)
			{
				row=sheet.getRow(i);
				map=new HashMap<Object,Object>();
				for(int j=0;j<cols;j++)
				{
					text=row.getCell(j).getStringCellValue();
					
					if(!(text.equals("")))
					{
						map.put(sheet.getRow(0).getCell(j).getStringCellValue(), text);
					}
					else
					{
						map.put(sheet.getRow(0).getCell(j).getStringCellValue(), "");
					}
					
				}
				System.out.println(map);
				data[i-1][0]=map;
			}
			
			System.out.println("Reading values from excel successfully done");
			wb.close();
			
			return data;
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			reportStep("couldn't read the values from the excel as expected","error");
		}
		
		return null;
		 
	}

}
