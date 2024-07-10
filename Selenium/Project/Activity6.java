package com.example.fst_testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity6 {

	WebDriver driver;

	@BeforeClass
	public void beforeMethod() {

		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.get("https://alchemy.hguy.co/lms");
	}

	@Test
	public void TestCase6() {

		WebElement myaccount = driver.findElement(By.xpath("//a[contains(text(),'My Account')]"));
		myaccount.click();
		WebElement at = driver.findElement(By.xpath("//h1"));
		String pageTitle = at.getText();
		System.out.println("Page title is : " + pageTitle);
		Assert.assertEquals(pageTitle, "My Account");

		WebElement login = driver.findElement(By.xpath("//a[@href='#login']"));
		login.click();

		WebElement text = driver.findElement(By.xpath("//label[contains(text(),'Username or Email Address')]"));
		String text1 = text.getText();
		System.out.println("Page contains : " + text1);
		Assert.assertEquals(text1, "Username or Email Address,User is on the Login page");
	
	}

	@AfterClass
	public void afterMethod() {
		driver.quit();
	}

}
