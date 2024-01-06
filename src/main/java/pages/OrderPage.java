package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class OrderPage extends BasePage {

	// Product information
	@FindBy(id = "productSelect")
	WebElement productSelectDropdown;

	@FindBy(id = "quantityInput")
	WebElement quantityInputField;

	@FindBy(id = "unitPriceInput")
	WebElement unitPriceField;

	@FindBy(id = "discountInput")
	WebElement discountInputField;

	@FindBy(id = "totalInput")
	WebElement totalPriceField;

	@FindBy(xpath = "//button[text()='Calculate']")
	WebElement calculateButton;

	// Customer information
	@FindBy(id = "name")
	WebElement nameInputField;

	@FindBy(id = "street")
	WebElement streetInputField;

	@FindBy(id = "city")
	WebElement cityInputField;

	@FindBy(id = "state")
	WebElement stateInputField;

	@FindBy(id = "zip")
	WebElement zipCodeInputField;

	// Payment information
	@FindBy(id = "visa")
	WebElement visaRadioButton;

	@FindBy(id = "mastercard")
	WebElement masterCardRadioButton;

	@FindBy(id = "amex")
	WebElement amexRadioButton;

	@FindBy(id = "cardNumber")
	WebElement cardNumberInputField;

	@FindBy(id = "expiryDate")
	WebElement expiryDateInputField;

	@FindBy(xpath = "//button[text()='Process']")
	WebElement progressButton;

	@FindBy(xpath = "//div[text()='New order has been successfully added.']")
	WebElement orderSuccessAlert;

	public OrderPage() throws InterruptedException {
		super();
	}

	// Product information

	public void selectProduct(String productName) {
		Select product = new Select(productSelectDropdown);
		product.selectByVisibleText(productName);
	}

	public void enterQuantity(String quantity) {
		quantityInputField.sendKeys(quantity);
	}

	public String getUnitPrice() {
		return unitPriceField.getAttribute("value");
	}

	public void enterDiscount(String discount) {
		discountInputField.sendKeys(discount);
	}

	public String getTotalPrice() {
		return totalPriceField.getAttribute("value");
	}

	public void clickCalculate() {
		calculateButton.click();
	}

	public String calculatePrice(String productName, String quantity, String discount) {
		selectProduct(productName);
		enterQuantity(quantity);
		enterDiscount(discount);
		clickCalculate();
		return getTotalPrice();
	}

	// Customer information

	public void enterName(String name) {
		nameInputField.clear();
		nameInputField.sendKeys(name);
	}

	public void enterStreet(String street) {
		streetInputField.clear();
		streetInputField.sendKeys(street);
	}

	public void enterCity(String city) {
		cityInputField.clear();
		cityInputField.sendKeys(city);
	}

	public void enterState(String state) {
		stateInputField.clear();
		stateInputField.sendKeys(state);
	}

	public void enterZipCode(String zipCode) {
		zipCodeInputField.clear();
		zipCodeInputField.sendKeys(zipCode);
	}

	public void enterCustomerInfo(String name, String street, String city, String state, String zip) {
		enterName(name);
		enterStreet(street);
		enterCity(city);
		enterState(state);
		enterZipCode(zip);
	}

	// Payment information

	public void selectVisa() {
		visaRadioButton.click();
	}

	public void selectMasterCard() {
		masterCardRadioButton.click();
	}

	public void selectAmex() {
		amexRadioButton.click();
	}

	public void enterCardNumber(String cardNumber) {
		cardNumberInputField.clear();
		cardNumberInputField.sendKeys(cardNumber);
	}

	public void enterExpiryDate(String expiryDate) {
		expiryDateInputField.clear();
		expiryDateInputField.sendKeys(expiryDate);
	}

	public void clickProgress() {
		progressButton.click();
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

	public boolean orderSuccessAlertIsDisplayed() {
		return orderSuccessAlert.isDisplayed();
	}

}
