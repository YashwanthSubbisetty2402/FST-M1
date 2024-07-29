package appiumproject;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import activities.ActionsBase;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity5 {
	
	AppiumDriver driver;
	WebDriverWait wait;

	@BeforeMethod
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

		driver.get("https://v1.training-support.net/selenium");

	}
	
	@Test(priority=1)
	public void loginSuccessTest() {

		// Get width and height of the screen
		Dimension dims = driver.manage().window().getSize();
		System.out.println("My Phone dimensions are : " + dims);

		Point start = new Point((int) (dims.getWidth() * 0.5), (int) (dims.getHeight() * 0.85));
		Point end = new Point((int) (dims.getWidth() * 0.5), (int) (dims.getHeight() * 0.40));
		wait.until(ExpectedConditions
				.elementToBeClickable(AppiumBy.xpath("//android.widget.Button[@text=\"Get Started!\"]")));

		// Scroll(Fling) to the end of the page
		ActionsBase.doSwipe(driver, start, end, 10);
		// wait for to-do-list link and click it
		wait.until(ExpectedConditions
				.elementToBeClickable(AppiumBy.xpath("//android.widget.TextView[@text=\"Login Form\"]"))).click();
		
		wait.until(ExpectedConditions
				.elementToBeClickable(AppiumBy.xpath("//android.webkit.WebView[@text=\"Login Form\"]/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[1]")))
		.sendKeys("admin");
		driver.findElement(AppiumBy.xpath("//android.webkit.WebView[@text=\"Login Form\"]/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[2]")).sendKeys("password");
		driver.findElement(AppiumBy.xpath("//android.widget.Button[@text=\"Log in\"]")).click();
		WebElement credentials = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Welcome Back, admin\"]"));
		String mgs =credentials.getText();
		
		Assert.assertEquals(mgs, "Welcome Back, admin");
	
		
	}
	
	@Test(priority=2)
	public void loginUnsuccessTest() {

		// Get width and height of the screen
		Dimension dims = driver.manage().window().getSize();
		System.out.println("My Phone dimensions are : " + dims);

		Point start = new Point((int) (dims.getWidth() * 0.5), (int) (dims.getHeight() * 0.85));
		Point end = new Point((int) (dims.getWidth() * 0.5), (int) (dims.getHeight() * 0.40));
		wait.until(ExpectedConditions
				.elementToBeClickable(AppiumBy.xpath("//android.widget.Button[@text=\"Get Started!\"]")));

		// Scroll(Fling) to the end of the page
		ActionsBase.doSwipe(driver, start, end, 10);
		// wait for to-do-list link and click it
		wait.until(ExpectedConditions
				.elementToBeClickable(AppiumBy.xpath("//android.widget.TextView[@text=\"Login Form\"]"))).click();
		
		wait.until(ExpectedConditions
				.elementToBeClickable(AppiumBy.xpath("//android.webkit.WebView[@text=\"Login Form\"]/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[1]")))
		.sendKeys("Admin");
		driver.findElement(AppiumBy.xpath("//android.webkit.WebView[@text=\"Login Form\"]/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[2]")).sendKeys("password");
		driver.findElement(AppiumBy.xpath("//android.widget.Button[@text=\"Log in\"]")).click();
		WebElement credentials = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Invalid Credentials\"]"));
		String mgs =credentials.getText();
		
		Assert.assertEquals(mgs, "Invalid Credentials");
		
		
	}
	
	@AfterMethod
	public void teardown() {
		
		driver.quit();
		
	}




}
