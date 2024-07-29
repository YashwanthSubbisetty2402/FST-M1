package activities;

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

public class Activity3 {
	AppiumDriver driver;

	@BeforeClass
	public void setup() throws MalformedURLException, URISyntaxException {

		// Desired Capabilities
		UiAutomator2Options caps = new UiAutomator2Options().setPlatformName("andriod")
				.setAutomationName("UiAutomator2").setAppPackage("com.coloros.calculator")
				.setAppActivity("com.android.calculator2.Calculator").noReset();

		// Set the Appium server URL
		URL serverURL = new URI("http://localhost:4723").toURL();

		// Initializing driver
		driver = new AndroidDriver(serverURL, caps);

	}

	@Test(priority=1)
	public void addTest() {

		driver.findElement(AppiumBy.id("com.coloros.calculator:id/digit_5")).click();
		driver.findElement(AppiumBy.accessibilityId("Add")).click();
		driver.findElement(AppiumBy.id("com.coloros.calculator:id/digit_9")).click();
		driver.findElement(AppiumBy.accessibilityId("Equals")).click();
		String result = driver.findElement(AppiumBy.id("com.coloros.calculator:id/result")).getText();
		System.out.println("5 + 9 Result is : " + result);
		Assert.assertEquals(result, "14");
	}

	@Test(priority=2)
	public void subTest() {

		driver.findElement(AppiumBy.id("com.coloros.calculator:id/digit_1")).click();
		driver.findElement(AppiumBy.id("com.coloros.calculator:id/digit_0")).click();
		driver.findElement(AppiumBy.accessibilityId("Subtract")).click();
		driver.findElement(AppiumBy.id("com.coloros.calculator:id/digit_5")).click();
		driver.findElement(AppiumBy.accessibilityId("Equals")).click();
		String result = driver.findElement(AppiumBy.id("com.coloros.calculator:id/result")).getText();
		System.out.println("10 - 5 Result is : " + result);
		Assert.assertEquals(result, "5");
	}

	@Test(priority=3)
	public void mulTest() {

		driver.findElement(AppiumBy.id("com.coloros.calculator:id/digit_5")).click();

		driver.findElement(AppiumBy.accessibilityId("Multiply")).click();
		driver.findElement(AppiumBy.id("com.coloros.calculator:id/digit_1")).click();
		driver.findElement(AppiumBy.id("com.coloros.calculator:id/digit_00")).click();
		driver.findElement(AppiumBy.accessibilityId("Equals")).click();
		String result = driver.findElement(AppiumBy.id("com.coloros.calculator:id/result")).getText();
		System.out.println("5 * 100 Result is : " + result);
		Assert.assertEquals(result, "500");
	}

	@Test(priority=4)
	public void divTest() {

		driver.findElement(AppiumBy.id("com.coloros.calculator:id/digit_5")).click();
		driver.findElement(AppiumBy.id("com.coloros.calculator:id/digit_0")).click();
		driver.findElement(AppiumBy.accessibilityId("Divide")).click();
		driver.findElement(AppiumBy.id("com.coloros.calculator:id/digit_2")).click();

		driver.findElement(AppiumBy.accessibilityId("Equals")).click();
		String result = driver.findElement(AppiumBy.id("com.coloros.calculator:id/result")).getText();
		System.out.println("50 / 2 Result is : " + result);
		Assert.assertEquals(result, "25");
	}
	
	@AfterClass
	public void teardown() {
		
		driver.quit();
	}

}
