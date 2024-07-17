package fst_m1_selenium_project;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity8 {

	WebDriver driver;
	WebDriverWait wait;

	@BeforeClass
	public void beforeMethod() {
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://alchemy.hguy.co/jobs/wp-admin");

	}

	@Test
	public void testCase() {

		// Find the username1 field of the login form and enter the username1 into that
		// field.
		// Find the password field of the login form and enter the password into that
		// field.
		driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys("root");
		driver.findElement(By.xpath("//input[@id = 'user_pass']")).sendKeys("pa$$w0rd");
		driver.findElement(By.xpath("//input[@id = 'wp-submit']")).click();

		// Verify that you have logged in.
		String dboard = driver.findElement(By.xpath("//div[@id = 'wpbody-content'] //h1")).getText();
		System.out.println("Name upon login is: " + dboard);
	    Assert.assertEquals(dboard, "Dashboard");
		

	}

	@AfterClass
	public void afterMethod() {
		// Close the browser
		driver.close();

	}

}
