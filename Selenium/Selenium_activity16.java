import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.List;


public class Selenium_activity16 {
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
        WebElement usernameInput = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div/div[3]/div/div/div[1]/input"));
        String username="RahulERC";
        usernameInput.sendKeys(username);

        //Find password and input password
        WebElement passwordInput = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div/div[3]/div/div/div[2]/input"));
        String password="password";
        passwordInput.sendKeys(password);

        //confirm password
        WebElement passwordInput1 = driver.findElement(By.xpath("//*[@id=\"dynamic-attributes-form\"]/div/div[3]/input"));
        String password1="password";
        passwordInput1.sendKeys(password1);

        //enter email
        WebElement emailInput1 = driver.findElement(By.xpath("//*[@id=\"dynamic-attributes-form\"]/div/div[4]/input"));
        String email="Rahul@gmail.com";
        emailInput1.sendKeys(email);
        //click on sign in
        WebElement btnn = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div/div[3]/div/div/button"));
        btnn.click();
        // Printing the message
        WebElement msg = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[1]"));
        System.out.println(msg.getText());
        driver.quit();
    }

}