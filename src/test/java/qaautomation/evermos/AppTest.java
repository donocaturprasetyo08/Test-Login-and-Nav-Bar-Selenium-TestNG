package qaautomation.evermos;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import qaautomation.evermos.pages.HomeLogin;
import qaautomation.evermos.pages.SearchPage;
import qaautomation.evermos.utils.Utils;

/**
 * Unit test for simple App.
 */
public class AppTest extends BaseWebDriver
{
    /**
     * Rigorous Test :-)
     */
	HomeLogin homeLogin = new HomeLogin(driver, explicitWait);
	SearchPage searchPage = new SearchPage(driver, explicitWait);
	
	@Test(testName = "Get url dynamic toko", description = "salin link toko berhasil")
	public void getUrlDynamicToko() 
	    {
		 homeLogin.pageTokoSaya();;
	     Utils.hardWait(2);
	     //Test Url Halaman Toko Saya
	     String expectedUrl2="https://evermos.com/my-store";
	     String actualUrl2= driver.get().getCurrentUrl();
	     Assert.assertEquals(actualUrl2, expectedUrl2);
	     //Test Title Halaman Toko Saya
	     String expectedTitle2 = "Toko Saya";
	     String actualTitle2 = homeLogin.getTitleTokoSayaPage();
	     Assert.assertEquals(actualTitle2, expectedTitle2);
	     
	     homeLogin.getLinkTautan();
	     Utils.hardWait(5);
	     Toolkit toolkit = Toolkit.getDefaultToolkit();
	     Clipboard clipboard = toolkit.getSystemClipboard();
	     String actualCopedText="";
	     try {
			actualCopedText = (String) clipboard.getData(DataFlavor.stringFlavor);
	     } catch (UnsupportedFlavorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	     } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	     }
	     //Test Link Toko
	     String expectedUrl3 = "https://berikhtiar.com/qa.candida.f22";
	     Assert.assertEquals(actualCopedText, expectedUrl3);
	     System.out.println("Link Toko: " + actualCopedText);
	     Utils.hardWait(2);
	}
	 
	 @Test(testName = "Page Category", description = "Category Page is working")
	 public void testCategoryPage() {
		 homeLogin.pageCategory();
		 Utils.hardWait(2);
		 //Test Url Halaman Kategori
	     String expectedUrl="https://evermos.com/category";
	     String actualUrl= driver.get().getCurrentUrl();
	     Assert.assertEquals(actualUrl, expectedUrl);
	     //Test Title Halaman Kategori 
	     String expectedTitle = "Kategori";
	     String actualTitle = homeLogin.getTitleCategoryPage();
	     Assert.assertEquals(actualTitle, expectedTitle);
	 }

	 @Test(testName = "Page Transaksi", description = "Transaction Page is working")
	 public void testTransaksiPage() {
		 homeLogin.pageTransaksi();;
		 Utils.hardWait(2);
		 //Test Url Halaman Transaksi
	     String expectedUrl="https://evermos.com/transaction";
	     String actualUrl= driver.get().getCurrentUrl();
	     Assert.assertEquals(actualUrl, expectedUrl);
	     //Test Title Halaman Transaksi
	     String expectedTitle = "Transaksi";
	     String actualTitle = homeLogin.getTitleTransaksiPage();
	     Assert.assertEquals(actualTitle, expectedTitle);
	 }
	 
	 @Test(testName = "Page Akun", description = "Akun page is working")
	 public void testAkunPage() {
		 homeLogin.pageAkun();
		 Utils.hardWait(2);
		 //Test Url Halaman Akun
	     String expectedUrl="https://evermos.com/user";
	     String actualUrl= driver.get().getCurrentUrl();
	     Assert.assertEquals(actualUrl, expectedUrl);
	     //Test Title Halaman Akun
	     String expectedTitle = "Akun Saya";
	     String actualTitle = homeLogin.getTitleAkunPage();
	     Assert.assertEquals(actualTitle, expectedTitle);
	 }

	 @Test(testName = "Search product", description = "search product by keyword berhasil")
	 public void searchProduct() {
		 String inputKeyword ="seragam";
		 searchPage.searchKeyword(inputKeyword);
		 
		 List<WebElement> listData = searchPage.listSearch();
		 System.out.println(listData.size());
		 
		 for(int i = 0; i<listData.size();i++) {
				String temp = listData.get(i).getText();
				if ((temp.toLowerCase().contains(inputKeyword.toLowerCase()))){
					Assert.assertTrue(true, inputKeyword);
					System.out.println("Search is passed");
					System.out.println(temp);
				}else {
					Assert.assertTrue(false, inputKeyword);
					System.out.println("Search is failed");
		
				}
				
			}
	 }
}
