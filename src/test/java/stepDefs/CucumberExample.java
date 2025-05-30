package stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.BasePage;
import utils.Config;
import utils.Driver1;

public class CucumberExample extends BasePage {

    @Given("TatilBudur web sitesi acilir")
    public void tatilbudurWebSitesiAcilir() {
        Driver1.getDriver().get("https://www.tatilbudur.com/");

        Assert.assertEquals(Driver1.getDriver().getCurrentUrl(),
                Config.getProperty("baseurl"));
    }

    @When("Antalya kelimesi arama kismina girilir")
    public void antalyaKelimesiAramaKisminaGirilir() {
      getHomePage().otelAraInput.sendKeys("ANTALYA");
    }

    @And("Ara butonuna tiklanir")
    public void araButonunaTiklanir() throws InterruptedException {
        wait(15);
        getHomePage().otelAraButon.click();
    }
}
