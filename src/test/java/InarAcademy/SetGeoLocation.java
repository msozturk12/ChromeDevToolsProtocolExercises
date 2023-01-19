package InarAcademy;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;

import java.util.HashMap;
import java.util.Map;

public class SetGeoLocation {
    public static void main(String[] args) {

        System.setProperty("webDriver.chrome.driver", "C:\\Users\\mesut\\Desktop\\Grid\\chromeBrowser\\chromedriver");
        ChromeDriver driver = new ChromeDriver();

        DevTools devTools = driver.getDevTools();
        devTools.createSession();

        Map<String, Object> coordinates = new HashMap();
        coordinates.put("latitude", 48);
        coordinates.put("longitude", 2);
        coordinates.put("accuracy", 1);

        driver.executeCdpCommand("Emulation.setGeolocationOverride", coordinates);
        driver.get("http://google.com");
        driver.findElement(By.name("q")).sendKeys("onedio",Keys.ENTER);

        driver.findElements(By.cssSelector(".LC20lb")).get(0).click();
        String text = driver.findElement(By.cssSelector("button[title='Video']")).getText();
        System.out.println(text);


    }
}
