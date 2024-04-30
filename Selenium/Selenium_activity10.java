import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.List;


public class Selenium_activity10 {
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
        List<WebElement> checkbox = driver.findElements(By.id("dynamicCheckbox"));
        System.out.println(checkbox.size());

        boolean check = driver.findElement(By.id("dynamicCheckbox")).isDisplayed();
        System.out.println(check);

        WebElement toggle = driver.findElement(By.id("toggleCheckbox"));
        toggle.click();
        boolean check1 = driver.findElement(By.id("dynamicCheckbox")).isDisplayed();
        System.out.println(check1);






        driver.quit();
    }
}