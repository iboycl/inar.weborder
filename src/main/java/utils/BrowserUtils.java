package utils;

import org.openqa.selenium.JavascriptExecutor;

public class BrowserUtils {

	/**
	 * Scrolls the window vertically by the given amount of pixels.
	 * @params pixelAmount
	 */

	public static void scrollVertically(int pixelAmount) throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
		js.executeScript("window.scroll(0," + pixelAmount + ")");
	}

	public static void scrollDown() throws InterruptedException {
		scrollVertically(1000);
	}

	public static void scrollUp() throws InterruptedException {
		scrollVertically(-1000);
	}

}
