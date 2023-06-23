package allanezas;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ejemploSelenium {
    @Test
    void ejemploLevantarBrowser()throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://selenium.dev");
        Thread.sleep(5000);
        driver.close();
    }
}
