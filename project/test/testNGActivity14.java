import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

public class testNGActivity14 {
    WebDriver driver;

    @BeforeClass
    public void beforeMethod() {
        // Setup the Firefox driver(GeckoDriver)
        WebDriverManager.firefoxdriver().setup();

        // Create a new instance of the Firefox driver
        driver = new FirefoxDriver();

        // Open the browser
        driver.get("https://alchemy.hguy.co/crm/");

    }

    @Test
    @Parameters({ "sUsername", "sPassword" })
    public void parameterTest(String sUsername, String sPassword) {
        // Check the title of the page
        String title = driver.getTitle();

        // Print the title of the page
        System.out.println("Page title is: " + title);
        Reporter.log("Page Title Printed<br>");

        // Log in
        WebElement username= driver.findElement(By.id("user_name"));
        WebElement password=driver.findElement(By.id("username_password"));
        Assert.assertTrue(username.isEnabled());
        Assert.assertTrue(password.isEnabled());
        username.sendKeys(sUsername);
        password.sendKeys(sPassword);
        password.sendKeys(Keys.ENTER);
        Reporter.log("Logged in successfully<br>");
        //WebElement button= driver.findElement(By.id("bigbutton"));
        //button.click();
    }

    @Test
    public void testCase1() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement salesOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"grouptab_0\"]")));
        salesOption.click();

        // Click on Opportunities
        WebElement opportunitiesOption = driver.findElement(By.xpath("//*[@id=\"moduleTab_9_Opportunities\"]"));
        opportunitiesOption.click();
        Reporter.log("Navigated to Opportunities Section<br>");

        // Click on Filter icon
        WebElement filterIcon = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[4]/div/div[3]/form[2]/div[3]/table/thead/tr[2]/td/table/tbody/tr/td[1]/ul[3]/li/a")));
        filterIcon.click();
        Reporter.log("Filter Clicked<br>");

        // Click on Advanced Filter
        WebElement advancedFilter = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[4]/div/div[3]/div/div/div/div[1]/ul/li[2]")));
        advancedFilter.click();
        Reporter.log("Advance Filter Section Selected<br>");
        WebElement Clear = driver.findElement(By.xpath("//*[@id=\"search_form_clear_advanced\"]"));
        Clear.click();
        Reporter.log("Clear Initial Filters<br>");

        WebElement popUp = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"range_amount_advanced\"]")));
        popUp.click();
        new Actions(driver)
                .click(popUp)
                .sendKeys("500")
                .sendKeys(Keys.TAB)
                .perform();
        Reporter.log("Input value 500 successful<br>");

        WebElement selectUser = driver.findElement(By.name("assigned_user_id_advanced[]"));
        Select user = new Select(selectUser);
        user.selectByVisibleText("admin");
        Reporter.log("Admin selected<br>");

        WebElement selectSales = driver.findElement(By.name("sales_stage_advanced[]"));
        Select sales = new Select(selectSales);
        sales.selectByVisibleText("Prospecting");
        Reporter.log("Prospecting Selected<br>");

        WebElement submit = driver.findElement(By.xpath("//*[@id=\"search_form_submit_advanced\"]"));
        submit.click();
        Reporter.log("Search Initialized<br>");

        WebElement accountName = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div[3]/form[2]/div[3]/table/tbody/tr/td[4]/a"));
        System.out.println(accountName.getText());
        Reporter.log("Display the Name in console<br>");

        WebElement clearFilter = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"pagination\"]/td/table/tbody/tr/td[1]/ul[4]/li[1]")));
        clearFilter.click();
        Reporter.log("Clear Filter<br>");
    }

    @AfterClass
    public void afterMethod() {
        driver.quit();
    }
}