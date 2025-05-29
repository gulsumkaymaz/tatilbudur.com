package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(xpath = "//a[@role='tab'][normalize-space()='Tur Ara']")
    public WebElement turAraButon;

    @FindBy(xpath = "//input[@id='key']")
    public WebElement turAraInput;

    @FindBy(xpath = "//input[@id='key']")
    public WebElement otelAraInput;

    @FindBy(css = "#searchFormHotelSubmitBtn")
    public WebElement otelAraButon;
}
