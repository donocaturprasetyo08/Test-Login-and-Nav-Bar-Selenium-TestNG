package qaautomation.evermos.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import qaautomation.evermos.navigation.BasePage;

public class HomePageNavBar extends BasePage {

	By tentangKami = By.xpath("//a[normalize-space()='tentang kami']");
	By panduanReseller = By.xpath("//a[normalize-space()='panduan reseller']");
	By promo = By.xpath("//a[contains(text(),'Promo')]");
	By galeriProduk = By.xpath("//a[normalize-space()='galeri produk']");
	By kontakKami = By.xpath("//a[normalize-space()='kontak kami']");
	
	public HomePageNavBar(ThreadLocal<WebDriver> driver, ThreadLocal<WebDriverWait> explicitWait) {
		super(driver, explicitWait);
		// TODO Auto-generated constructor stub
	}
	
	public void TestTentangKami() {
		clickAndWaitByXpath(tentangKami);
	}
	public void TestPanduanReseller() {
		clickAndWaitByXpath(panduanReseller);
	}
	public void TestPromo() {
		clickAndWaitByXpath(promo);
	}
	public void TestGaleriProduk() {
		clickAndWaitByXpath(galeriProduk);
	}
	public void TestKontakKami() {
		clickAndWaitByXpath(kontakKami);
	}
}
