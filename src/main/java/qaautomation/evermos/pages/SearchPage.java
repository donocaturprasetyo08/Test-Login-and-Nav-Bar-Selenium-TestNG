package qaautomation.evermos.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import qaautomation.evermos.navigation.BasePage;
import qaautomation.evermos.utils.Utils;

public class SearchPage extends BasePage {
	
	By buttonSearch = By.xpath("//span[@class='appHead__search__input']");
	By inputSearch = By.xpath("//input[@placeholder='Cari Produk di Evermos…']");
	
	By titleSearch = By.xpath("//div[@class='productCard__title']");

	public SearchPage(ThreadLocal<WebDriver> driver, ThreadLocal<WebDriverWait> explicitWait) {
		super(driver, explicitWait);
		PageFactory.initElements(driver.get(), this);
		// TODO Auto-generated constructor stub
	}
	
	public void searchKeyword(String inputKeyword) {
		clickAndWaitByXpath(buttonSearch);
		Utils.hardWait(5);
		searchText(inputSearch, inputKeyword);
	}
	
	public List<WebElement> listSearch() {
		return getList(titleSearch);
	}

}
