package InarAcademy;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.fetch.Fetch;
import org.openqa.selenium.devtools.v85.fetch.model.RequestPattern;
import org.openqa.selenium.devtools.v85.network.model.ErrorReason;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class NetWorkFailedRequest {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webDriver.chrome.driver", "C:\\Users\\mesut\\Desktop\\Grid\\chromeBrowser\\chromedriver");
        ChromeDriver driver = new ChromeDriver();
        //log file->
        DevTools devTools = driver.getDevTools();
        devTools.createSession();
        //Optional<String> urlPattern
        Optional<List<RequestPattern>> patterns= Optional.of(Arrays.asList(
                new RequestPattern(Optional.of("*GetBook*"),Optional.empty(),Optional.empty())));



        devTools.send(Fetch.enable(patterns,Optional.empty()));
        devTools.addListener(Fetch.requestPaused(),request ->{
            devTools.send(Fetch.failRequest(request.getRequestId(), ErrorReason.FAILED));
        } );
        driver.get("https://rahulshettyacademy.com/angularAppdemo/");
        driver.findElement(By.cssSelector("button[routerlink*='library']")).click();

    }
}
