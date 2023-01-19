package InarAcademy;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import java.util.List;

public class ConsoleLogsCapture {
    public static void main(String[] args) {

        System.setProperty("webDriver.chrome.driver","C:\\Users\\mesut\\Desktop\\Grid\\chromeBrowser\\chromedriver");
        ChromeDriver driver = new ChromeDriver();

        //listener-OnTester,string....)

        driver.get("https://rahulshettyacademy.com/angularAppdemo/");
        driver.findElement(By.linkText("Browse Products")).click();
        driver.findElement(By.xpath("(//a[normalize-space()='Selenium'])[1]")).click();
        driver.findElement(By.cssSelector(".add-to-cart ")).click();
        driver.findElement(By.linkText("Cart")).click();
        driver.findElement(By.id("exampleInputEmail1")).click();
        driver.findElement(By.id("exampleInputEmail1")).clear();
        driver.findElement(By.id("exampleInputEmail1")).sendKeys("2");

        LogEntries entry = driver.manage().logs().get(LogType.BROWSER);//Get LOgEntries object
        List<LogEntry> logs =entry.getAll(); //LogEntryObject - getAll method returns all logs in list

        for (LogEntry e : logs) {   //iterating through list and printing each log message

            System.out.println(e.getMessage());//Log4J

        }
    }
}
