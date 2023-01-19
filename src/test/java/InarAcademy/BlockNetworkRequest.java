package InarAcademy;

import com.google.common.collect.ImmutableList;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v107.network.Network;

import java.util.Optional;

public class BlockNetworkRequest {
    public static void main(String[] args) {


        //css,images
        System.setProperty("webDriver.chrome.driver", "C:\\Users\\mesut\\Desktop\\Grid\\chromeBrowser\\chromedriver");
        ChromeDriver driver = new ChromeDriver();
        //log file->
        DevTools devTools = driver.getDevTools();
        devTools.createSession();
        devTools.send(Network.enable(Optional.empty(),Optional.empty(),Optional.empty()));
        devTools.send(Network.setBlockedURLs(ImmutableList.of("*jpg","*.css")));

        long startTime= System.currentTimeMillis();
        driver.get("https://rahulshettyacademy.com/angularAppdemo/");
        driver.findElement(By.linkText("Browse Products")).click();
        driver.findElement(By.linkText("Selenium")).click();
        driver.findElement(By.cssSelector(".add-to-cart")).click();
        System.out.println( driver.findElement(By.cssSelector(".sp")).getText());
        long endTime= System.currentTimeMillis();
        long time = endTime-startTime;
        System.out.println(time);



    }
}
