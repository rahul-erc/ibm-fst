import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;



public class Selenium_activity2 {
    public static void main(String[] args) {
        // Setup the Firefox driver(GeckoDriver)
        WebDriverManager.firefoxdriver().setup();

        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();

        // Open the browser
        driver.get("https://v1.training-support.net/selenium/login-form");

        //printing title of the page
        String ptitle = driver.getTitle();
        System.out.println(ptitle);
        //Finding username field using any locater and inputting admin to field
        WebElement Uname = driver.findElement(By.id("username"));
        Uname.clear();
        String username = "ADMIN";
        Uname.sendKeys(username);

        //Finding password field using any locater and inputting password to field
        WebElement pname = driver.findElement(By.id("password"));
        pname.clear();
        String passw = "PASSWORD";
        pname.sendKeys(passw);


        //Finding login field using any locater and click it
        WebElement logg = driver.findElement(By.cssSelector("button.ui.button[type=submit]"));

        String bt=logg.getText();
        System.out.println(bt);

        logg.click();


        driver.quit();
    }
}