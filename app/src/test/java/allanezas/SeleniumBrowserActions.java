package allanezas;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.SQLOutput;
import java.util.concurrent.TimeUnit;

public class SeleniumBrowserActions {

    private String titulo;
    private WebDriver driver;

    @BeforeEach
    void preparacionTests(){
        //preparar el webdriver
        WebDriverManager.chromedriver().setup();

        driver= new ChromeDriver(); //instanciar un objeto webdriver(browser)

        //administrar tiempos de respuesta de carga de la pagina
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    @Test
    void browserActions(){
        //preparar el webdriver
        WebDriverManager.chromedriver().setup();

        WebDriver driver= new ChromeDriver(); //instanciar un objeto webdriver(browser)

        //cargar una pagina
        driver.get("https://www.google.com.ar");

        titulo = driver.getTitle();
        System.out.println("el titulo de la pagina es " + titulo);

        //maximizar browser
        driver.manage().window().maximize();

        //redireccionar a otra pagina
        driver.navigate().to("https://www.selenium.dev");

        //refresh
        driver.navigate().refresh();

        //volver a google
        driver.navigate().back();


    }

    @Test
    void crearCuentaSpotify(){
driver.get("https://www.spotify.com/");
By locatorBtnIniciarSesion = By.xpath("//button[@data-testid='login-button']");

WebElement btnIniciarSesion = driver.findElement(locatorBtnIniciarSesion);
btnIniciarSesion.click();



Assertions.assertEquals("Inicia sesión en Spotify", driver.findElement(By.xpath("//h1[contains(text(), 'inicia sesi')]")).getText());

    }

    @AfterEach
    void cerrarSesion(){
        driver.close();
    }
}
