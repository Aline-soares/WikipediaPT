package simples;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Artigo {
    String url;                          // endere�o do site alvo
    WebDriver driver;                    // Objeto do Selenium WebDriver

    @Before                              // Antes do Teste - vai instanciar
    public void iniciar(){
        url = "https://pt.wikipedia.org/";
        System.setProperty("webdriver.chrome.driver", "drivers/chrome/90/chromedriver.exe"); // onde est� o chrome driver
        driver = new ChromeDriver(); // instanciar Selenium do Chrome Driver

        driver.manage().window().maximize();    // maximizar a janela do navegador
        driver.manage().timeouts().implicitlyWait(180000, TimeUnit.MILLISECONDS); // define uma espera implicita verificando o carregamento a cada milisegundo


    }

    @Test                               // Durante o Teste
    public void consultarArtigo(){
        // Abrir o site
        driver.get(url);
        // Pesquisar por "Ovo de P�scoa"
        driver.findElement(By.id("searchInput")).sendKeys("Ovo de P�scoa");
        driver.findElement(By.name("search")).click(); // Clica na Lupa

        // Validar o titulo da p�gina de retorno
        assertEquals("Wikip�dia, a enciclop�dia livre", driver.getTitle());
        //assertEquals("Ovo de P�scoa - Wikip�dia, a enciclop�dia livre", driver.getTitle());
        //assertTrue(driver.getTitle().contains("Ovo de P�scoa"));

    }

    @After                              // Depois do Teste
    public void finalizar(){
        driver.quit();

    }
}
