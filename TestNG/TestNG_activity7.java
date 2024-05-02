import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNG_activity7 {
    // Declare the WebDriver object
    WebDriver driver;

    @BeforeClass
    public void beforeMethod() {
        // Set up the Firefox driver
        WebDriverManager.firefoxdriver().setup();
        //Create a new instance of the Firefox driver
        driver = new FirefoxDriver();

        //Open browser
        driver.get("https://v1.training-support.net/selenium/login-form");
    }

    @DataProvider(name = "Authentication")
    public static Object[][] credentials() {
        return new Object[][] {
                { "admin", "password" },
                { "admin2", "password" }
        };
    }

    @Test(dataProvider = "Authentication")
    public void test(String sUsername, String sPassword) {
        //Statements that use sUsername and sPassword.
        WebElement uname = driver.findElement(By.xpath("//*[@id=\"username\"]"));
        WebElement pass = driver.findElement(By.xpath("//*[@id=\"password\"]"));
        Assert.assertTrue(uname.isEnabled());
        Assert.assertTrue(pass.isEnabled());

        uname.sendKeys(sUsername);
        pass.sendKeys(sPassword);
        WebElement btn = driver.findElement(By.xpath("//*[@id=\"dynamic-attributes-form\"]/div/button"));
        btn.click();
        uname.clear();
        pass.clear();

    }

    @AfterClass
    public void afterMethod() {
        //Close the browser
        driver.quit();
    }
}
