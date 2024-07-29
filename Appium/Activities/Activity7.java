package activities;

import static org.testng.Assert.assertTrue;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity7 {
	
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
	
	
	@Test
	public void sliderTest() {
		
	   
		
	        // Wait for page to load
		
	        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.webkit.WebView[@text=\"Sliders\"]/android.view.View/android.view.View/android.view.View")));
		
	        // Get the size of the screen
		
	        Dimension dims = driver.manage().window().getSize();
		
	        // Set the start and end points
		
	        Point start = new Point((int)(dims.getWidth() * .35), (int)(dims.getHeight() * .49));
		
	        Point end = new Point((int)(dims.getWidth() * .5), (int)(dims.getHeight() * .49));
		
	        // Perform swipe
		
	        ActionsBase. doSwipe(driver, start, end, 500);
		
	 
		
	        // Get the volume level
		
	        String volumeText = driver.findElement(AppiumBy.xpath("//android.view.View[contains(@text, 'Volume')]")).getText();
	      //android.view.View[@text="Volume Level: 0%"]
		
	 
		
	        // Assertions
		
	        assertTrue(volumeText.contains("50%"));
		
	    }
	
	@AfterClass
	public void teardown() {
		driver.quit();
		
	}
	
	
	}



