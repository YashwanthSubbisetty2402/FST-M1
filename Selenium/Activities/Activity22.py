# Import webdriver from selenium
from selenium import webdriver
from selenium.webdriver.common.by import By
from webdriver_manager.firefox import GeckoDriverManager

# Start the Driver
with webdriver.Firefox() as driver:

   # Initialize the wait object
    wait = WebDriverWait(driver, 10)

    # Navigate to the URL
    driver.get("https://v1.training-support.net/selenium/popups")
    # Print the title of the page
    print("Page title is: ", driver.title)

    # Find the "Sign In" button
    signin_button = driver.find_element(By.CLASS_NAME, "orange")
    # Move the cursor over the button to show tooltip
    ActionChains(driver).move_to_element(signin_button).perform()
    # Print the tooltip text
    tooltip_text = signin_button.get_attribute("data-tooltip")
    print("Button tooltip text: ", tooltip_text)
    # Click the button
    signin_button.click()

    # Find the username and password fields
    username = driver.find_element(By.ID, "username")
    password = driver.find_element(By.ID, "password")
    # Enter credentials
    username.send_keys("admin")
    password.send_keys("password")
    # Click login
    driver.find_element(By.XPATH, "/html/body/div[4]/div/div[2]/div/div/button").click()

    # Print the confirmation message
    message = driver.find_element(By.ID, "action-confirmation")
    print("Confirmation message: ", message.text)