import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;




//public class TestNG_activity8 extends TestNG_Dataprovider{
public class TestNG_activity8 {
    // Declare the WebDriver object
    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        // Set up the Firefox driver
        WebDriverManager.firefoxdriver().setup();
        //Create a new instance of the Firefox driver
        driver = new FirefoxDriver();

        //Open browser
        driver.get("https://v1.training-support.net/selenium/simple-form");
    }
//
//    @DataProvider(name = "Authentication")
//    public static Object[][] credentials() {
//        return new Object[][] {
//                { "Rahul", "chowdary","rahul@gmail.com","9900389665" },
//                { "pooja", "Gowda","pooja@gmail.com","9876567123" },
//                {"Shivu","The god","Shivu@gmail.com","9010203040"}
//        };
//    }

    @Test(dataProvider = "Authentication",dataProviderClass = TestNG_Dataprovider.class)
    public void test(String sFirstname, String sLastname,String sEmail, String sNumber) {
        //Statements that use sUsername and sPassword.
        WebElement Fname = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/form/div/div[1]/input"));
        WebElement Lname = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/form/div/div[2]/input"));
        WebElement Email = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/form/div/div[3]/input"));
        WebElement num = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/form/div/div[4]/input"));


        Assert.assertTrue(Fname.isEnabled());
        Assert.assertTrue(Lname.isEnabled());
        Assert.assertTrue(Email.isEnabled());
        Assert.assertTrue(num.isEnabled());


        Fname.sendKeys(sFirstname);
        Lname.sendKeys(sLastname);
        Email.sendKeys(sEmail);
        num.sendKeys(sNumber);

        WebElement btn = driver.findElement(By.xpath("//*[@id=\"simpleForm\"]/div/div[6]/div[1]/input"));
        btn.click();

        Alert alert = driver.switchTo().alert();
        alert.accept();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    }

    @AfterMethod
    public void afterMethod() {
        //Close the browser
        driver.quit();
    }
}
