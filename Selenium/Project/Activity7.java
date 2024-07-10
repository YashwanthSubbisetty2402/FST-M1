package com.example.fst_testng;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class A7 {

	WebDriver driver;

	@BeforeClass
	public void beforeMethod() {

		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.get("https://alchemy.hguy.co/lms");
	}

	@Test
	public void TestCase7() {

		WebElement cou = driver.findElement(By.id("primary-menu"));
        WebElement allCoursesMenuItem = cou.findElement(By.linkText("All Courses"));
        allCoursesMenuItem.click();
        List<WebElement> courses = driver.findElements(By.className("entry-title"));
        for (WebElement course : courses) {
            System.out.println(course.getText());
        }
        Assert.assertTrue(courses.size() > 0, "No courses found on the page.");
    }
	
	

	@AfterClass
	public void afterMethod() {
		driver.quit();
	}

}
