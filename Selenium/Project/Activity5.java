package fst_m1_selenium_project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity5 {
	WebDriver driver;

	@BeforeClass
	public void beforeMethod() {

		// Open a browser & navigate to ‘ https://alchemy.hguy.co/jobs
		driver = new FirefoxDriver();
		driver.get("https://alchemy.hguy.co/jobs");
	}

	@Test
	public void testCase() {
		// Find the navigation bar, Select the menu item that says “Jobs” and click it.
		driver.findElement(By.linkText("Jobs")).click();

		// Read the page title and verify that you are on the correct page.
		String title = driver.getTitle();
		System.out.println("Title of Jobs page is: " + title);
		Assert.assertTrue(true);
	}

	@AfterClass
	public void afterMethod() {
		driver.close();
	}

}
