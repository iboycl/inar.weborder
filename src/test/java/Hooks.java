import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import utils.Driver;

public class Hooks {

	@BeforeAll
	public static void setupTestEnvironment() {
		Driver.getDriver();
	}

	@AfterAll
	public static void tearDownTestEnvironment() {
		Driver.closeDriver();
	}

}
