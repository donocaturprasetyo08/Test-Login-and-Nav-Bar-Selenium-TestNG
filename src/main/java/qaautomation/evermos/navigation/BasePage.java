package qaautomation.evermos.navigation;

import java.util.List;

//import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	ThreadLocal<WebDriverWait> explicitWait = new ThreadLocal<WebDriverWait>();
	
	public BasePage(ThreadLocal<WebDriver> driver, ThreadLocal<WebDriverWait> explicitWait) {
		this.driver = driver;
		this.explicitWait = explicitWait;
	}
	
	protected final void clickAndWaitByXpath(By locator) {
		explicitWait.get().until(ExpectedConditions.elementToBeClickable(locator));
		driver.get().findElement(locator).click();
	}

	protected final void setText(By locator, String text) {
		explicitWait.get().until(ExpectedConditions.elementToBeClickable(locator));
		driver.get().findElement(locator).sendKeys(text);
	}

	protected final String getText(By locator) {
		explicitWait.get().until(ExpectedConditions.elementToBeClickable(locator));
		return driver.get().findElement(locator).getText();
	}
	protected final void scrollUntilElement(By locator) {
		explicitWait.get().until(ExpectedConditions.elementToBeClickable(locator));
		WebElement element = driver.get().findElement(locator);
		JavascriptExecutor js = (JavascriptExecutor) driver.get();  
		js.executeScript("return arguments[0].scrollIntoView();", element);
	}
	protected final void uploadAvatar(By locator, String location) {
		explicitWait.get().until(ExpectedConditions.elementToBeClickable(locator));
		WebElement uploadElement = driver.get().findElement(locator);
		uploadElement.sendKeys(location);
	}
	protected final void selectFromOptions(By locator, String select) {
		explicitWait.get().until(ExpectedConditions.elementToBeClickable(locator));
		Select clickData = new Select(driver.get().findElement(locator));
		clickData.selectByVisibleText(select);
	}
	protected final void selectCheckbox(By locator) {
		explicitWait.get().until(ExpectedConditions.elementToBeClickable(locator));
		WebElement element = driver.get().findElement(locator);
		element.click();
	}
	protected final void clickAndWaitByModal(By locator) {
		WebElement element = driver.get().findElement(locator);
		JavascriptExecutor js = (JavascriptExecutor) driver.get();  
		js.executeScript("arguments[0].click();", element);
	}
	protected final String getLink(By locator) {
		explicitWait.get().until(ExpectedConditions.elementToBeClickable(locator));
		WebElement element = driver.get().findElement(locator);
		return element.getAttribute("href");
	}
	protected final void searchText(By locator, String text) {
		explicitWait.get().until(ExpectedConditions.elementToBeClickable(locator));
		WebElement element = driver.get().findElement(locator);
		element.sendKeys(text);
		element.sendKeys(Keys.RETURN);
	}
	protected final List<WebElement> getList(By locator) {
		explicitWait.get().until(ExpectedConditions.elementToBeClickable(locator));
		List<WebElement> listData = 
				driver.get().findElements(locator);
		return listData;
	}
}