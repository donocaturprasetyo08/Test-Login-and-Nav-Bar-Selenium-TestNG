package qaautomation.evermos.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import qaautomation.evermos.navigation.BasePage;

public class Login extends BasePage {
	
	By buttonMasuk = By.xpath("//input[@value='Masuk']");
	By inputNomor = By.xpath("//input[@placeholder='Nomor Telepon Anda']");
	By inputPassword = By.xpath("//input[@placeholder='Kata Sandi Anda']");
	By buttonLogin = By.xpath("//button[normalize-space()='Masuk']");

	public Login(ThreadLocal<WebDriver> driver, ThreadLocal<WebDriverWait> explicitWait) {
		super(driver, explicitWait);
		// TODO Auto-generated constructor stub
	}
	
	public void TestPageLogin() {
		clickAndWaitByXpath(buttonMasuk);
	}
	public void TestLogin(String nomor, String password) {
		setText(inputNomor, nomor);
		setText(inputPassword, password);
		clickAndWaitByXpath(buttonLogin);
	}

}
