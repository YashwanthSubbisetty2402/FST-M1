package activities;

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

public class Activity4 {
	
	AppiumDriver driver;
	WebDriverWait wait;

	@BeforeClass
	public void setup() throws MalformedURLException, URISyntaxException {

		// Desired Capabilities
		UiAutomator2Options caps = new UiAutomator2Options().setPlatformName("andriod")
				.setAutomationName("UiAutomator2").setAppPackage("com.google.android.contacts")
				.setAppActivity("com.android.contacts.activities.PeopleActivity").noReset();

		// Set the Appium server URL
		URL serverURL = new URI("http://localhost:4723").toURL();

		// Initializing driver
		driver = new AndroidDriver(serverURL, caps);
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));


	}
	
	@Test
	public void addNewContactTest() {
		
		driver.findElement(AppiumBy.accessibilityId("Create contact")).click();
		driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text=\"First name\"]")).sendKeys("Pavan");
		driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text=\"Surname\"]")).sendKeys("Chunchu");
		
		// Get width and height of the screen
		Dimension dims = driver.manage().window().getSize();
		System.out.println("My Phone dimensions are : " + dims);

		Point start = new Point((int) (dims.getWidth() * 0.5), (int) (dims.getHeight() * 0.85));
		Point end = new Point((int) (dims.getWidth() * 0.5), (int) (dims.getHeight() * 0.6));
		
		// Scroll(Fling) to the end of the page
				ActionsBase.doSwipe(driver, start, end, 50);
		
		wait.until(ExpectedConditions
				.elementToBeClickable(AppiumBy.xpath("//android.widget.EditText[@text=\"Phone\"]")));

		
		
		
		
		driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text=\"Phone\"]")).sendKeys("8247797591");
		
		driver.findElement(AppiumBy.id("com.google.android.contacts:id/toolbar_button")).click();
	}
	
	@AfterClass
	public void teardown() {
		
		driver.quit();
	}


}
