import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.HomePage;
import pages.OrderPage;
import pages.WeborderHomePage;
import pages.WeborderLoginPage;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WebOrderChromeDriverTest {

	WebDriver driver;

	@BeforeEach
	void setUpTestEnvironment() {
		driver = new ChromeDriver(new ChromeOptions().addArguments("--start-maximized"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Test
	void testSeleniumWebDriver() throws InterruptedException {
		driver.get("https://InarAcademy:Fk160621.@test.inar-academy.com");

		HomePage homePage = new HomePage(driver);

		WeborderLoginPage weborderLoginPage = homePage.clickOnWebOrderLink();
		WeborderHomePage weborderHomePage = weborderLoginPage.login("Inar", "Academy");
		OrderPage orderPage = weborderHomePage.navigateToOrder();

		String totalPrice = orderPage.calculatePrice("Books", "10", "10");
		assertEquals("810", totalPrice);

		orderPage.enterCustomerInfo("Inar Academy", "deneme 1124", "Austin", "TX", "70178");

		orderPage.enterPaymentInfo("amex", "342738261027163", "11/20");

		WebElement orderSuccessAlert = driver.findElement(By.xpath("//div[text()='New order has been successfully added.']"));
		assertTrue(orderSuccessAlert.isDisplayed());
		Thread.sleep(5000);

	}

	@AfterEach
	void tearDown() {

		driver.quit();
	}

}
