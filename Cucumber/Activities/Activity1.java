package stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Activity1 {
	WebDriver driver;
	WebDriverWait wait;

	@Given("^User is on Google Home Page$") // With this ^$ Step definition will exact match with corresponding feature
											// line
	public void userIsOnGooglePage() throws Throwable {
		// Create a new instance of the Firefox1 driver
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Open the browser
		driver.get("https://www.google.com");
	}

	@When("^User types in Cheese and hits ENTER$")
	public void userTypesInCheeseAndHitsENTER() throws Throwable {
		driver.findElement(By.name("q")).sendKeys("Cheese", Keys.RETURN);
	}

	@Then("^Show how many search results were shown$")
	public void showHowManySearchResultsWereShown() throws Throwable {
		//wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("result-stats")));
		//String resultStats = driver.findElement(By.id("result-stats")).getText();
		System.out.println("Number of results found: " );

	}

	@And("^Close the browser$")
	public void closeTheBrowser() throws Throwable {
		driver.close();
	}
}