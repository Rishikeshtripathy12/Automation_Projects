package org.qa.rishi_selenium_automationproject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EcommerceLoginTest {



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
        driver.get("https://ecommerce-playground.lambdatest.io/index.php");
        Thread.sleep(8000);
        Actions builder = new Actions(driver);
        WebElement element = driver.findElement(By.xpath("//a[@data-toggle='dropdown']//span[contains(., 'My account')]"));
        builder.moveToElement(element).click().perform();
        Thread.sleep(8000);
        WebElement usernameField = driver.findElement(By.id("input-email"));
        WebElement passwordField = driver.findElement(By.id("input-password"));
        WebElement loginButton = driver.findElement(By.xpath("//input[@value=\"Login\"]"));
        usernameField.sendKeys("rishikesh4999@gmail.com");
        passwordField.sendKeys("Pass123$");
        loginButton.click();
                if (driver.getCurrentUrl().contains("account")) {
                    System.out.println("Login successful");
                } else {
                    System.out.println("Login failed");
                }
            }
    public static void testInvalidLogin(WebDriver driver) throws InterruptedException {
        //driver.get("https://ecommerce-playground.lambdatest.io/index.php");
        Thread.sleep(8000);
        Actions builder = new Actions(driver);
        WebElement element1 = driver.findElement(By.xpath("//a[@data-toggle='dropdown']//span[contains(., 'My account')]"));
        builder.moveToElement(element1).build().perform();
        WebElement element2 = driver.findElement(By.xpath("//span[contains(., 'Logout')]"));
        builder.moveToElement(element2).click().perform();
        Thread.sleep(8000);
        WebElement element3 = driver.findElement(By.xpath("//a[@data-toggle='dropdown']//span[contains(., 'My account')]"));
        builder.moveToElement(element3).build().perform();
        WebElement element4 = driver.findElement(By.xpath("//span[contains(., 'Login')]"));
        builder.moveToElement(element4).click().perform();
        WebElement usernameField = driver.findElement(By.id("input-email"));
        WebElement passwordField = driver.findElement(By.id("input-password"));
        WebElement loginButton = driver.findElement(By.xpath("//input[@value=\"Login\"]"));
        usernameField.sendKeys("rishikesh4999@gmail.com");
        passwordField.sendKeys("Pass123$!");
        loginButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        // Wait until the error message element is visible
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#account-login > div.alert.alert-danger.alert-dismissible")));
        
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
