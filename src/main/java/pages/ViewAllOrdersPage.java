package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.ArrayList;
import java.util.List;

public class ViewAllOrdersPage extends BasePage {
	@FindBy(xpath = "//tbody/tr")
	List<WebElement> rows;

	@FindBy(linkText = "Add More Data")
	WebElement addMoreDataButton;

	@FindBy(linkText = "Check All")
	WebElement checkAllButton;

	@FindBy(linkText = "Uncheck All")
	WebElement uncheckAllButton;

	@FindBy(linkText = "Delete")
	WebElement deleteButton;

	@FindBy(id = "logout-button")
	WebElement logoutButton;

	public ViewAllOrdersPage() {
		super();
	}

	public void clickOnAddMoreData() {
		addMoreDataButton.click();
	}

	public void clickOnAddMoreDataByTimes(int times) {
		for (int i = 0; i < times; i++) {
			addMoreDataButton.click();
		}
	}

	public void clickOnCheckAll() {
		checkAllButton.click();
	}

	public void clickOnUnselectAll() {
		uncheckAllButton.click();
	}

	public void clickOnDelete () {
		deleteButton.click();
	}

	public void checkSelectedRow(int index) {
		rows.get(index - 1).findElement(By.cssSelector(".form-check-input")).click();

	}
	public void checkSelectedRows(int[] rowIndex) {
        for (int index : rowIndex) {
            rows.get(index - 1).findElement(By.cssSelector(".form-check-input")).click();
        }
	}

	public List<WebElement> getLastRowElements () {
		//List<WebElement> lastRow = new ArrayList<>();
		return rows.get(rows.size() - 1).findElements(By.tagName("span"));
	}

}
