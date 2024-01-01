import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WebOrderChromeDriverTest {

	WebDriver driver;

	@BeforeEach
	void setUpTestEnvironment() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Test
	void testSeleniumWebDriver() throws InterruptedException {
		driver.get("https://InarAcademy:Fk160621.@test.inar-academy.com");

		String currentURL = driver.getCurrentUrl();
		assertEquals("https://InarAcademy:Fk160621.@test.inar-academy.com/", currentURL);

		WebElement webOrder = driver.findElement(By.xpath("//a[@href='/weborder']"));

		webOrder.click();

		WebElement userInputField = driver.findElement(By.id("login-username-input"));
		userInputField.sendKeys("Inar");

		WebElement passwordInputField = driver.findElement(By.id("login-password-input"));
		passwordInputField.sendKeys("Academy");

		WebElement loginButton = driver.findElement(By.id("login-button"));
		loginButton.click();

		Thread.sleep(5000);
		WebElement welcomeText = driver.findElement(By.id("welcome-heading"));

		assertEquals("Welcome, Inar!", welcomeText.getText());

		/*
		 * ((JavascriptExecutor) driver).executeScript("window.open()"); ArrayList<String>
		 * tabs = new ArrayList<>(driver.getWindowHandles());
		 *
		 * Thread.sleep(2000); driver.switchTo().window(tabs.get(2));
		 */

	}

	@AfterEach
	void tearDown() {

		driver.quit();
	}

}
