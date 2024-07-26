package examples;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity6 {
	//Declare driver
	AppiumDriver driver;
	
	@BeforeClass
	public void setUp() throws MalformedURLException, URISyntaxException {
		//Desired capabilities
		UiAutomator2Options caps = new UiAutomator2Options().
			setPlatformName("android").
			setAutomationName("UiAutomator2").
			setAppPackage("com.sec.android.app.popupcalculator").
			setAppActivity(".Calculator").
			noReset();
				
		// Set the Appium Server URL
		URL serverURL = new URI("http://localhost:4723").toURL();
		
		// Initializing driver
		driver = new AndroidDriver(serverURL, caps);
			
			
	}
	
	@Test
	public void additionTest() {
		//Find digit 6 and tap it
		driver.findElement(AppiumBy.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_06")).click();
		
		//Find the plus button and tap it
		driver.findElement(AppiumBy.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_add")).click();
		
		//Find digit 9 and tap it
		driver.findElement(AppiumBy.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_09")).click();
		
		//Find equals and tap it
	driver.findElement(AppiumBy.accessibilityId("Equal")).click();
		
		// Get the result and assert
	String result = driver.findElement(AppiumBy.id("com.sec.android.app.popupcalculator:id/calc_edt_formula")).getText();
		Assert.assertEquals(result, "15");
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	
	
}