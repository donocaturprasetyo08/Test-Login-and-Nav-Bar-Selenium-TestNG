package qaautomation.evermos;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseWebDriver implements DriverManager {
	ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	ThreadLocal<WebDriverWait> explicitWait = new ThreadLocal<WebDriverWait>();
	
	
	@BeforeMethod
	public void createChromeDriver() {
//		WebDriverManager.chromedriver().setup();
//		ChromeOptions options = new ChromeOptions();
//		options.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
//		driver.set(new ChromeDriver(options));
//		driver.get().get("https://evermos.com/home/");
//		driver.get().manage().window().maximize();
//		explicitWait.set(new WebDriverWait(driver.get(), Duration.ofSeconds(120)));
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
		driver.set(new ChromeDriver(options));
		driver.get().get("https://evermos.com/login");
		driver.get().manage().window().maximize();
		explicitWait.set(new WebDriverWait(driver.get(), Duration.ofSeconds(120)));
		driver.get().findElement(By.xpath("//input[@placeholder='Nomor Telepon Anda']")).sendKeys("6281223334444");
		driver.get().findElement(By.xpath("//input[@placeholder='Kata Sandi Anda']")).sendKeys("password");
		driver.get().findElement(By.xpath("//button[normalize-space()='Masuk']")).click();
	}

	@AfterMethod
	public void quitChromeDriver() {
		// TODO Auto-generated method stub
		driver.get().quit();
	}

}
