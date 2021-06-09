package steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Hooks extends Base{
    private Base base;

    public Hooks(Base base) {
        this.base = base;
    }

    @Before
    public void setup(){        // iniciar
        System.setProperty("webdriver.chrome.driver", "drivers/chrome90/chormedriver.exe");
        driver = new ChromeDriver();

        base.driver.manage().window().maximize();
        base.driver.manage().timeouts().implicitlyWait(100000, TimeUnit.MILLISECONDS);

    }

    @After
    public void tearDown(){     // finalizar
        base.driver.quit();
    }
}
