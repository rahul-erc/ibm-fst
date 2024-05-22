import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity5 {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Open the browser
        driver.get("http://alchemy.hguy.co/crm");
        WebElement Uname= driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/form[1]/div[2]/input"));
        WebElement passw= driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/form[1]/div[3]/input"));

        //enter credentials to the fields
        Uname.sendKeys("admin");
        passw.sendKeys("pa$$w0rd");

        //click login button
        WebElement btn= driver.findElement(By.xpath("//*[@id=\"bigbutton\"]"));
        btn.click();

        wait.until(ExpectedConditions.urlContains("index.php?module=Home&action=index"));

        WebElement nav = driver.findElement(By.className("navbar-inverse"));
        String color = nav.getCssValue("background");
        System.out.println("the colour is"+color);
        // Close the browser
        driver.quit();
    }
}