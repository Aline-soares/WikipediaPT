package steps;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static org.junit.Assert.assertTrue;

public class Post extends Base {
    private Base base;

    public Post(Base base) {
        this.base = base;
    }

    @Dado("^que acesso a Wikipedia em Portugues$")
    public void queAcessoAWikipediaEmPortugues() {
        base.driver.get(base.url);
    }

    @Quando("^pesquiso por \"([^\"]*)\"$")
    public void pesquisoPor(String produto){
        base.driver.findElement(By.id("searchform")).sendKeys(produto + Keys.ENTER);

    }

    @Entao("^Exibe a express�o \"([^\"]*)\" no t�tulo da guia$")
    public void exibeAExpress�oNoT�tuloDaGuia(String produto){
        assertTrue(base.driver.getTitle().contains(produto));

    }

    //oi
}
