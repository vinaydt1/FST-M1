package fst_m1_selenium_project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity1 {

	WebDriver driver;

	@BeforeClass
	public void beforeMethod() {
		driver = new FirefoxDriver();
		driver.get("https://alchemy.hguy.co/jobs");

	}

	@Test
	public void testCase() {

		// Goal: Read the title of the website1 and verify the text
		
		String title = driver.getTitle();
		Assert.assertEquals("Alchemy Jobs – Job Board Application", title);
	}

	@AfterClass
	public void afterMethod() {
		driver.close();
	}

}
