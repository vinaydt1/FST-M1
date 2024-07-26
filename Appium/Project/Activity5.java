package liveProject;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import static activities.ActionsBase.doSwipe;

public class Activity5 {
	AndroidDriver driver;
	WebDriverWait wait;

	@BeforeClass
	public void setUp() throws MalformedURLException, URISyntaxException {
		// Desired capabilities
		UiAutomator2Options options = new UiAutomator2Options();
		options.setPlatformName("android");
		options.setAutomationName("UiAutomator2");

		// open chrome1 in phone, refresh in appium1 inspector, so we can see chrome1 on
		// the inspector
		// In inspector, click on 'Commands' tab > 'App1 Management' > click on
		// 'getCurrentPackage', copy an paste in the code > same way click on
		// getCurrentActivity

		options.setAppPackage("com.android.chrome");
		options.setAppActivity("com.google.android.apps.chrome.Main");
		options.noReset();

		// Set the Appium1 Server URL
		URL serverURL = new URI("http://localhost:4723").toURL();

		// Driver Initialization
		driver = new AndroidDriver(serverURL, options);
		wait = new WebDriverWait(driver, Duration.ofSeconds(40));

		// Open Selenium1 page
		driver.get("https://v1.training-support.net/selenium");
	}

	@Test
	public void webAppTest() throws InterruptedException {
		//get width and height of the screen
		Dimension dims = driver.manage().window().getSize();
		System.out.println(dims);
		Point start = new Point((int)(dims.getWidth() * 0.5), (int)(dims.getHeight() * 0.8));
		Point end = new Point((int)(dims.getWidth() * 0.5), (int)(dims.getHeight() * 0.6));
		
		// Wait for page to load
		wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.Button[@text='Get Started!']")));
		
		
		// Wait for Login form link and click it
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+Login Form+"\").instance(0))").click();
		
	}
	
	@AfterClass 
	public void afterClass()
	{
      driver.quit();		
				
	}
	
}