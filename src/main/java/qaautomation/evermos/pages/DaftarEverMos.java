package qaautomation.evermos.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import qaautomation.evermos.navigation.BasePage;
import qaautomation.evermos.utils.Utils;

public class DaftarEverMos extends BasePage {
	
	By buttonDaftar = By.xpath("//input[@value='Daftar']");
	By dropdownTelpon = By.xpath("//span[@class='vti__dropdown-arrow']");
	By listCodeNegara = By.xpath("//strong[normalize-space()='United States']");
	By inputNomor = By.xpath("//input[@placeholder='812345678']");
	By inputNama = By.xpath("//input[@placeholder='Nama Kamu']");
	By inputPassword = By.xpath("//input[@placeholder='Tulis Kata Sandi Kamu']");
	By klikDomisili = By.xpath("//a[@class='registration__block']");
	By inputDomisili = By.xpath("//input[@placeholder='Isi nama kecamatan']");
	By klikInputDomisili = By.xpath("//span[@class='list__label']");
	By checkBox = By.xpath("//div[@class='tnc__checkbox']//input[@type='checkbox']");
	By buttonPendaftaran = By.xpath("//button[normalize-space()='Lanjutkan Pendaftaran']");
	By buttonOTPmsg = By.xpath("//div[contains(text(),'Verifikasi Melalui SMS')]");
	By okOTPmsg = By.xpath("//button[normalize-space()='OK']");
	By inputOTP = By.xpath("//input[1]");
	By buttonVerifikasi = By.xpath("//button[normalize-space()='Verifikasi']");
	
	public DaftarEverMos(ThreadLocal<WebDriver> driver, ThreadLocal<WebDriverWait> explicitWait) {
		super(driver, explicitWait);
		// TODO Auto-generated constructor stub
	}

	public void DaftarAkun(String nomorHP, String nama, String password, String domisili) {
		clickAndWaitByXpath(buttonDaftar);
		clickAndWaitByXpath(dropdownTelpon);
		scrollUntilElement(listCodeNegara);
		Utils.hardWait(3);
		clickAndWaitByXpath(listCodeNegara);
		setText(inputNomor, nomorHP);
		setText(inputNama, nama);
		setText(inputPassword, password);
		clickAndWaitByModal(klikDomisili);
		Utils.hardWait(3);
		setText(inputDomisili, domisili);
		clickAndWaitByXpath(klikInputDomisili);
		selectCheckbox(checkBox);
		clickAndWaitByXpath(buttonPendaftaran);
		Utils.hardWait(3);
		scrollUntilElement(buttonOTPmsg);
		Utils.hardWait(3);
		clickAndWaitByModal(buttonOTPmsg);
		clickAndWaitByXpath(okOTPmsg);
		
	}
	public void OtpInput(String otp) {
		setText(inputOTP, otp);
		clickAndWaitByXpath(buttonVerifikasi);
	}
}
