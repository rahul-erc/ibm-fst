import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNG_activity3 {
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

    @Test
    public void exampleTestCase() {
        // Check the title of the page
        String title = driver.getTitle();

        //Print the title of the page
        System.out.println("Page title is: " + title);

        //Assertion for page title
        Assert.assertEquals("Login Form", title);
    }

    @Test
    public void exampleTestCase1() {
        // Check the title of the page
       WebElement uname = driver.findElement(By.id("username"));
       WebElement password = driver.findElement(By.id("password"));
       Assert.assertTrue(uname.isEnabled());
       Assert.assertTrue(password.isEnabled());

       uname.sendKeys("admin");
       password.sendKeys("password");

       WebElement btn = driver.findElement(By.xpath("//*[@id=\"dynamic-attributes-form\"]/div/button"));
       btn.click();

    }

    @Test
    public void exampleTestCase2() {
        // Check the title of the page
        WebElement msg = driver.findElement(By.xpath("//*[@id=\"action-confirmation\"]"));
        Assert.assertEquals(msg.getText(),"Welcome Back, admin");

    }



    @AfterClass
    public void afterMethod() {
        //Close the browser
        driver.quit();
    }
}
