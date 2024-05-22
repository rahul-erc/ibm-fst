import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity2 {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        // Open the browser
        driver.get("http://alchemy.hguy.co/crm");
        WebElement img= driver.findElement(By.xpath("/html/body/div[1]/div[1]/a"));
        String url=img.getAttribute("href");
        System.out.println(url);
        // Close the browser
        driver.quit();
    }
}