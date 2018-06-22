package com.datadriven.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.excel.utility.Xls_Reader;

public class ParametrizeTest {

	public static void main(String[] args) {
		
		//WeDriver Code
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/drivers/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("https://scgi.half.ebay.com/ws/eBayISAPI.dll?RegisterEnterInfo&usage=2943&ru=");
		
		//Data Driven Framework(Parameterization)
		Xls_Reader reader=new Xls_Reader("C:\\Users\\Dell\\12_Feb_Automation\\"
				+ "LearnDataDriverFrameworkTesting\\src\\com\\testdata\\HalfEbayTestData3.xlsx");
		
		int rowCount=reader.getRowCount("RegTestData");
		
		//Parameterization
		for(int rowNum=2;rowNum<=rowCount;rowNum++)
		{
			System.out.println("======");
			String firstName=reader.getCellData("RegTestData", "firstname", rowNum);
			System.out.println(firstName);
			
			String lastName = reader.getCellData("RegTestData", "lastname", rowNum);
			System.out.println(lastName);
			
			String address1 = reader.getCellData("RegTestData", "address1", rowNum);
			System.out.println(address1);
			
			String address2 = reader.getCellData("RegTestData", "address2", rowNum);
			System.out.println(address2);
			
			String city = reader.getCellData("RegTestData", "city", rowNum);
			System.out.println(city);
			
			String state = reader.getCellData("RegTestData", "state", rowNum);
			System.out.println(state);
			
			String pincode = reader.getCellData("RegTestData", "pincode", rowNum);
			System.out.println(pincode);
			
			String emailaddress = reader.getCellData("RegTestData", "emailaddress", rowNum);
			System.out.println(emailaddress);
			
			

			//Enter Data
			driver.findElement(By.cssSelector("#firstname")).clear();
			driver.findElement(By.cssSelector("#firstname")).sendKeys(firstName);
			
			driver.findElement(By.cssSelector("#lastname")).clear();
			driver.findElement(By.cssSelector("#lastname")).sendKeys(lastName);
			
			driver.findElement(By.cssSelector("#address1")).clear();
			driver.findElement(By.cssSelector("#address1")).sendKeys(address1);
			
			driver.findElement(By.cssSelector("#address2")).clear();
			driver.findElement(By.cssSelector("#address2")).sendKeys(address2);
			
			driver.findElement(By.cssSelector("#city")).clear();
			driver.findElement(By.cssSelector("#city")).sendKeys(city);
			
			Select select = new Select(driver.findElement(By.cssSelector("#state")));
			select.selectByVisibleText(state);
			
			driver.findElement(By.cssSelector("#zip")).clear();
			driver.findElement(By.cssSelector("#zip")).sendKeys(pincode);
			
			driver.findElement(By.cssSelector("#email")).clear();
			driver.findElement(By.cssSelector("#email")).sendKeys(emailaddress);
			
			driver.findElement(By.cssSelector("#retype_email")).clear();
			driver.findElement(By.cssSelector("#retype_email")).sendKeys(emailaddress);

		}
		

	}

}
