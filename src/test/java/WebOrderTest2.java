
import org.testng.annotations.Test;
import pages.HomePage;
import pages.OrderPage;
import pages.WeborderHomePage;
import pages.WeborderLoginPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class WebOrderTest2 extends Hooks {

	@Test
	void testSeleniumWebDriver() {

		HomePage homePage = new HomePage();

		homePage.clickOnWebOrderLink();
		WeborderLoginPage weborderLoginPage = new WeborderLoginPage();
		weborderLoginPage.login("Inar", "Academy");
		WeborderHomePage weborderHomePage = new WeborderHomePage();
		weborderHomePage.navigateToOrder();
		OrderPage orderPage = new OrderPage();

	}

}
