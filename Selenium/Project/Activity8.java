package com.example.fst_testng;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class A8 {

	WebDriver driver;

	@BeforeClass
	public void beforeMethod() {

		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.get("https://alchemy.hguy.co/lms");
	}

	@Test
	public void TestCase8() {

		WebElement contact = driver.findElement(By.xpath("//a[contains(text(),'Contact')]"));
		contact.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");

		WebElement firstName = driver.findElement(By.xpath("//input[@id='wpforms-8-field_0']"));
		firstName.sendKeys("Ranjitha");

		WebElement email = driver.findElement(By.xpath("//input[@id='wpforms-8-field_1']"));
		email.sendKeys("xyz@abc.com");

		WebElement subject = driver.findElement(By.xpath("//input[@id='wpforms-8-field_3']"));
		subject.sendKeys("Selenium Java using Junit");

		WebElement comment = driver.findElement(By.xpath("//textarea[@id='wpforms-8-field_2']"));
		comment.sendKeys("Testing Junit");

		WebElement sendbutton = driver.findElement(By.xpath("//button[contains(text(),'Send Message')]"));
		sendbutton.click();

		WebElement text = driver.findElement(By
				.xpath("//div/p[contains(text(),'Thanks for contacting us! We will be in touch with you shortly.')]"));
		String text1 = text.getText();
		System.out.println("Page contains : " + text1);
		Assert.assertEquals(text1, "Thanks for contacting us! We will be in touch with you shortly.");
		System.out.println("Message was sent successfully");
	}

	@AfterClass
	public void afterMethod() {
		driver.quit();
	}

}
