import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import utils.Driver;

public class Hooks {

	@BeforeAll
	public static void setupTestEnvironment() throws InterruptedException {
		Driver.getDriver();
	}

	@AfterAll
	public static void tearDownTestEnvironment() throws InterruptedException {
		if (Driver.getDriver() != null) {
			Driver.getDriver().quit();
		}
	}

}
