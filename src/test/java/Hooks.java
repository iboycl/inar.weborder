
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import utils.Driver;

public class Hooks {

	@Parameters("browser")

	@BeforeMethod
	public static void setupTestEnvironment(String browser) {
		Driver.getDriver(browser);
	}

	@AfterMethod
	public static void tearDownTestEnvironment() {
		Driver.closeDriver();
	}

}
