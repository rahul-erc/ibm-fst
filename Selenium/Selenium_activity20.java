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


public class Selenium_activity20 {
    public static void main(String[] args) throws InterruptedException {
        // Setup the Firefox driver(GeckoDriver)
        WebDriverManager.firefoxdriver().setup();

        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();

        // Open the browser
        driver.get("https://v1.training-support.net/selenium/javascript-alerts");

        // getting title and printing
        String ptitle = driver.getTitle();
        System.out.println(ptitle);

        //ffind button open a confirm button and click it
        WebElement conbt = driver.findElement(By.xpath("//*[@id=\"prompt\"]"));
        conbt.click();



//Store the alert in a variable
        Alert alert = driver.switchTo().alert();

//Store the alert in a variable for reuse
        String text = alert.getText();
        System.out.println(text);

        alert.sendKeys("AWESOME");

        // Pause the current thread for 2 second
        Thread.sleep(2000);
        // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //close once with ok
        alert.accept();


        driver.quit();
    }

}