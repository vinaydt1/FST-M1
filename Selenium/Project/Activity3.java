package fst_m1_selenium_project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity3 {

	WebDriver driver;

	@BeforeClass
	public void beforeMethod() {
		driver = new FirefoxDriver();
		driver.get("https://alchemy.hguy.co/jobs");
	}

	@Test
	public void testCase() {
		// Get the url1 of the header image.
		
		//tagname[contains(@attribute, 'value')]// 
		
	WebElement test = driver.findElement(By.cssSelector(".attachment-large.size-large.wp-post-image"));
	
	//Get the url1 of the header image
	String urls = test.getAttribute("srcset");
	
    //Print the url to the console.
	System.out.println(urls);

	}

	@AfterClass
	public void afterMethod() {
		driver.close();
	}
	
	
	
	
}
