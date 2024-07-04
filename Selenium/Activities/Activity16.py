# Import webdriver from selenium
from selenium import webdriver
from selenium.webdriver.common.by import By
from webdriver_manager.firefox import GeckoDriverManager

# Start the Driver
with webdriver.Firefox() as driver:
     # Navigate to the URL
    driver.get("https://v1.training-support.net/selenium/dynamic-attributes")
    # Print the title of the page
    print("Page title is: ", driver.title)

    # Find the username field
    username = driver.find_element(By.XPATH, "//input[contains(@class, '-username')]")
    # Find the password field
    password = driver.find_element(By.XPATH, "//input[contains(@class, '-password')]")
    # Find the confirm password field
    confirm_password = driver.find_element(By.XPATH, "//label[contains(text(), 'Confirm Password')]//following::input")
    # Alternatively, following-sibling can also be used
    # confirm_password = driver.find_element_by_xpath("//label[text()='Confirm Password')]/following-sibling::input")
    # Find the email field
    email = driver.find_element(By.XPATH, "//input[contains(@class, 'email-')]")

    # Enter the credentials
    username.send_keys("Deku")
    password.send_keys("PlusUltra!")
    confirm_password.send_keys("PlusUltra!")
    email.send_keys("deku@ua.edu")
    # Find the Sign Up button and click it
    driver.find_element(By.XPATH, "//button[text()='Sign Up']").click()

    # Wait for the login message to appear
    wait.until(EC.visibility_of_element_located((By.ID, "action-confirmation")))
    # Print the success message
    message = driver.find_element(By.ID, "action-confirmation").text
    print("Success message: ", message)