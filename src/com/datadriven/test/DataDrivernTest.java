package com.datadriven.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.excel.utility.Xls_Reader;

public class DataDrivernTest {

	public static void main(String[] args) {
		
		
		
		Xls_Reader reader=new Xls_Reader("C:\\Users\\Dell\\12_Feb_Automation\\"
				+ "LearnDataDriverFrameworkTesting\\src\\com\\testdata\\HalfEbayTestData3.xlsx");
		
		String firstName = reader.getCellData("RegTestData", "firstname", 2);
		System.out.println(firstName);
		
		String lastName = reader.getCellData("RegTestData", "lastname", 2);
		System.out.println(lastName);
		
		String address1 = reader.getCellData("RegTestData", "address1", 2);
		System.out.println(address1);
		
		String address2 = reader.getCellData("RegTestData", "address2", 2);
		System.out.println(address2);
		
		String city = reader.getCellData("RegTestData", "city", 2);
		System.out.println(city);
		
		String state = reader.getCellData("RegTestData", "state", 2);
		System.out.println(state);
		
		String pincode = reader.getCellData("RegTestData", "pincode", 2);
		System.out.println(pincode);
		
		String emailaddress = reader.getCellData("RegTestData", "emailaddress", 2);
		System.out.println(emailaddress);
		
		
		
		
		//WeDriver Code
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/drivers/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("https://scgi.half.ebay.com/ws/eBayISAPI.dll?RegisterEnterInfo&usage=2943&ru=");
		
		driver.findElement(By.cssSelector("#firstname")).sendKeys(firstName);
		driver.findElement(By.cssSelector("#lastname")).sendKeys(lastName);
		
		driver.findElement(By.cssSelector("#address1")).sendKeys(address1);
		driver.findElement(By.cssSelector("#address2")).sendKeys(address2);
		
		driver.findElement(By.cssSelector("#city")).sendKeys(city);
		
		Select select = new Select(driver.findElement(By.cssSelector("#state")));
		select.selectByVisibleText(state);
		
		driver.findElement(By.cssSelector("#zip")).sendKeys(pincode);
		driver.findElement(By.cssSelector("#email")).sendKeys(emailaddress);
		driver.findElement(By.cssSelector("#retype_email")).sendKeys(emailaddress);

		
		
		
		
		//System.out.println(System.getProperty("user.dir")+"/src/com/excel/utility/Xls_Reader.java");
		
		

	}

}
