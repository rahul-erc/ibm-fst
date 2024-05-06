package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class Loginform {
    WebDriver driver;
    WebDriverWait wait;

    @Given("^User is on Login page$")
    public void userIsOnLoginPage() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.get("https://v1.training-support.net/selenium/login-form");
    }

    @When("^User enters username and password$")
    public void userEntersUsernameAndPassword() {
        WebElement usernameInput = driver.findElement(By.name("Username"));
        WebElement passwordInput = driver.findElement(By.name("Password"));

        usernameInput.sendKeys("admin");
        passwordInput.sendKeys("password");

        WebElement loginButton = driver.findElement(By.cssSelector("button.ui.button[type='submit']"));
        loginButton.click();
    }


    @Then("^Read the page title and confirmation message$")
    public void readConfirm() {
        String title = driver.getTitle();
        System.out.println("Page title is: " + title);
        WebElement msg = driver.findElement(By.id("action-confirmation"));
        System.out.println(msg.getText());
    }

    @And("^Close the Browser Login$")
    public void closeTheBrowser() {
        driver.quit();
    }


}