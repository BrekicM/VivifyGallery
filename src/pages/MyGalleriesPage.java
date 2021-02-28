package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyGalleriesPage {
	WebDriver driver;
	WebElement cactusesGalleryTitle;
	WebElement deleteGalleryButton;
	WebElement editGalleryButton;
	WebElement commentField;
	WebElement submitButton;
	WebElement noGalleriesFoundNotification;
	
	public MyGalleriesPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getCactusesGalleryTitle() {
		return driver.findElement(By.xpath("//a[contains(text(), 'Cactuses')]"));
	}
	
	public WebElement getDeleteGalleryButton() {
		return driver.findElement(By.xpath("//button[contains(text(), 'Delete Gallery')]"));
	}

	public WebElement getNoGalleriesFoundNotification() {
		return driver.findElement(By.xpath("//h4[contains(text(), 'No galleries found')]"));
	}

	public void clickOnCactusesGalleryTitle() {
		getCactusesGalleryTitle().click();
	}
	
	public void clickOnDeleteGalleryButton() {
		getDeleteGalleryButton().click();
	}
}
