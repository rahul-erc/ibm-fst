import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity3 {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        // Open the browser
        driver.get("http://alchemy.hguy.co/crm");
        WebElement copyright= driver.findElement(By.xpath("//*[@id=\"admin_options\"]"));
        String text=copyright.getText();
        System.out.println(text);
        // Close the browser
        driver.quit();
    }
}