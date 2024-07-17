package fst_m1_selenium_project;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity7 {
	WebDriver driver;
	WebDriverWait wait;

	@BeforeClass
	public void beforeMethod() {
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));

//		a. Open a browser.
//		b. Navigate to ‘https://alchemy.hguy.co/jobs’

		driver.get("https://alchemy.hguy.co/jobs");
	}

	@Test
	public void testCase() {

		// Locate the navigation menu and click the menu item that says “Post a Job”
		driver.findElement(By.linkText("Post a Job")).click();

		// Fill in the necessary details and click the button that says “Preview”.
		driver.findElement(By.id("create_account_email")).sendKeys("vinays022@gmail.com");
		driver.findElement(By.id("job_title")).sendKeys("QE Testing");
		driver.findElement(By.id("job_location")).sendKeys("Scotland");
		// select from the dropdown1
		WebElement staticDropdown = driver.findElement(By.id("job_type"));
		Select dropdown = new Select(staticDropdown);
		dropdown.selectByIndex(3);

		// iframe1 usage in Description field
		WebElement iframe = driver.findElement(By.xpath("//iframe[@id='job_description_ifr']"));
		driver.switchTo().frame(iframe);
		WebElement tinymce = driver.findElement(By.id("tinymce"));
		tinymce.clear();
		tinymce.sendKeys("Should have excellant hands on exp in Java, Selenium, TestNg, Cucumber, API testing");
		driver.switchTo().defaultContent();
		// close iframe1 as above once done

		driver.findElement(By.id("application")).sendKeys("vinays022@gmail.com");
		driver.findElement(By.id("company_name")).sendKeys("IBM");
		driver.findElement(By.xpath("//input[@value='Preview']")).click();

		// Click on the button that says “Submit Listing”
		driver.findElement(By.xpath("//input[@id='job_preview_submit_button']")).click();

		// Verify that the job listing was posted by visiting the jobs page.

		driver.findElement(By.linkText("click here")).click();

		String jobName = driver.findElement(By.xpath("//h1[@class='entry-title']")).getText();
		
		Assert.assertEquals("QE Testing", jobName);
	
		
	}
	

	@AfterClass
	public void afterMethod() {
		driver.close();
	}

}
