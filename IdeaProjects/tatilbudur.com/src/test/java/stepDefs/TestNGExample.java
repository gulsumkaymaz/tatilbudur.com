package stepDefs;

import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Config;
import utils.Driver1;


public class TestNGExample {

@Test
    public void transferSearch(){

    // TatilBudur web sitesi açılır
    String homepageUrl = Config.getProperty("baseurl");
    Driver1.getDriver().get(homepageUrl);
    Assert.assertTrue(Driver1.getDriver().getCurrentUrl().contains(homepageUrl));

    // Antalya kelimesi arama kısmına girilir


    // Başlangıç ve bitiş tarihleri seçilir

}
}
