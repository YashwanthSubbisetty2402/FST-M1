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

public class A3 {

	WebDriver driver;

	@BeforeClass
	public void beforeMethod() {

		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.get("https://alchemy.hguy.co/lms");
	}

	@Test
	public void TestCase3() {

		WebElement at = driver.findElement(By.xpath("//h3"));
		String aText = at.getText();
		System.out.println("The text is :" +aText);
		Assert.assertEquals(aText, "Actionable Training");
	}

	@AfterClass
	public void afterMethod() {
		driver.quit();
	}

}
