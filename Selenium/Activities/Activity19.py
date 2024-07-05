# Import webdriver from selenium
from selenium import webdriver
from selenium.webdriver.common.by import By
from webdriver_manager.firefox import GeckoDriverManager

# Start the Driver
with webdriver.Firefox() as driver:
    # Navigate to the URL
    driver.get("https://v1.training-support.net/selenium/javascript-alerts")
    # Print the title of the page
    print("Page title is: ", driver.title)

    # Find the confirm button and click it
    driver.find_element(By.ID, "confirm").click()
    # Switch focus to the alert
    confirm_alert = driver.switch_to.alert
    # Print the text in the alert
    print(confirm_alert.text)
    # Close the alert with either one of the methods
    # with OK
    confirm_alert.accept()
    # with Cancel
    # confirm_alert.dismiss()