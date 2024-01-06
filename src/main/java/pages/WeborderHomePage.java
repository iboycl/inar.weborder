package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WeborderHomePage extends BasePage {

	@FindBy(id = "view-orders-tab")
	WebElement viewAllOrdersLink;

	@FindBy(id = "view-products-tab")
	WebElement viewAllProductsLink;

	@FindBy(id = "order-tab")
	WebElement orderLink;

	public WeborderHomePage() throws InterruptedException {
		super();
	}

	public void navigateToViewAllOrders() {
		viewAllOrdersLink.click();
	}

	public void navigateToViewAllProducts() {
		viewAllProductsLink.click();
	}

	public void navigateToOrder() {
		orderLink.click();
	}

}
