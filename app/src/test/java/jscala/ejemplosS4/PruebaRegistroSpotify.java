package jscala.ejemplosS4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class PruebaRegistroSpotify {

    private WebDriver driver;

    JavascriptExecutor js; //me permite manipular elementos como el scroll

    @BeforeEach
    void preparacionTest() {
        //preparas el webdriver
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver(); //Instanciar un objeto WebDriver (browser)

        js = (JavascriptExecutor) driver;

        driver.get("https://open.spotify.com/");
        driver.manage().window().maximize();
        //administrar los tiempos de respuesta de carga de pagina
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @AfterEach
    void posEjecucion() {
        //driver.close();
    }

    @Test
    void registrarCtaSpotify(){

        By locatorBtnRegistrarte = By.xpath(" //button[contains(text(),'Registrarte')]");

        WebElement btnRegistrarte = driver.findElement(locatorBtnRegistrarte);

        btnRegistrarte.click();

        //Assertions.assertEquals("Inicia sesión en Spotify",driver.findElement(By.xpath("//h1[contains(text(),'Inicia sesi')]")).getText());

        //completando campo correo electronico
        By locatorCorreoElectronico = By.xpath("//input[@id='email']");

        WebElement campoEmail = driver.findElement(locatorCorreoElectronico);

        campoEmail.sendKeys("emaildeprueba@prueba.com");

        //completando campo contraseña
        By locatorContrasennia = By.xpath("//input[@id='password']");

        WebElement campoContrasennia = driver.findElement(locatorContrasennia);

        campoContrasennia.sendKeys("1234zxcv");

        //completando nombre de usuario (simplificado)

        driver.findElement(By.xpath("//input[@id='displayname']")).sendKeys("Julieta");
    }
}
