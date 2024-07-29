package activities;

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
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity8 {

	AppiumDriver driver;
	WebDriverWait wait;

	@BeforeClass
	public void setup() throws MalformedURLException, URISyntaxException {

		// Desired Capabilities
		UiAutomator2Options caps = new UiAutomator2Options().setPlatformName("andriod")
				.setAutomationName("UiAutomator2").setAppPackage("com.android.chrome")
				.setAppActivity("com.google.android.apps.chrome.Main").noReset();

		// Set the Appium server URL
		URL serverURL = new URI("http://localhost:4723").toURL();

		// Initializing driver
		driver = new AndroidDriver(serverURL, caps);
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		driver.get("https://v1.training-support.net/selenium/sliders");

	}

	// Test method

	@Test

	public void scrollTest() {

		// Wait for page to load

		wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.className("android.widget.Image")));

		// Get the size of the screen

		Dimension dims = driver.manage().window().getSize();

		// Set the start and end points

		Point start = new Point((int) (dims.getWidth() * .50), (int) (dims.getHeight() * .85));

		Point end = new Point((int) (dims.getWidth() * .50), (int) (dims.getHeight() * .20));

		// Find all the image elements on the page

		List<WebElement> imageElements = driver.findElements(AppiumBy.className("android.widget.Image"));

		// Print the number of images

		System.out.println("Before scroll: " + imageElements.size());

		// Scroll down to Helen

		ActionsBase.doSwipe(driver, start, end, 200);

		// Get image elements after scroll

		imageElements = driver.findElements(AppiumBy.className("android.widget.Image"));

		// Print the number of images after scroll

		System.out.println("After scroll: " + imageElements.size());

		// Assertions

		Assert.assertEquals(imageElements.size(), 3);

	}

	// Tear down method

	@AfterClass

	public void tearDown() {

		// Close the app

		driver.quit();

	}

}
