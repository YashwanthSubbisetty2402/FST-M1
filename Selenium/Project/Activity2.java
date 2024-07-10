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


public class A2 {
   
    WebDriver driver;
    
    @BeforeClass
    public void beforeMethod() {
  
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();      
        driver.get("https://alchemy.hguy.co/lms");
    }

    @Test
    public void TestCase2() {
    	
    	 WebElement heading = driver.findElement(By.xpath("//h1"));
         String headingText = heading.getText();
         Assert.assertEquals(headingText, "Learn from Industry Experts");
     }         
       
    

    @AfterClass
    public void afterMethod() {
        driver.quit();
    }

}
