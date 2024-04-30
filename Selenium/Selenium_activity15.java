import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.List;


public class Selenium_activity15 {
    public static void main(String[] args) throws InterruptedException {
        // Setup the Firefox driver(GeckoDriver)
        WebDriverManager.firefoxdriver().setup();

        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();

        // Open the browser
        driver.get("https://v1.training-support.net/selenium/dynamic-attributes");

        // getting title and printing
        String ptitle = driver.getTitle();
        System.out.println(ptitle);

        //Find username and input admin
        WebElement emailInput = driver.findElement(By.xpath("//*[@id=\"dynamic-attributes-form\"]/div/div[1]/input"));
        String email="admin";
        emailInput.sendKeys(email);

        //Find password and input password
        WebElement passwordInput = driver.findElement(By.xpath("//*[@id=\"dynamic-attributes-form\"]/div/div[2]/input"));
        String password="password";
        passwordInput.sendKeys(password);

        //login to it after inputting
        WebElement btn = driver.findElement(By.xpath("//*[@id=\"dynamic-attributes-form\"]/div/button"));
        btn.click();
        // Printing the message
        WebElement msg = driver.findElement(By.xpath("//*[@id=\"action-confirmation\"]"));
        System.out.println(msg.getText());

        driver.quit();
    }

}