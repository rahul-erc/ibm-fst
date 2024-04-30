import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.interactions.Actions;


public class Selenium_activity7 {
    public static void main(String[] args) {
        // Setup the Firefox driver(GeckoDriver)
        WebDriverManager.firefoxdriver().setup();

        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();

        // Open the browser
        driver.get("https://v1.training-support.net/selenium/drag-drop");

        // getting title and printing
        String ptitle = driver.getTitle();
        System.out.println(ptitle);

        //Find ball and simulate click and drag to dropzone1
        WebElement draggable = driver.findElement(By.id("draggable"));
        WebElement droppable = driver.findElement(By.id("droppable"));
        new Actions(driver)
                .dragAndDrop(draggable, droppable)
                .perform();

        String str = droppable.getText();
        System.out.println(str);

        WebElement dropzone2 = driver.findElement(By.id("dropzone2"));
        new Actions(driver)
                .dragAndDrop( droppable, dropzone2)
                .perform();

        String str1 = dropzone2.getText();
        System.out.println(str1);

        driver.quit();
    }
}