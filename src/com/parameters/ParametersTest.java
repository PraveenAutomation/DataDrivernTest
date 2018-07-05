package com.parameters;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParametersTest {
	
	WebDriver driver;
	
	@Test
	@Parameters({"env","browser","url","emailId"})
	public void yahooLogintest(String env,String browser,String url,String emailId)
	{
		if(browser.equalsIgnoreCase("Chrome"))
		{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/drivers/chromedriver.exe");
		driver= new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/drivers/geckodriver.exe");
			driver= new FirefoxDriver();
		}
		
		driver.get(url);
		
		driver.findElement(By.xpath("//input[@id='login-username']")).clear();
		driver.findElement(By.xpath("//input[@id='login-username']")).sendKeys(emailId);
		
		driver.findElement(By.xpath("//input[@id='login-signin']")).click();
		
	}

}
