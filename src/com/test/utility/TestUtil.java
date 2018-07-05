package com.test.utility;

import java.util.ArrayList;

import com.excel.utility.Xls_Reader;

public class TestUtil {
	
	static Xls_Reader reader;
	
	
	public static ArrayList<Object[]> getTestDataFromExcel()
	{
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		
		try {
			reader = new Xls_Reader("C:\\Users\\Dell\\12_Feb_Automation\\LearnDataDriverFrameworkTesting\\src\\com\\testdata\\HalfEbayTestData3.xlsx");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		for (int rowNum = 2; rowNum <= reader.getRowCount("RegTestData"); rowNum++) {
			
				String firstName = reader.getCellData("RegTestData", "firstname", rowNum);
				String lastName = reader.getCellData("RegTestData", "lastname", rowNum);
				String address1 = reader.getCellData("RegTestData", "address1", rowNum);
				String address2 = reader.getCellData("RegTestData", "address2", rowNum);
				String city = reader.getCellData("RegTestData", "city", rowNum);
				String state = reader.getCellData("RegTestData", "state", rowNum);
				String pinCode = reader.getCellData("RegTestData", "pincode", rowNum);
				String emailAddress = reader.getCellData("RegTestData", "emailaddress", rowNum);

				Object ob[] = {firstName, lastName, address1, address2, city, state, pinCode, emailAddress};
				myData.add(ob);
				
		}
		return myData;
	}

}
