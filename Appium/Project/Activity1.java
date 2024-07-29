package appiumproject;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;

//import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity1 {
	
	AppiumDriver driver;
	WebDriverWait wait;

	@BeforeClass
	public void setup() throws MalformedURLException, URISyntaxException {

		// Desired Capabilities
		UiAutomator2Options caps = new UiAutomator2Options().setPlatformName("andriod")
				.setAutomationName("UiAutomator2").
				setAppPackage("com.google.android.apps.tasks").
				setAppActivity(".ui.TaskListsActivity").
				noReset();
		
		
		//Set the Appium server URL
		URL serverURL = new URI("http://localhost:4723").toURL();
		
		//Initializing driver
		driver = new AndroidDriver(serverURL,caps);
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		
	}
	
	@Test
	public void taskTest() {
		driver.findElement(AppiumBy.accessibilityId("Create new task")).click();
		wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.google.android.apps.tasks:id/add_task_title")));
		 driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_title")).sendKeys("Complete Activity with Google Tasks");
		 driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_done")).click();
		 
		 
		 driver.findElement(AppiumBy.accessibilityId("Create new task")).click();
		 wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.google.android.apps.tasks:id/add_task_title")));
		 driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_title")).sendKeys("Complete Activity with Google Keep");
		 driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_done")).click();
		 
		 
		 driver.findElement(AppiumBy.accessibilityId("Create new task")).click();
		 wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.google.android.apps.tasks:id/add_task_title")));
		 driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_title")).sendKeys("Complete the second Activity Google Keep");
		 driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_done")).click();
		
	/*	//add.click();
		driver.findElement(AppiumBy.accessibilityId("Create new task")).click();
		newtask.sendKeys("Complete Activity with Google Tasks");
		save.click();
		
		//add.click();
		driver.findElement(AppiumBy.accessibilityId("Create new task")).click();
		newtask.sendKeys("Complete Activity with Google Keep");
		save.click();
		
	//	add.click();
		driver.findElement(AppiumBy.accessibilityId("Create new task")).click();
		newtask.sendKeys("Complete the second Activity Google Keep");
		save.click();*/
	}
	
	@AfterClass
	public void teardown() {
		driver.quit();
	}

}
