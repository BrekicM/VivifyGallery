package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AutomationScenario extends TestBase{
	
	@BeforeMethod
	public void loadPage() {
		driver.navigate().to("https://gallery-app.vivifyideas.com/");
	}
	
	@Test(priority = 5)
	public void login() {
		pageLogin("markob@fakemail.com", "markob82");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Assert.assertEquals(true, allGalleriesPage.getLogoutButton().isDisplayed());
	}
	
	@Test(priority = 10)
	public void createGallery() throws InterruptedException {
		allGalleriesPage.clickOnCreateGalleryButton();
		createGalleryPage.clickOnTitleField();
		createGalleryPage.getTitleField().sendKeys("Cactuses");
		createGalleryPage.clickOnDescriptionField();
		createGalleryPage.getDescriptionField().sendKeys("Everybody loves cactuses!");
		createGalleryPage.clickOnImageLinkField();
		createGalleryPage.getImageLinkField().sendKeys("https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/cactus-plant-pot-stand-1599155636.jpg?crop=1.00xw:0.753xh;0,0.108xh&resize=1200:*");
		createGalleryPage.clickOnSubmitButton();
		Thread.sleep(1000);		// i had to implement sleep else test fails and gallery is not created - implicit/explicit waits are not working
		
	}
	
	@Test(priority = 15)
	public void findGalleryOnMyGalleriesPage() {
		allGalleriesPage.clickOnMyGalleriesButton();
		// this assert also serves for the previous test step - it verifies that the gallery was successfully created
		Assert.assertEquals(allGalleriesPage.getCactusesGalleryTitle().getText(), "Cactuses");
	}
	
	@Test(priority = 20)
	public void logout() {
		allGalleriesPage.clickOnLogoutButton();
		wait.until(ExpectedConditions.visibilityOf(loginPage.getLoginButton()));
		Assert.assertEquals(true, loginPage.getLoginButton().isDisplayed());		
	}
}
