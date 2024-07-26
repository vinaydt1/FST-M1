package liveProject;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity1 {
	AndroidDriver driver;
	WebDriverWait wait;

	@BeforeClass
	public void setUp() throws MalformedURLException, URISyntaxException {
		// Desired capabilities
		UiAutomator2Options options = new UiAutomator2Options();
		options.setPlatformName("android");
		options.setAutomationName("UiAutomator2");

		options.setAppPackage("com.google.android.apps.tasks");
		options.setAppActivity(".ui.TaskListsActivity");
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

		// Click the button to add 3 new tasks
		driver.findElement(AppiumBy.xpath("//android.widget.ImageButton[@content-desc=\"Create new task\"]")).click();

		driver.findElement(AppiumBy
				.xpath("//android.widget.EditText[@resource-id=\"com.google.android.apps.tasks:id/add_task_title\"]"))
				.sendKeys("Complete Activity with Google Tasks");
		driver.findElement(AppiumBy
				.xpath("//android.widget.Button[@resource-id=\"com.google.android.apps.tasks:id/add_task_done\"]"))
				.click();

		driver.findElement(AppiumBy
				.xpath("//android.widget.EditText[@resource-id=\"com.google.android.apps.tasks:id/add_task_title\"]"))
				.sendKeys("Complete Activity with Google Keep");
		driver.findElement(AppiumBy
				.xpath("//android.widget.Button[@resource-id=\"com.google.android.apps.tasks:id/add_task_done\"]"))
				.click();

		driver.findElement(AppiumBy
				.xpath("//android.widget.EditText[@resource-id=\"com.google.android.apps.tasks:id/add_task_title\"]"))
				.sendKeys("Complete the second Activity Google Keep");
		driver.findElement(AppiumBy
				.xpath("//android.widget.Button[@resource-id=\"com.google.android.apps.tasks:id/add_task_done\"]"))
				.click();

		// Assertion
		List<WebElement> tasksAdded = driver.findElements(AppiumBy.xpath(
				"//android.support.v7.widget.RecyclerView[@resource-id=\"com.google.android.apps.tasks:id/tasks_list\"]"));
		Assert.assertEquals(tasksAdded.size(), 3);

	}

	@AfterClass
	public void afterClass() {
		driver.quit();

	}

}