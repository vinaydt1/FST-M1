package activities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;
public class Activity7 {
    WebDriverWait wait;
    AndroidDriver driver;

    @BeforeClass
    public void beforeClass() throws MalformedURLException, URISyntaxException {
        // Desired Capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.android.chrome");
        options.setAppActivity("com.google.android.apps.chrome.Main");
        options.noReset();

        // Server URL
        URL serverURL = new URI("https://localhost:4723").toURL();

        // Driver initialization
        driver = new AndroidDriver(serverURL, options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // Open Selenium page
        driver.get("https://v1.training-support.net/selenium/sliders");
    }

    @Test
    public void swipeTest() {
        // Wait for page to load
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.SeekBar")));
        // Get the size of the screen
        Dimension dims = driver.manage().window().getSize();
        // Set the start and end points
        Point start = new Point((int)(dims.getWidth() * .35), (int)(dims.getHeight() * .49));
        Point end = new Point((int)(dims.getWidth() * .5), (int)(dims.getHeight() * .49));
        // Perform swipe
        doSwipe(driver, start, end, 500);

        // Get the volume level
        String volumeText = driver.findElement(AppiumBy.xpath("//android.view.View[contains(@text, 'Volume')]")).getText();

        // Assertions
        assertTrue(volumeText.contains("50%"));
    }

    private void doSwipe(AndroidDriver driver2, Point start, Point end, int i) {
		// TODO Auto-generated method stub
		
	}

	@AfterClass
    public void afterClass() {
        // Close the browser
        driver.quit();
    }
}