import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.List;


public class Selenium_activity13 {
    public static void main(String[] args) throws InterruptedException {
        // Setup the Firefox driver(GeckoDriver)
        WebDriverManager.firefoxdriver().setup();

        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();

        // Open the browser
        driver.get("https://v1.training-support.net/selenium/tables");

        // getting title and printing
        String ptitle = driver.getTitle();
        System.out.println(ptitle);

        WebElement list = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[2]/div[2]/table/tbody"));

        List<WebElement> rows = list.findElements(By.xpath(".//tr"));
        int rowCount = rows.size();


        List<WebElement> columns = rows.get(0).findElements(By.xpath("./*[self::td or self::th]")); // Assuming the first row represents column headers
        int columnCount = columns.size();

        System.out.println("Number of rows: " + rowCount);
        System.out.println("Number of columns: " + columnCount);

        //find and print all the cell values in the third row
        WebElement thirdRow = list.findElement(By.xpath(".//tr[3]"));

        // Find all cell elements in the third row
        List<WebElement> cells = thirdRow.findElements(By.xpath("./*[self::td or self::th]"));

        // Print the values of all cells in the third row
        System.out.println("Cell values of the third row:");
        for (WebElement cell : cells) {
            System.out.println(cell.getText());
        }

        //Find and print 2nd row 2nd column
        WebElement cell = driver.findElement(By.xpath("//table//tr[2]/td[2]"));

        // Print the value of the cell
        System.out.println("Value of the cell in the second row and second column: " + cell.getText());


        driver.quit();
    }

}