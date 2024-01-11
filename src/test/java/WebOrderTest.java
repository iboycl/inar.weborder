
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import pages.*;
import utils.BrowserUtils;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

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

		BrowserUtils.scrollDownWithPageDown();

		orderPage.enterCustomerInfo("Inar Academy", "deneme 1124", "Austin", "TX", "70178");

		orderPage.enterPaymentInfo("amex", "342738261027163", "11/20");

		String currentDate = LocalDate.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));

		List<String> orderInfo = Arrays.asList("Inar Academy", "Books", "10", currentDate, "deneme 1124", "Austin",
				"TX", "70178", "American Express", "342738261027163", "11/20");

		assertTrue(orderPage.orderSuccessAlertIsDisplayed());
		weborderHomePage.navigateToViewAllOrders();

		ViewAllOrdersPage viewAllOrdersPage = new ViewAllOrdersPage();
		viewAllOrdersPage.checkSelectedRows(new int[]{1});

		List<WebElement> lastRow = viewAllOrdersPage.getLastRowElements();
		lastRow.forEach(cell -> {
			assertEquals(cell.getText(), orderInfo.get(orderInfo.indexOf(cell.getText())), "Wrong order information!");
		});
		BrowserUtils.scrollUpWithPageUp();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}

	}

}
