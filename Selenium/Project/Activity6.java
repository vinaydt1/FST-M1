package fst_m1_selenium_project;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity6 {

	WebDriver driver;
	WebDriverWait wait;

	@BeforeClass
	public void beforeMethod() {
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		driver.get("https://alchemy.hguy.co/jobs");

	}

	@Test
	public void testCase() {

		// navigate to the jobs page
		driver.findElement(By.linkText("Jobs")).click();

		// Search for a particular job and wait for listings to show.
		driver.findElement(By.id("search_keywords")).sendKeys("Banking");

		driver.findElement(By.xpath("//input[@type = 'submit']")).click();

		// Click on a Job posting
		WebElement ulclass = driver.findElement(By.xpath("//div[@class='job_listings']"));
		WebElement jobPosting = ulclass.findElement(By.cssSelector(".post-7820.job_listing.type-job_listing.status-publish.hentry.job-type-full-time"));
		jobPosting.click();

		// Click the apply button and print the email to the console.
		WebElement applyButton = driver.findElement(By.cssSelector(".application_button.button"));
		applyButton.click();
		
		//get the email and print to console
		String email = driver.findElement(By.className("job_application_email")).getText();
		System.out.println("email your details to: " + email);
		
		
	}

	@AfterClass
	public void afterMethod() {
		driver.close();

	}

}
