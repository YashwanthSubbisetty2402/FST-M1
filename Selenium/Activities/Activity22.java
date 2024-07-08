package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity22 {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.get("https://v1.training-support.net/selenium/popups");
		System.out.println("The Title of the page is  : " + driver.getTitle());

		WebElement button = driver.findElement(By.className("orange"));
		Actions act = new Actions(driver);

		act.moveToElement(button);
		String toolTipTxt = button.getAttribute("data-tooltip");
		System.out.println("The tool tip txt is " + toolTipTxt);

		button.click();
		WebElement username = driver.findElement(By.id("username"));
		WebElement password = driver.findElement(By.id("password"));

		username.sendKeys("admin");
		password.sendKeys("password");

		driver.findElement(By.xpath("//button[text()='Log in']")).click();

		String message = driver.findElement(By.id("action-confirmation")).getText();
		System.out.println("Login message: " + message);

		driver.quit();
	}

}
