package com.datadriven.test;

import com.excel.utility.Xls_Reader;

public class ExcelOperation {
	
	public static void main(String[] args) {
		
		Xls_Reader reader=new Xls_Reader("C:\\Users\\Dell\\12_Feb_Automation\\"
				+ "LearnDataDriverFrameworkTesting\\src\\com\\testdata\\HalfEbayTestData3.xlsx");
		
		if(!reader.isSheetExist("HomePage1"))
		{
		reader.addSheet("HomePage1");
		}
		
		int colCount=reader.getColumnCount("RegTestData");
		System.out.println("Total Column county in RegTestData:: "+colCount);
		
		String data = reader.getCellData("RegTestData", "firstname", 2);
		System.out.println(data);
	}

}
