package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Javascript_alerts {
    WebDriver driver;
    WebDriverWait wait;

    @Given("^User is on alert page$")
    public void userIsOnLoginPage() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.get("https://v1.training-support.net/selenium/javascript-alerts");
    }

    @When("^simple alert$")
    public void userEnterssimplealert() {
        WebElement simple = driver.findElement(By.xpath("//*[@id=\"simple\"]"));
        simple.click();
    }

    @When("^confirm alert$")
    public void userEntersconfirmalert() {
        WebElement confirm = driver.findElement(By.xpath("//*[@id=\"confirm\"]"));
        confirm.click();
    }

    @When("^prompt alert$")
    public void userEnterspromptalert() {
        WebElement prompt = driver.findElement(By.xpath("//*[@id=\"prompt\"]"));
        prompt.click();
    }


    @Then("^Switch focus$")
    public void focus() {
        driver.switchTo().alert();
    }

    @And("^get text$")
    public void Gettext() {
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
    }

    @And("^send keys$")
    public void sendkeys() {
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("awesome");
    }

    @And("^accept alert$")
    public void acceptalert() {
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    @And("^cancel alert$")
    public void cancelalert() {
        Alert alert = driver.switchTo().alert();
       alert.dismiss();
    }
    @And("^Close the Browser alert$")
    public void closeTheBrowser() {
        driver.quit();
    }
}
