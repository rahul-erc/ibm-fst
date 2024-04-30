import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class Selenium_activity9 {
    public static void main(String[] args) {
        // Setup the Firefox driver(GeckoDriver)
        WebDriverManager.firefoxdriver().setup();

        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();

        // Open the browser
        driver.get("https://v1.training-support.net/selenium/ajax");

        // getting title and printing
        String ptitle = driver.getTitle();
        System.out.println(ptitle);

        // find and click the change button
        WebElement btn = driver.findElement(By.xpath("//*[@id=\"ajax-content\"]/button"));
        btn.click();
        WebElement str = driver.findElement(By.xpath("//*[@id=\"ajax-content\"]/h1"));
        System.out.println(str.getText());
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(6));
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
     
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("#ajax-content h3"),"I'm late!"));
        WebElement str1 = driver.findElement(By.xpath("//*[@id=\"ajax-content\"]/h3"));
        System.out.println(str1.getText());


        driver.quit();
    }
}