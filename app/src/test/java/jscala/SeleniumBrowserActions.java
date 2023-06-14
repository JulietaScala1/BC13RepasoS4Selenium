package jscala;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.SQLOutput;

public class SeleniumBrowserActions {

    private String titulo;

    private WebDriver driver;

    @BeforeEach
    void preparacionTests() {
        //preparas el webdriver
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver(); //Instanciar un objeto WebDriver (browser)
    }

    @AfterEach
    void posEjecucion() {
        driver.close();
    }
    @Test
    void browserActions() {

        //cargar una pagina
        driver.get("https://www.google.cl");

        titulo = driver.getTitle();
        System.out.println("El titulo del sitio es: "+titulo);

        //maximizar browser
        driver.manage().window().maximize();

        //redireccionar a otra pagina
        driver.navigate().to("https://www.selenium.dev");

        titulo = driver.getTitle();
        System.out.println("El titulo del sitio es: "+titulo);

        //refresh
        driver.navigate().refresh();

        //volver a google
        driver.navigate().back();

        titulo = driver.getTitle();
        System.out.println("El titulo del sitio es: "+titulo);
    }

    @Test
    void crearCtaSpotify() {
        driver.get("https://open.spotify.com/");

        By locatorBtnIniciarSesion = By.xpath("//button[@data-testid='login-button']");

        WebElement btnIniciarSesion = driver.findElement(locatorBtnIniciarSesion);

        btnIniciarSesion.click();
    }
}
