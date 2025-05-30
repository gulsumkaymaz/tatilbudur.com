package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(xpath = "//a[@role='tab'][normalize-space()='Tur Ara']")
    public WebElement turAraTabi;

    @FindBy(xpath = "//input[@id='searchTourV2']")
    public WebElement turAraInput;

    @FindBy(xpath = "//button[@id='searchFormTourV2Submit']")
    public WebElement turAraButon;

    @FindBy(xpath = "//input[@id='key']")
    public WebElement otelAraInput;

    @FindBy(xpath=  "//button[@id='searchFormHotelSubmitBtn']")
    public WebElement otelAraButon;



}
