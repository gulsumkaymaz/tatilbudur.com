package pages;

import org.openqa.selenium.support.PageFactory;
import utils.Driver1;

public abstract class BasePage {

    public BasePage(){
        PageFactory.initElements(Driver1.getDriver(),this);
    }

    private HomePage homePage;

    public HomePage getHomePage() {
        if (homePage == null) {
            homePage = new HomePage();
        }
        return homePage;
    }
}
