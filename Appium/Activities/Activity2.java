package activities;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity2 {

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

		driver.get("https://v1.training-support.net/");

	}

	@Test
	public void headingTest() {

		String pageHeading = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Training Support\"]"))
				.getText();

		// Print to console

		System.out.println("Heading: " + pageHeading);
		
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"About Us\"]")).click();
		
		String secondPageHeading = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"About Us\"]")).getText();
		System.out.println("Second Page Heading: "+secondPageHeading);
		
		Assert.assertEquals(secondPageHeading, "About Us");
		
		}
	
	@AfterClass
	public void teardown() {
		
		driver.quit();
	}

}
