import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity4 {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

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

        //next page verification
        String nurl = driver.getCurrentUrl();
        System.out.println("new url to verify:"+nurl);

        // Close the browser
        driver.quit();
    }
}