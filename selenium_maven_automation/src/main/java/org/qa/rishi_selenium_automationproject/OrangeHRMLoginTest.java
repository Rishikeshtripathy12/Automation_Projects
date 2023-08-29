package org.qa.rishi_selenium_automationproject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrangeHRMLoginTest {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.edge.driver", "C:\\Users\\L054856\\edgedriver_win64\\msedgedriver.exe");
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        testLogin(driver);
        testInvalidLogin(driver);
        testForgotPassword(driver);
        testLogout(driver);
        testHomePageLoad(driver);
        driver.quit();
    }
    public static void testLogin(WebDriver driver) throws InterruptedException {
        driver.get("https://opensource-demo.orangehrmlive.com/");
        Thread.sleep(3000);
        WebElement usernameField = driver.findElement(By.name("username"));
        WebElement passwordField = driver.findElement(By.name("password"));
        WebElement loginButton = driver.findElement(By.className("orangehrm-login-button"));
        usernameField.sendKeys("admin");
        passwordField.sendKeys("admin123");
        loginButton.click();
                if (driver.getCurrentUrl().contains("dashboard")) {
                    System.out.println("Login successful");
                } else {
                    System.out.println("Login failed");
                }
            }
    public static void testInvalidLogin(WebDriver driver) throws InterruptedException {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/logout");
        Thread.sleep(3000);
        WebElement usernameField = driver.findElement(By.name("username"));
        WebElement passwordField = driver.findElement(By.name("password"));
        WebElement loginButton = driver.findElement(By.className("orangehrm-login-button"));
        usernameField.sendKeys("admin");
        passwordField.sendKeys("wrongpassword"); // Using an incorrect password
        loginButton.click(); 
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        // Wait until the error message element is visible
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("oxd-alert-content-text")));
                if (errorMessage.isDisplayed()) {
                    System.out.println("Invalid login test passed");
                } else {
                    System.out.println("Invalid login test failed");
                }
            }
    public static void testForgotPassword(WebDriver driver) {

        // Add test scenario code for password reset here

    }

    

    public static void testLogout(WebDriver driver) {

        // Add test scenario code for logout here

    }

    

    public static void testHomePageLoad(WebDriver driver) {

        // Add test scenario code for checking home page load here

    }
}


