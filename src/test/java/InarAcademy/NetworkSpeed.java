package InarAcademy;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v107.network.Network;
import org.openqa.selenium.devtools.v107.network.model.ConnectionType;

import java.util.Optional;

public class NetworkSpeed {

    public static void main(String[] args) {
        //waits -


        System.setProperty("webDriver.chrome.driver", "C:\\Users\\mesut\\Desktop\\Grid\\chromeBrowser\\chromedriver");
        ChromeDriver driver = new ChromeDriver();
        DevTools devTools = driver.getDevTools();
        devTools.createSession();
        //Network.emulateNetworkConditions
        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
        devTools.send(Network.emulateNetworkConditions(false, 3000, 20_000, 100000,
                Optional.of(ConnectionType.ETHERNET)));

        devTools.addListener(Network.loadingFailed(),loadingFailed -> {
            System.out.println(loadingFailed.getErrorText());
            System.out.println(loadingFailed.getTimestamp());
        });

        long startTime = System.currentTimeMillis();
        driver.get("https://rahulshettyacademy.com/angularAppdemo/");
        driver.findElement(By.cssSelector("button[routerlink*='library']")).click();
        driver.get("http://google.com");
        driver.findElement(By.name("q")).sendKeys("onedio", Keys.ENTER);
        driver.findElements(By.cssSelector(".LC20lb")).get(0).click();
        String text = driver.findElement(By.cssSelector("button[title='Video']")).getText();
        System.out.println(text);
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
        driver.close();
        //15548  1745
        //190129    20550

    }
}
