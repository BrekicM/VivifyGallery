package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import pages.AllGalleriesPage;
import pages.CreateGalleryPage;
import pages.LoginPage;
import pages.MainPage;
import pages.MyGalleriesPage;

public class TestBase {
	// utility
	WebDriver driver;
	WebDriverWait wait;
	ExcelReader excelReader;
	// pages
	MainPage mainPage;
	LoginPage loginPage;
	AllGalleriesPage allGalleriesPage;
	CreateGalleryPage createGalleryPage;
	MyGalleriesPage myGalleriesPage;
	
	public void pageLogin(String email, String password) {
		mainPage.clickOnLoginButton();
		loginPage.clickOnEmailField();
		loginPage.getEmailField().sendKeys(email);
		loginPage.clickOnPasswordField();
		loginPage.getPasswordField().sendKeys(password);
		loginPage.clickOnSubmitButton();
	}
	
	@BeforeClass
	public void beforeClass() throws IOException {
		System.setProperty("webdriver.chrome.driver", "driver-lib\\chromedriver.exe");
		this.driver = new ChromeDriver();
		this.wait = new WebDriverWait(driver, 5);
		this.excelReader = new ExcelReader("data/testdata.xlsx");
		this.mainPage = new MainPage(driver);
		this.loginPage = new LoginPage(driver);
		this.allGalleriesPage = new AllGalleriesPage(driver);
		this.createGalleryPage = new CreateGalleryPage(driver);
		this.myGalleriesPage = new MyGalleriesPage(driver);
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public void afterClass() {
		driver.close();
	}
}
