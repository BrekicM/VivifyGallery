package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AllGalleriesPage {
	WebDriver driver;
	//WebElement allGalleriesLabel;
	WebElement logoutButton;
	WebElement createGalleryButton;
	WebElement cactusesGalleryTitle;
	WebElement cactusesGalleryTitleLowercase;
	WebElement myGalleriesButton;
	WebElement searchField;
	WebElement filterButton;
	
	public AllGalleriesPage(WebDriver driver) {
		this.driver = driver;
	}

	/*public WebElement getAllGalleriesLabel() {
		return driver.findElement(By.cssSelector("h1[class='title-style']"));
	}*/

	public WebElement getLogoutButton() {
		return driver.findElement(By.cssSelector("a[role='button ']"));
	}
	
	public WebElement getCreateGalleryButton() {
		return driver.findElement(By.cssSelector("a[href='/create']"));
	}
	
	public WebElement getCactusesGalleryTitle() {
		return driver.findElement(By.xpath("//a[contains(text(), 'Cactuses')]"));
	}

	public WebElement getCactusesGalleryTitleLowercase() {
		return driver.findElement(By.xpath("//a[contains(text(), 'cactuses')]"));
	}
	
	public WebElement getMyGalleriesButton() {
		return driver.findElement(By.cssSelector("a[href='/my-galleries']"));
	}

	public WebElement getSearchField() {
		return driver.findElement(By.className("form-control"));
	}

	public WebElement getFilterButton() {
		return driver.findElement(By.xpath("//button[contains(text(), 'Filter')]"));
	}

	public void clickOnLogoutButton() {
		getLogoutButton().click();
	}
	
	public void clickOnCreateGalleryButton() {
		getCreateGalleryButton().click();
	}
	
	public void clickOnMyGalleriesButton() {
		getMyGalleriesButton().click();
	}
	
	public void clickOnSearchField() {
		getSearchField().click();
		getSearchField().clear();
	}
	
	public void clickOnFilterButton() {
		getFilterButton().click();
	}
	
}
