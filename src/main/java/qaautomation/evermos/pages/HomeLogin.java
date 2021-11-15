package qaautomation.evermos.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import qaautomation.evermos.navigation.BasePage;

public class HomeLogin extends BasePage {
	
	// Halaman Toko Saya
	By tokoSayaPage = By.xpath("//a[@href='/my-store']");
	By getTitleTokoSaya = By.xpath("//h1[normalize-space()='Toko Saya']");
	By linkTautanToko = By.xpath("//span[normalize-space()='Salin Tautan Toko']");
	
	// Halaman Kategori
	By categoryPage = By.xpath("//span[normalize-space()='Kategori']");
	By getTitleCategory = By.xpath("//h1[normalize-space()='Kategori']");
	
	// Halaman Transaksi
	By transaksiPage = By.xpath("//a[@href='/transaction']//i//span");
	By getTitleTransaksi = By.xpath("//h1[normalize-space()='Transaksi']");
	
	// Halaman Akun
	By akunPage = By.xpath("//span[normalize-space()='Akun']");
	By getTitleAkun = By.xpath("//h1[normalize-space()='Akun Saya']");

	public HomeLogin(ThreadLocal<WebDriver> driver, ThreadLocal<WebDriverWait> explicitWait) {
		super(driver, explicitWait);
		PageFactory.initElements(driver.get(), this);
	}
	
	// Halaman Toko Saya
	public void pageTokoSaya() {
		clickAndWaitByXpath(tokoSayaPage);
	}
	public String getTitleTokoSayaPage() {
		return getText(getTitleTokoSaya);
	}
	public void getLinkTautan() {
		clickAndWaitByXpath(linkTautanToko);
	}
	
	// Halaman Kategori
	public void pageCategory() {
		clickAndWaitByXpath(categoryPage);
	}
	public String getTitleCategoryPage() {
		return getText(getTitleCategory);
	}
	
	// Halaman Transaksi
	public void pageTransaksi() {
		clickAndWaitByXpath(transaksiPage);
	}
	public String getTitleTransaksiPage() {
		return getText(getTitleTransaksi);
	}
	
	// Halaman Akun
	public void pageAkun() {
		clickAndWaitByXpath(akunPage);
	}
	public String getTitleAkunPage() {
		return getText(getTitleAkun);
	}	
	
}
