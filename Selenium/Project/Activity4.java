package fst_m1_selenium_project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity4 {
	WebDriver driver;

	@BeforeClass
	public void beforeMethod() {
		driver = new FirefoxDriver();
		driver.get("https://alchemy.hguy.co/jobs");

	}

	@Test
	public void testCase() {

		// Get the second heading on the page
		WebElement outertag = driver.findElement(By.cssSelector(".entry-content.clear"));
		WebElement tagsname = outertag.findElement(By.tagName("h2"));
		System.out.println("2nd heading name is: " + tagsname.getText());

		// Make sure it matches “Quia quis non” exactly
		Assert.assertEquals("Quia quis non", tagsname.getText());

	}

	@AfterClass
	public void afterMethod() {
		driver.close();
	}
	
}
