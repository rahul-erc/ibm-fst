import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.interactions.Actions;

import java.io.FileWriter;
import java.io.IOException;


public class Selenium_activity6 {
    public static void main(String[] args) throws InterruptedException {
        // Setup the Firefox driver(GeckoDriver)
        WebDriverManager.firefoxdriver().setup();

        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();

        // Open the browser
        driver.get("https://v1.training-support.net/selenium/input-events");

        // getting title and printing
        String ptitle = driver.getTitle();
        System.out.println(ptitle);

        //Press key of first letter of our name in caps
        new Actions(driver)
                .keyDown(Keys.SHIFT)
                .sendKeys("R")
                .keyUp(Keys.SHIFT)
                .perform();

        // press CTRL+a and CTRL+c to copy all the text on the page an paste in a txt document
        // Find all the text on the webpage
        WebElement body = driver.findElement(By.tagName("body"));
        String allText = body.getText();



        WebElement element = driver.findElement(By.tagName("body"));

        // Use Actions class to perform key combinations
        Actions actions = new Actions(driver);

        // Select all text (CTRL + A)
        actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();

        // Copy selected text (CTRL + C)
        actions.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).perform();

       driver.quit();
    }
}