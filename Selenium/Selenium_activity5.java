import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.interactions.Actions;


public class Selenium_activity5 {
    public static void main(String[] args) {
        // Setup the Firefox driver(GeckoDriver)
        WebDriverManager.firefoxdriver().setup();

        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();

        // Open the browser
        driver.get("https://v1.training-support.net/selenium/input-events");

        //Print page title
        String ptitle = driver.getTitle();
        System.out.println(ptitle);

        //on the page ,left click and print the value
        WebElement clickable = driver.findElement(By.id("wrapD3Cube"));
        new Actions(driver)
                .click(clickable)
                .perform();


        WebElement box = driver.findElement(By.className("active"));
        String side =box.getText();
        System.out.println("LEFT click value:"+side);


        //ON the page ,double click
        WebElement clickable1 = driver.findElement(By.id("wrapD3Cube"));
        new Actions(driver)
                .doubleClick(clickable1)
                .perform();


        WebElement box1 = driver.findElement(By.className("active"));
        String side1 =box1.getText();
        System.out.println("double click value:"+side1);

        WebElement clickable2 = driver.findElement(By.id("wrapD3Cube"));
        new Actions(driver)
                .contextClick(clickable2)
                .perform();


        WebElement box2 = driver.findElement(By.className("active"));
        String side2 =box2.getText();
        System.out.println("LEFT click value:"+side2);

        //driver.quit();
    }
}