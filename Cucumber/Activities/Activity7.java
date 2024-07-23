package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity7 {

	public static void main(String[] args) {

	WebDriver driver;
	driver = new FirefoxDriver();
	driver.get("https://google.com");
	driver.findElement(By.name("q")).sendKeys("Cheese", Keys.RETURN);
	WebElement cheese = driver.findElement(By.cssSelector(".gsmt"));
	String famous = cheese.findElement(By.cssSelector(".gsmt.RHmo0d.RES9jf")).getText();
	
	System.out.println("Cheese is in: " + famous); 
	
	driver.close();
	}

}
