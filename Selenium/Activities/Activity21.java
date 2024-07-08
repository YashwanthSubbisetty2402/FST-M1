package activities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity21 {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.get("https://v1.training-support.net/selenium/tab-opener");
		System.out.println("The Title of the page is  : " + driver.getTitle());

		String presentTab = driver.getWindowHandle();
		System.out.println("Current window: " + presentTab);

		driver.findElement(By.id("launcher")).click();

		System.out.println("Currently open windows: " + driver.getWindowHandles());

		for (String handle : driver.getWindowHandles()) {
			driver.switchTo().window(handle);
		}
		System.out.println("The Title of new page is  : " + driver.getTitle());
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("actionButton")));
		driver.findElement(By.id("actionButton")).click();
		System.out.println("Currently open windows: " + driver.getWindowHandles());

		for (String handle : driver.getWindowHandles()) {
			driver.switchTo().window(handle);
		}
		wait.until(ExpectedConditions.numberOfWindowsToBe(3));
		System.out.println("The Title of last page is  : " + driver.getTitle());
		driver.quit();

	}

}
