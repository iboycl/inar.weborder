import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.OrderPage;
import pages.WeborderHomePage;
import pages.WeborderLoginPage;
import utils.Driver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WebOrderTest extends Hooks {

	@Test
	void testSeleniumWebDriver() {

		HomePage homePage = new HomePage();

		homePage.clickOnWebOrderLink();
		WeborderLoginPage weborderLoginPage = new WeborderLoginPage();
		weborderLoginPage.login("Inar", "Academy");
		WeborderHomePage weborderHomePage = new WeborderHomePage();
		weborderHomePage.navigateToOrder();
		OrderPage orderPage = new OrderPage();

		String totalPrice = orderPage.calculatePrice("Books", "10", "10");
		assertEquals("810", totalPrice);

		orderPage.enterCustomerInfo("Inar Academy", "deneme 1124", "Austin", "TX", "70178");

		orderPage.enterPaymentInfo("amex", "342738261027163", "11/20");

		assertTrue(orderPage.orderSuccessAlertIsDisplayed());
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}

	}

}
