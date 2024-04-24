import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;



public class Selenium_activity1 {
    public static void main(String[] args) {
        // Setup the Firefox driver(GeckoDriver)
        WebDriverManager.firefoxdriver().setup();

        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();

        // Open the browser
        driver.get("https://v1.training-support.net");

        // getting title and printing
        String ptitle = driver.getTitle();
        System.out.println(ptitle);
        //find about us button using its id
        WebElement button = driver.findElement(By.id("about-link"));
       //printing about us
        String bt=button.getText();
        System.out.println(bt);
        //using function to click the button
        button.click();

        //printing the new page title
        String ntitle = driver.getTitle();
        System.out.println(ntitle);
        driver.quit();
    }
}