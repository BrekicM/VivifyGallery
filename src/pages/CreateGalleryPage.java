package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CreateGalleryPage {
	WebDriver driver;
	WebElement titleField;
	WebElement descriptionField;
	WebElement imageLinkField;
	WebElement addImageButton;
	WebElement submitButton;
	WebElement cancelButton;
	
	public CreateGalleryPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getTitleField() {
		return driver.findElement(By.id("title"));
	}

	public WebElement getDescriptionField() {
		return driver.findElement(By.id("description"));
	}

	public WebElement getImageLinkField() {
		return driver.findElement(By.cssSelector("input[type='url']"));
	}

	public WebElement getAddImageButton() {
		return driver.findElement(By.xpath("//button[contains(text(), 'Add image')]"));
	}

	public WebElement getSubmitButton() {
		return driver.findElement(By.xpath("//button[contains(text(), 'Submit')]"));
	}

	public WebElement getCancelButton() {
		return driver.findElement(By.xpath("//button[contains(text(), 'Cancel')]"));
	}
	
	// list of fields for adding images
	List<WebElement> getListOfImageFields() {
		return driver.findElements(By.xpath("//input[@placeholder='image url']"));
	}
	
	// indexes for field selection
	public WebElement getImageFieldByIndex(int number) {
		return getListOfImageFields().get(number);
	}
	
	// add image url to selected field
	public void addUrlToImageField(int number, String imageUrl) {
		getImageFieldByIndex(number).sendKeys(imageUrl);
	}
	
	public void clickOnTitleField() {
		getTitleField().click();
		getTitleField().clear();
	}
	
	public void clickOnDescriptionField() {
		getDescriptionField().click();
		getDescriptionField().clear();
	}
	
	public void clickOnImageLinkField() {
		getImageLinkField().click();
		getImageLinkField().clear();
	}
	
	public void clickOnAddImageButton() {
		getAddImageButton().click();
	}
	
	public void clickOnSubmitButton() {
		getSubmitButton().click();
	}
	
	public void clickOnCancelButton() {
		getCancelButton().click();
	}
}
