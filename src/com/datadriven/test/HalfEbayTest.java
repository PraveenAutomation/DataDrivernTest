package com.datadriven.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.test.utility.TestUtil;

public class HalfEbayTest {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/drivers/chromedriver.exe");
		
		driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://scgi.half.ebay.com/ws/eBayISAPI.dll?RegisterEnterInfo&usage=2943&ru=");
	}
	
	@DataProvider
	public Iterator<Object[]> getTestData()
	{
		ArrayList<Object[]> testData=TestUtil.getTestDataFromExcel();
		return testData.iterator();
	}
	
	
	
	@Test(dataProvider="getTestData")
	public void halfEbayPageTest(String firstName, String lastName, String address1, String address2, 
			String city, String state, String pincode,String emailaddress )
	{
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
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
