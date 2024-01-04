package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class OrderPage {
    private WebDriver driver;

    //Product information
    private By productSelectDropdown = By.id("productSelect");

    private By quantityInputField = By.id("quantityInput");

    private By unitPriceField = By.id("unitPriceInput");

    private By discountInputField = By.id("discountInput");

    private By totalPriceField = By.id("totalInput");

    private By calculateButton = By.xpath("//button[text()='Calculate']");

    //Customer information
    private By nameInputField = By.id("name");

    private By streetInputField = By.id("street");

    private By cityInputField = By.id("city");

    private By stateInputField = By.id("state");

    private By zipCodeInputField = By.id("zip");

    //Payment information

    private By visaRadioButton = By.id("visa");

    private By masterCardRadioButton = By.id("mastercard");

    private By amexRadioButton = By.id("amex");

    private By cardNumberInputField = By.id("cardNumber");

    private By expiryDateInputField = By.id("expiryDate");

    private By progressButton = By.xpath("//button[text()='Process']");

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    //Product information

    public void selectProduct(String productName) {
        WebElement productDropdown =  driver.findElement(productSelectDropdown);
        Select product = new Select(productDropdown);
        product.selectByVisibleText(productName);
    }

    public void enterQuantity (String quantity) {
        driver.findElement(quantityInputField).clear();
        driver.findElement(quantityInputField).sendKeys(quantity);
    }

    public String getUnitPrice () {
        return driver.findElement(unitPriceField).getAttribute("value");
    }

    public void enterDiscount (String discount) {
        driver.findElement(discountInputField).clear();
        driver.findElement(discountInputField).sendKeys(discount);
    }

    public String getTotalPrice () {
        return driver.findElement(totalPriceField).getAttribute("value");
    }

    public void clickCalculate () {
        driver.findElement(calculateButton).click();
    }

    public String calculatePrice (String productName, String quantity, String discount) {
        selectProduct(productName);
        enterQuantity(quantity);
        enterDiscount(discount);
        clickCalculate();
        return getTotalPrice();
    }

    //Customer information

    public void enterName (String name) {
        driver.findElement(nameInputField).clear();
        driver.findElement(nameInputField).sendKeys(name);
    }

    public void enterStreet (String street) {
        driver.findElement(streetInputField).clear();
        driver.findElement(streetInputField).sendKeys(street);
    }

    public void enterCity (String city) {
        driver.findElement(cityInputField).clear();
        driver.findElement(cityInputField).sendKeys(city);
    }

    public void enterState (String state) {
        driver.findElement(stateInputField).clear();
        driver.findElement(stateInputField).sendKeys(state);
    }

    public void enterZipCode (String zipCode) {
        driver.findElement(zipCodeInputField).clear();
        driver.findElement(zipCodeInputField).sendKeys(zipCode);
    }

    public void enterCustomerInfo(String name, String street, String city, String state, String zip) {
        enterName(name);
        enterStreet(street);
        enterCity(city);
        enterState(state);
        enterZipCode(zip);
    }

    //Payment information

    public void selectVisa () {
        driver.findElement(visaRadioButton).click();
    }

    public void selectMasterCard () {
        driver.findElement(masterCardRadioButton).click();
    }

    public void selectAmex () {
        driver.findElement(amexRadioButton).click();
    }

    public void enterCardNumber (String cardNumber) {
        driver.findElement(cardNumberInputField).clear();
        driver.findElement(cardNumberInputField).sendKeys(cardNumber);
    }

    public void enterExpiryDate (String expiryDate) {
        driver.findElement(expiryDateInputField).clear();
        driver.findElement(expiryDateInputField).sendKeys(expiryDate);
    }

    public void clickProgress () {
        driver.findElement(progressButton).click();
    }

    public void enterPaymentInfo(String cardType, String cardNr, String expiryDate) {
        switch (cardType.toLowerCase()) {
            case "visa" -> selectVisa();
            case "mastercard" -> selectMasterCard();
            case "amex" -> selectAmex();
        }

        enterCardNumber(cardNr);
        enterExpiryDate(expiryDate);
        clickProgress();
    }
}
