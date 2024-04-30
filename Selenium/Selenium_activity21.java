import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class Selenium_activity21 {
    public static void main(String[] args) throws InterruptedException {
        // Setup the Firefox driver(GeckoDriver)
        WebDriverManager.firefoxdriver().setup();

        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();

        // Open the browser
        driver.get("https://v1.training-support.net/selenium/tab-opener");

        // getting title and printing
        String ptitle = driver.getTitle();
        System.out.println(ptitle);

        WebElement btn = driver.findElement(By.xpath("//*[@id=\"launcher\"]"));
        btn.click();

        String id = driver.getWindowHandle();
        System.out.println(id);
        

        //driver.quit();
    }

}