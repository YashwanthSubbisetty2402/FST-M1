package appiumproject;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
				.setAutomationName("UiAutomator2").
				setAppPackage("com.google.android.keep").
				setAppActivity("com.google.android.apps.keep.ui.activities.BrowseActivity").
				noReset();
		
		
		//Set the Appium server URL
		URL serverURL = new URI("http://localhost:4723").toURL();
		
		//Initializing driver
		driver = new AndroidDriver(serverURL,caps);
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		
	}
	
	
	@Test
	public void googleKeepTest() {
		
		driver.findElement(AppiumBy.accessibilityId("New text note")).click();
		wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.google.android.keep:id/editable_title")));
		driver.findElement(AppiumBy.id("com.google.android.keep:id/editable_title")).sendKeys("Pavan");
		driver.findElement(AppiumBy.id("com.google.android.keep:id/edit_note_text")).sendKeys("Pavan Kumar Chowdary");
		driver.findElement(AppiumBy.accessibilityId("Navigate up")).click();
		
		
		
	}
	
	
	
	
	@AfterClass
	public void teardown() {
		driver.quit();
	}


}
