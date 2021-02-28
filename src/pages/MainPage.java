package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {
	WebDriver driver;
	WebElement loginButton;
	
	public MainPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getLoginButton() {
		return driver.findElement(By.cssSelector("a[href='/login']"));
	}
	
	public void clickOnLoginButton() {
		getLoginButton().click();
	}
	
}
