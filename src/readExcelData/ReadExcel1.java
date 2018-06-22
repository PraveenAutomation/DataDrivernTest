package readExcelData;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel1 {
public static void main(String[] args) throws Exception {
		
		File src = new File("E:\\BULUT DRIVE\\SELENIUM VIDEOS -ALL\\Data Drivern Framework Mat\\ExcelData\\TestData.xlsx");
		
		FileInputStream fis = new FileInputStream(src);
		
		XSSFWorkbook wb = new XSSFWorkbook(fis); //-->Use whenever excel file format is .xlsx
		XSSFSheet  sheet1= wb.getSheetAt(0);
		
		//HSSFWorkbook hwb = new HSSFWorkbook(fis);-->Use whenever excel file format is .xls
		
		int rowCount=sheet1.getLastRowNum();
		System.out.println("Total No. of rows: "+rowCount);
		
		for(int i=0;i<rowCount;i++)
		{
			String data0=sheet1.getRow(i).getCell(0).getStringCellValue();
			System.out.println("Data from Excel: "+data0);
		}
		
		
		wb.close();

	}

}
