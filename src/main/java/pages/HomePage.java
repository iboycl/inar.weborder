package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver driver;

    //Locators

    private By webOrderLink = By.linkText("Weborder");

    private By webAutomationLink = By.linkText("Weborder");

    private By targetMarketLink = By.linkText("Target Market");

    private By bookingLink = By.linkText("Booking");

    private By handlingCertificationsLink = By.linkText("Handling Certifications");

    private By fileUploadingLink = By.linkText("File Uploading");

    private By themeSwitcherToggleButton = By.className("theme-switcher");

    private By exploreInarTestingWorldTitleText = By.cssSelector("h1.display-1.text-fifth");

    //Constructor
    public HomePage (WebDriver driver) {
        this.driver = driver;
    }

    //Actions with Java methods

    public WeborderLoginPage clickOnWebOrderLink(){
        driver.findElement(webOrderLink).click();
        return new WeborderLoginPage(driver);
    }

    public void clickOnAutomationLink(){
        driver.findElement(webAutomationLink).click();
    }

    public void clickOnTargetMarketLink(){
        driver.findElement(targetMarketLink).click();
    }

    public void clickOnBookingLink(){
        driver.findElement(bookingLink).click();
    }

    public void clickOnHandlingCertificationsLink(){
        driver.findElement(handlingCertificationsLink).click();
    }

    public void clickOnFileUploadingLink(){
        driver.findElement(fileUploadingLink).click();
    }

    public void clickOnThemeSwitcherToggleButton(){
        driver.findElement(themeSwitcherToggleButton).click();
    }

    public String getWelcomeText(){
        return driver.findElement(exploreInarTestingWorldTitleText).getText();
    }

    public void refreshPage() {
        driver.navigate().refresh();
    }

}
