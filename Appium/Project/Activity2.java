package liveProject;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity2 {
	AndroidDriver driver;
	WebDriverWait wait;

	@BeforeClass
	public void setUp() throws MalformedURLException, URISyntaxException {
		// Desired capabilities
		UiAutomator2Options options = new UiAutomator2Options();
		options.setPlatformName("android");
		options.setAutomationName("UiAutomator2");

		options.setAppPackage("com.google.android.keep");
		options.setAppActivity(".activities.BrowseActivity");
		options.noReset();

		// Set the Appium1 Server URL
		URL serverURL = new URI("http://localhost:4723").toURL();

		// Driver Initialization
		driver = new AndroidDriver(serverURL, options);
		wait = new WebDriverWait(driver, Duration.ofSeconds(40));

	}

	@Test
	public void webAppTest() throws InterruptedException {
		Dimension dims = driver.manage().window().getSize();
		System.out.println(dims);

		// Click the button to add a new task.
		driver.findElement(AppiumBy.xpath("////android.widget.ImageButton[@content-desc=\"New text note\"]")).click();

		// add a title
		driver.findElement(
				AppiumBy.xpath("//android.widget.EditText[@resource-id=\"com.google.android.keep:id/editable_title\"]"))
				.sendKeys("Keep upto date");

		// add a small description
		driver.findElement(
				AppiumBy.xpath("//android.widget.EditText[@resource-id=\"com.google.android.keep:id/edit_note_text\"]"))
				.sendKeys("Organizing is the key");

		// Press the back button and make an assertion to ensure that the note was
		// added.
		driver.findElement(AppiumBy.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]")).click();
		Assert.assertTrue(true);

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}