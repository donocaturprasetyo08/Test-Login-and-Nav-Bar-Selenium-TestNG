package qaautomation.evermos;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import qaautomation.evermos.navigation.CommonPage;
import qaautomation.evermos.pages.DaftarEverMos;
import qaautomation.evermos.pages.HomePageNavBar;
import qaautomation.evermos.pages.Login;
import qaautomation.evermos.utils.FakerData;
//import qaautomation.evermos.utils.OtpSMSReceive;
//import qaautomation.evermos.utils.OtpTwilio;
//import qaautomation.evermos.utils.Otp;
import qaautomation.evermos.utils.Utils;

/**
 * Unit test for simple App.
 */
public class AppTest extends BaseWebDriver
{
    /**
     * Rigorous Test :-)
     */
	
	HomePageNavBar homePageNavBar = new HomePageNavBar(driver, explicitWait);
	CommonPage commonPage = new CommonPage(driver, explicitWait);
	DaftarEverMos daftarEverMos = new DaftarEverMos(driver, explicitWait);
	//OtpTwilio sms = new OtpTwilio();
	//OtpSMSReceive sms = new OtpSMSReceive();
	//private final String fromPhoneNumber = "18572279";
	Login loginPage = new Login(driver, explicitWait);
	
	
	 @Test(testName = "Nav Menu Tentang Kami", description = "Nav Menu Tentang Kami is working")
	    public void testNavMenuTentangKami()
	    {
		 homePageNavBar.TestTentangKami();
	     Utils.hardWait(2);
	     commonPage.switchWindow(1);
	     
	     //Test Url Redirect Page
	     String expectedUrl="https://evermos.com/about";
	     String actualUrl= driver.get().getCurrentUrl();
	     Assert.assertEquals(actualUrl, expectedUrl);
	     
	     //Test Title Redirect Page
	     String expectedTitle = "Tentang Evermos: Ketahui Lebih Banyak Tentang Kami";
	     String actualTitle = driver.get().getTitle();
	     Assert.assertEquals(actualTitle, expectedTitle);
	     
	    }
	 
	 @Test(testName = "Nav Menu Panduan Reseller", description = "Nav Menu Panduan Reseller is working")
	    public void testNavMenuPanduanReseller()
	    {
		 homePageNavBar.TestPanduanReseller();
	     Utils.hardWait(2);
	     commonPage.switchWindow(1);
	     
	     //Test Url Redirect Page
	     String expectedUrl="https://evermos.com/home/panduan/";
	     String actualUrl= driver.get().getCurrentUrl();
	     Assert.assertEquals(actualUrl, expectedUrl);
	     
	     //Test Title Redirect Page
	     String expectedTitle = "Panduan Reseller - Evermos: Platform Social Commerce Produk Muslim Indonesia";
	     String actualTitle = driver.get().getTitle();
	     Assert.assertEquals(actualTitle, expectedTitle);
	    }
	 
	 @Test(testName = "Nav Menu Promo", description = "Nav Menu Promo is working")
	    public void testNavMenuPromo()
	    {
		 homePageNavBar.TestPromo();
	     Utils.hardWait(2);
	     commonPage.switchWindow(1);
	     
	     //Test Url Redirect Page
	     String expectedUrl="https://evermos.com/home/promo/";
	     String actualUrl= driver.get().getCurrentUrl();
	     Assert.assertEquals(actualUrl, expectedUrl);
	     
	     //Test Title Redirect Page
	     String expectedTitle = "Promo Evermos Terbaru Bulan Ini di Tahun 2021";
	     String actualTitle = driver.get().getTitle();
	     Assert.assertEquals(actualTitle, expectedTitle);
	    }
	 
	 @Test(testName = "Nav Menu Galeri Produk", description = "Nav Menu Galeri Produk is working")
	    public void testNavMenuGaleriProduk()
	    {
		 homePageNavBar.TestGaleriProduk();
	     Utils.hardWait(2);
	     commonPage.switchWindow(1);
	     
	     //Test Url Redirect Page
	     String expectedUrl="https://evermos.com/contoh-produk/";
	     String actualUrl= driver.get().getCurrentUrl();
	     Assert.assertEquals(actualUrl, expectedUrl);
	     
	     //Test Title Redirect Page
	     String expectedTitle = "Evermos: Katalog dan Contoh Produk untuk Reseller dan Dropship";
	     String actualTitle = driver.get().getTitle();
	     Assert.assertEquals(actualTitle, expectedTitle);
	    }
	 
	 @Test(testName = "Nav Menu Kontak Kami", description = "Nav Menu Kontak Kami is working")
	    public void testNavMenuKontakKami()
	    {
		 homePageNavBar.TestKontakKami();
	     Utils.hardWait(2);
	     commonPage.switchWindow(1);
	     
	     //Test Url Redirect Page
	     String expectedUrl="https://evermos.com/contact";
	     String actualUrl= driver.get().getCurrentUrl();
	     Assert.assertEquals(actualUrl, expectedUrl);
	     
	     //Test Title Redirect Page
	     String expectedTitle = "Kontak kami: Untuk segala pertanyaan Anda terkait dengan Evermos";
	     String actualTitle = driver.get().getTitle();
	     Assert.assertEquals(actualTitle, expectedTitle);
	    }
	 
	 @Test(testName = "Test Daftar Akun EverMos", description = "Daftar Akun EverMos is working")
	    public void testDaftarAkun() throws IOException
	    {
//		 String nomorHP = sms.getNumber();
//		 System.out.println(nomorHP);
		 String nomorHP = "8783484721";
		 String nama = FakerData.fullname;
		 String password = "123qwer!";
		 String domisili = "bantul";
		// String otp = Otp.otpInit();
		 daftarEverMos.DaftarAkun(nomorHP, nama, password, domisili);
		 Utils.hardWait(5);
//		 sms.smsReader();
//		 String smsBody = sms.getMessage();
//		 System.out.println(smsBody);
//		 String otp = smsBody.replaceAll("[^-?0-9]+", " ");
//		 String code = sms.getMessage(nomorHP, fromPhoneNumber);
//		 String otp = code.replaceAll("[^-?0-9]+", " ");
//		 System.out.println(otp);
//		 daftarEverMos.OtpInput(otp);
		 
	    }
	 
	 @Test(testName = "Login Page", description = "Test Page Login and Test Login is working, with positif case")
	    public void testLoginPage()
	    {
		 loginPage.TestPageLogin();
	     Utils.hardWait(2);
	     
	     //Test Url Redirect Page
	     String expectedUrl="https://evermos.com/login";
	     String actualUrl= driver.get().getCurrentUrl();
	     Assert.assertEquals(actualUrl, expectedUrl);
	     
	     //Test Title Redirect Page
	     String expectedTitle = "Masuk Sebagai Reseller Evermos";
	     String actualTitle = driver.get().getTitle();
	     Assert.assertEquals(actualTitle, expectedTitle);
	     
	     String nomor = "08991034810";
	     String password = "@!123qwert";
	     
	     loginPage.TestLogin(nomor, password);
	     Utils.hardWait(2);
	     //Test Url Redirect Page
	     String expectedUrl1="https://evermos.com/catalog";
	     String actualUrl1= driver.get().getCurrentUrl();
	     Assert.assertEquals(actualUrl1, expectedUrl1);
	     
	     //Test Title Redirect Page
	     String expectedTitle1 = "Evermos - Katalog";
	     String actualTitle1 = driver.get().getTitle();
	     Assert.assertEquals(actualTitle1, expectedTitle1);
	     
	    }
}
