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

public class FirstTest {

	AppiumDriver driver;

	@BeforeClass
	public void setup() throws MalformedURLException, URISyntaxException {

		// Desired Capabilities
		UiAutomator2Options caps = new UiAutomator2Options().setPlatformName("andriod")
				.setAutomationName("UiAutomator2").
				setAppPackage("com.coloros.calculator").
				setAppActivity("com.android.calculator2.Calculator").
				noReset();
		
		
		//Set the Appium server URL
		URL serverURL = new URI("http://localhost:4723").toURL();
		
		//Initializing driver
		driver = new AndroidDriver(serverURL,caps);
		
	}
	
	@Test
	public void additionTest() {
		
		//Find digit 6 and tap it
		driver.findElement(AppiumBy.id("com.coloros.calculator:id/digit_6")).click();
		
		//Find the plus button and tap it
		driver.findElement(AppiumBy.accessibilityId("Add")).click();
		
		
		//Find digit 9 and tap it
		driver.findElement(AppiumBy.id("com.coloros.calculator:id/digit_9")).click();
		
		
		//Find equals and tap it
		driver.findElement(AppiumBy.accessibilityId("Equals")).click();
		
		//Get the result and Assert
		String result = driver.findElement(AppiumBy.id("result")).getText();
		System.out.println("Result is: "+result);
		Assert.assertEquals(result, "15");
	}
	
	@AfterClass
	public void teardown() {
		driver.quit();
	}

}
