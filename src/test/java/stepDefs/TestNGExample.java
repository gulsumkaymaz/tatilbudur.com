package stepDefs;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.HomePage;
import utils.Config;
import utils.Driver1;


public class TestNGExample extends BasePage {

    @Test
    public void transferSearch() {

        // TatilBudur web sitesi açılır
        String homepageUrl = Config.getProperty("baseurl");
        Driver1.getDriver().get(homepageUrl);
        Assert.assertTrue(Driver1.getDriver().getCurrentUrl().contains(homepageUrl));

        // Tur ara seçeneğine tıklanır
        getHomePage().turAraTabi.click();

        // Antalya kelimesi arama kısmına girilir
        getHomePage().turAraInput.sendKeys("Antalya");
        getHomePage().turAraButon.click();

    }
}
