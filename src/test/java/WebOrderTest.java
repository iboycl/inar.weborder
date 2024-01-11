

import org.testng.annotations.Test;
import pages.HomePage;
import pages.WeborderLoginPage;


public class WebOrderTest extends Hooks {

	@Test
	void testSeleniumWebDriver() {

		HomePage homePage = new HomePage();

		homePage.clickOnWebOrderLink();
		WeborderLoginPage weborderLoginPage = new WeborderLoginPage();


	}

}
