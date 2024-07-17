package fst_m1_selenium_project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity2 {
	WebDriver driver;

	@BeforeClass
	public void beforeMethod() {
		driver = new FirefoxDriver();
		driver.get("https://alchemy.hguy.co/jobs");
	}

	@Test
	public void testCase() {
		// Goal: Read the heading of the website1 and verify the text

		WebElement text1 = driver.findElement(By.xpath("//h1[@class='entry-title']"));
		System.out.println("HEADING TEXT IS: " + text1.getText());

		Assert.assertEquals(text1.getText(), "Welcome to Alchemy Jobs");

	}

	@AfterClass
	public void afterMethod() {
		driver.close();
	}

}
