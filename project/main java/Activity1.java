import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity1 {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        // Open the browser
        driver.get("http://alchemy.hguy.co/crm");
        String title=driver.getTitle();
        System.out.println(title);

        // Close the browser
        driver.quit();
    }
}