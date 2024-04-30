import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;


public class Selenium_activity8 {
    public static void main(String[] args) throws InterruptedException {
        // Setup the Firefox driver(GeckoDriver)
        WebDriverManager.firefoxdriver().setup();

        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();

        // Open the browser
        driver.get("https://v1.training-support.net/selenium/dynamic-controls");

        // getting title and printing
        String ptitle = driver.getTitle();
        System.out.println(ptitle);

        //find checkbox toggle and click it
         WebElement toggle = driver.findElement(By.xpath("//*[@id=\"toggleCheckbox\"]"));
         toggle.click();

         //Thread.sleep(3000);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
         toggle.click();



        driver.quit();
    }
}