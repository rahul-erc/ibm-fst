import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNG_activity9 {
    // Declare the WebDriver object
    WebDriver driver;

    @BeforeTest
    public void beforeClass() {
        // Set up the Firefox driver
        WebDriverManager.firefoxdriver().setup();
        //Create a new instance of the Firefox driver
        driver = new FirefoxDriver();

        //Open browser
        driver.get("https://v1.training-support.net/selenium/javascript-alerts");
    }

    @BeforeMethod
    public void beforeMethod(){
        driver.switchTo().defaultContent();
    }
    @Test
    public void simpleAlertTestCase() {
               WebElement alert1 = driver.findElement(By.xpath("//*[@id=\"simple\"]"));
                alert1.click();
        Alert alert = driver.switchTo().alert();

        //Store the alert in a variable for reuse
        String text = alert.getText();
        System.out.println(text);
        alert.accept();
    }
    @Test
    public void confirmAlertTestCase() {
        WebElement alert2 = driver.findElement(By.xpath("//*[@id=\"confirm\"]"));
        alert2.click();
        Alert alert = driver.switchTo().alert();

        //Store the alert in a variable for reuse
        String text1 = alert.getText();
        System.out.println(text1);
        alert.accept();
    }

    @Test
    public void promptAlertTestCase() {
        WebElement alert3 = driver.findElement(By.xpath("//*[@id=\"prompt\"]"));
        alert3.click();
        Alert alert = driver.switchTo().alert();

        //Store the alert in a variable for reuse
        String text3 = alert.getText();
        System.out.println(text3);

        alert.sendKeys("AWESOME");
        Reporter.log("This is the me saying the output");
        alert.accept();
    }

    @AfterClass
    public void afterMethod() {
        //Close the browser
        driver.close();
    }
}
