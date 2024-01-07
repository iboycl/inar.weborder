package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WeborderLoginPage extends BasePage {

	// Locators
	@FindBy(id = "login-username-input")
	WebElement userIdInputField;

	@FindBy(id = "login-password-input")
	WebElement passwordInputField;

	@FindBy(id = "login-button")
	WebElement loginButton;

	// Constructor
	public WeborderLoginPage() {
		super();
	}

	public void enterUserName(String userName) {
		userIdInputField.sendKeys(userName);
	}

	public void enterPassword(String password) {
		passwordInputField.sendKeys(password);
	}

	public void clickLoginButton() {
		loginButton.click();
	}

	public void login(String userName, String password) {
		enterUserName(userName);
		enterPassword(password);
		clickLoginButton();
	}

}
