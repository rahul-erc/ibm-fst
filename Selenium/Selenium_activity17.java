import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;


public class Selenium_activity17 {
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
        WebElement option = driver.findElement(By.xpath("//*[@id=\"single-select\"]"));

        Select select = new Select(option);
        //Select the second option using visible text
        select.selectByVisibleText("Option 2");
        //select the 3rd option by using index
        select.selectByIndex(3);
        //select the 4th option using value
        select.selectByValue("4");

        List<WebElement> optionList = select.getOptions();

        for(WebElement optt:optionList){
            System.out.println(optt.getText());
        }

        driver.quit();
    }

}