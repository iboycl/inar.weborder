package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	// Locators
	@FindBy(linkText = "Weborder")
	private WebElement webOrderLink;

	@FindBy(linkText = "Webautomation")
	private WebElement webAutomationLink;

	@FindBy(linkText = "Target Market")
	private WebElement targetMarketLink;

	@FindBy(linkText = "Booking")
	private WebElement bookingLink;

	@FindBy(linkText = "Handling Certifications")
	private WebElement handlingCertificationsLink;

	@FindBy(linkText = "File Uploading")
	private WebElement fileUploadingLink;

	@FindBy(className = "theme-switcher")
	private WebElement themeSwitcherToggleButton;

	@FindBy(css = "h1.display-1.text-fifth")
	private WebElement exploreInarTestingWorldTitleText;

	// Constructor
	public HomePage() {
		super();
	}

	// Actions with Java methods

	public void clickOnWebOrderLink() {
		webOrderLink.click();
	}

	public void clickOnAutomationLink() {
		webAutomationLink.click();
	}

	public void clickOnTargetMarketLink() {
		targetMarketLink.click();
	}

	public void clickOnBookingLink() {
		bookingLink.click();
	}

	public void clickOnHandlingCertificationsLink() {
		handlingCertificationsLink.click();
	}

	public void clickOnFileUploadingLink() {
		fileUploadingLink.click();
	}

	public void clickOnThemeSwitcherToggleButton() {
		themeSwitcherToggleButton.click();
	}

	public String getWelcomeText() {
		return exploreInarTestingWorldTitleText.getText();
	}

	public void refreshPage() {
		driver.navigate().refresh();
	}

}
