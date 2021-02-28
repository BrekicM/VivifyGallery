package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MultipleImageGalleryTest extends TestBase{
	
	@BeforeMethod
	public void loadPage() {
		driver.navigate().to("https://gallery-app.vivifyideas.com/");
	}
	
	@Test(priority = 5)
	public void createGalleryWithMultipleImagesAndDeleteIt() throws InterruptedException {
		pageLogin("markob@fakemail.com", "markob82");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		allGalleriesPage.clickOnCreateGalleryButton();
		createGalleryPage.clickOnTitleField();
		createGalleryPage.getTitleField().sendKeys(excelReader.getStringCellData("multiImageGallery", 2, 1));
		createGalleryPage.clickOnDescriptionField();
		createGalleryPage.getDescriptionField().sendKeys(excelReader.getStringCellData("multiImageGallery", 2, 2));
		for (int i = 0; i < 3; i++) {
			createGalleryPage.clickOnAddImageButton();
		}
		for (int i = 0; i < 4; i++) {
			createGalleryPage.addUrlToImageField(i, excelReader.getStringCellData("multiImageGallery", i + 2, 3));
		}
		createGalleryPage.clickOnSubmitButton();
		Thread.sleep(1000);		// test can break without sleep
		allGalleriesPage.clickOnMyGalleriesButton();
		Assert.assertEquals(allGalleriesPage.getCactusesGalleryTitleLowercase().getText(), "Multiple cactuses");
		// delete created gallery
		allGalleriesPage.getCactusesGalleryTitleLowercase().click();
		myGalleriesPage.clickOnDeleteGalleryButton();
		driver.switchTo().alert().accept();
		Thread.sleep(1000);		// test can break without sleep
		allGalleriesPage.clickOnMyGalleriesButton();
		Assert.assertEquals(myGalleriesPage.getNoGalleriesFoundNotification().getText(), "No galleries found");
	}
	
	@Test(priority = 10)
	public void logout() {
		allGalleriesPage.clickOnLogoutButton();
		wait.until(ExpectedConditions.visibilityOf(loginPage.getLoginButton()));
		Assert.assertEquals(true, loginPage.getLoginButton().isDisplayed());		
	}
}
