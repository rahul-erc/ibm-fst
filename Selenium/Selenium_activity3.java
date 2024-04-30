import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.awt.*;


public class Selenium_activity3 {
    //RGB to hexacolor
    public static String convertRGBToHex(String head_color) {
        // Extract RGB components using regular expressions
        String[] rgbComponents = head_color.replace("rgb(", "").replace(")", "").split(",");
        int red = Integer.parseInt(rgbComponents[0].trim());
        int green = Integer.parseInt(rgbComponents[1].trim());
        int blue = Integer.parseInt(rgbComponents[2].trim());

        // Create Color object
        Color color = new Color(red, green, blue);

        // Convert RGB to hexadecimal
        return String.format("#%02x%02x%02x", color.getRed(), color.getGreen(), color.getBlue());
    }

    public static void main(String[] args) {
        // Setup the Firefox driver(GeckoDriver)
        WebDriverManager.firefoxdriver().setup();

        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();

        // Open the browser
        driver.get("https://v1.training-support.net/selenium/target-practice");

        //Printing the title of the page
        String ptitle = driver.getTitle();
        System.out.println(ptitle);

        //finding 3rd header AND PRINTING
        WebElement head3 = driver.findElement(By.xpath("//*[@id=\"third-header\"]"));
        String str = head3.getText();
        System.out.println(str);
        //Finding 5th header and printing its color
        WebElement head5 = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[2]/div/div/div/div[1]/h5"));
        String head_color = head5.getCssValue("color");
        System.out.println(head_color);
        String hexColor = convertRGBToHex(head_color);
        System.out.println("Converted color: " + hexColor);



        //Find violet button and printing its all classes
        WebElement violetb = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[2]/div/div/div/div[2]/div[2]/button[3]"));
        String classes = violetb.getAttribute("class");
        System.out.println(classes);

        //Find the grey button and print its text
        WebElement greyb = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[2]/div/div/div/div[2]/div[3]/button[2]"));
        String str1 = greyb.getText();
        System.out.println(str1);




        driver.quit();
    }
}