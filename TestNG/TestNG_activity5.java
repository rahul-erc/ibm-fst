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

public class TestNG_activity5 {
    // Declare the WebDriver object
    WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void beforeMethod() {
        // Set up the Firefox driver
        WebDriverManager.firefoxdriver().setup();
        //Create a new instance of the Firefox driver
        driver = new FirefoxDriver();

        //Open browser
        driver.get("https://v1.training-support.net/selenium/target-practice");
    }

    @Test
    public void exampleTestCase() {
        // Check the title of the page
        String title = driver.getTitle();

        //Print the title of the page
        System.out.println("Page title is: " + title);

        //Assertion for page title
        Assert.assertEquals("Target Practice", title);
    }

    @Test(groups = {"HeaderTest"})
    public void exampleTestCase1() {
        // Check the title of the page
        WebElement thirdh = driver.findElement(By.xpath("//*[@id=\"third-header\"]"));
        Assert.assertEquals("Third header",thirdh.getText());
        WebElement fifth = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[2]/div/div/div/div[1]/h5"));
        Assert.assertEquals("rgb(33, 186, 69)",fifth.getCssValue("color"));
    }

    @Test(groups = {"Buttontest"})
    public void exampleTestCase2() {
        // Check the title of the page
        WebElement btn = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[2]/div/div/div/div[2]/div[1]/button[4]"));
        Assert.assertEquals("Olive",btn.getText());

        WebElement btn1 = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[2]/div/div/div/div[2]/div[3]/button[1]"));
        Assert.assertEquals("rgb(255, 255, 255)",btn1.getCssValue("color"));

    }



    @AfterClass
    public void afterMethod() {
        //Close the browser
        driver.quit();
    }
}
