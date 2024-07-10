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

public class A4 {

	WebDriver driver;

	@BeforeClass
	public void beforeMethod() {

		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.get("https://alchemy.hguy.co/lms");
	}

	@Test
	public void TestCase4() {

		WebElement spct = driver.findElement(By.xpath("(//h3[@class='entry-title'])[2]"));
        String courseTitle = spct.getText();
        System.out.println("Second most popular course is : " +courseTitle);
        Assert.assertEquals(courseTitle, "Email Marketing Strategies");
	}

	@AfterClass
	public void afterMethod() {
		driver.quit();
	}

}
