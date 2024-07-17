package fst_m1_selenium_project;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity9 {
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
		driver.findElement(By.xpath("//li[@id = 'menu-posts-job_listing'] //div[@class = 'wp-menu-name']")).click();
		driver.findElement(By.xpath("//a[@class = 'page-title-action']")).click();
		
		//move to element and close 
		
		WebElement clickable = driver.findElement(By.cssSelector("svg[xmlns='http://www.w3.org/2000/svg']"));
        new Actions(driver)
                .click(clickable)
                .perform();
        
        driver.findElement(By.xpath("//div[@class = 'editor-post-title'] //textarea[@id = 'post-title-0']")).sendKeys("FST is on");
        
        //Click on publish button

        driver.findElement(By.cssSelector(".components-button.editor-post-publish-panel__toggle.editor-post-publish-button__button.is-primary")).click();
        
        WebElement pubclick = driver.findElement(By.cssSelector(".components-button.editor-post-publish-panel__toggle.editor-post-publish-button__button.is-primary"));
        new Actions(driver)
                .click(pubclick)
                .perform();
        	

}
	
@AfterClass
public void afterMethod() {
		// Close the browser
		driver.close();

	}
}
