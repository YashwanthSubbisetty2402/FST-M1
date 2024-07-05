# Import webdriver from selenium
from selenium import webdriver
from selenium.webdriver.common.by import By
from webdriver_manager.firefox import GeckoDriverManager

# Start the Driver
with webdriver.Firefox() as driver:

    # Navigate to the URL
    driver.get("https://v1.training-support.net/selenium/input-events")

    # Print the title of the page
    print("Page title is: ", driver.title)

    # Declare actions variable
    actions = ActionChains(driver)

    # Then Perform the action in separate lines using the actions object
    actions.send_keys("A") # Press the key of your first names initial
    actions.key_down(Keys.CONTROL) # Press and hold the CONTROL key
    actions.send_keys("a") # Press "a"
    actions.send_keys("c") # Press "c"
    actions.key_up(Keys.CONTROL) # Relase the CONTROL key
    actions.perform() # Perform the action chain

    # Perform all action in line is done using ActionChains directly
    # actions.send_keys("A").key_down(Keys.CONTROL).send_keys("a").send_keys("c").key_up(Keys.CONTROL).perform()