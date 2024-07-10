package Project_Activity;

import org.testng.annotations.Test;



import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Activity9 {
	WebDriver driver;
	
  @Test(priority = 0)
  @Parameters({"username", "password"})
  public void NavigateMyAccount(String username, String password) {
	driver.findElement(By.xpath("//li[@id='menu-item-1507']")).click();
	String PageTitle=driver.getTitle();
	System.out.println("Title of the page is:"+PageTitle);
	Assert.assertEquals("My Account – Alchemy LMS", PageTitle);
	WebElement LoginButton=driver.findElement(By.xpath("//a[@href='#login']"));
	LoginButton.click();	
	 WebElement usernameField = driver.findElement(By.id("user_login"));
	 WebElement passwordField = driver.findElement(By.id("user_pass"));
	 usernameField.sendKeys(username);
	 passwordField.sendKeys(password);
	 driver.findElement(By.cssSelector("input[type='submit']")).click();
  }
  @Test (priority = 1)
  public void fnCompleteLession() {
	  driver.findElement(By.xpath("//li[@id='menu-item-1508']")).click();
	  List<WebElement> Courses=driver.findElements(By.xpath("//p[@class='ld_course_grid_button']"));
	  Courses.get(0).click();
	  List<WebElement> Content=driver.findElements(By.xpath("//div[@class='ld-item-title']"));
	  String text=Content.get(0).getText();
	  System.out.println("Lession name is:"+text);
	  Content.get(0).click();
	  String title=driver.findElement(By.xpath("//h1")).getText();
	  System.out.println("Title of the lession is:"+title);
	  System.out.println("After clicking on a lession in the course,the tittle verification is successful:"+text.contains(title));
	  List<WebElement> topic=driver.findElements(By.xpath("//div[@class='ld-topic-title']"));
	  topic.get(2).click();
	  Boolean isPresent = driver.findElement(By.cssSelector("input[type='submit']")).isDisplayed();
	  if(isPresent){
		  driver.findElement(By.cssSelector("input[type='submit']")).click();	  
	  }	  
	  
  }
  @BeforeClass
  public void beforeClass() {
	  driver = new FirefoxDriver();
	  driver.get("https://alchemy.hguy.co/lms");	  
  }

  @AfterClass
  public void afterClass() {
	  //driver.close();
  }

}