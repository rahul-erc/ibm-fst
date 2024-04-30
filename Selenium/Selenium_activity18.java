import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;


public class Selenium_activity18 {
    public static void main(String[] args) throws InterruptedException {
        // Setup the Firefox driver(GeckoDriver)
        WebDriverManager.firefoxdriver().setup();

        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();

        // Open the browser
        driver.get("https://v1.training-support.net/selenium/selects");

        // getting title and printing
        String ptitle = driver.getTitle();
        System.out.println(ptitle);

        //Selwct the second option
        WebElement option = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[2]/div/div/div/div[2]/select"));

        Select select = new Select(option);
        //Select the javascript option using visible text
        select.selectByVisibleText("Javascript");
        //select the 4,5,6 option by using index
        select.selectByIndex(4);
        select.selectByIndex(5);
        select.selectByIndex(6);
        //select the node js option using value
        select.selectByValue("node");
        //descelect 5th option
        select.deselectByIndex(5);


        driver.quit();
    }

}