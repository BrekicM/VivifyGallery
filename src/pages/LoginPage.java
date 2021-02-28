package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	WebDriver driver;
	WebElement emailField;
	WebElement passwordField;
	WebElement submitButton;
	WebElement loginButton;
	WebElement badCredentialsNotification;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getEmailField() {
		return driver.findElement(By.id("email"));
	}

	public WebElement getPasswordField() {
		return driver.findElement(By.id("password"));
	}

	public WebElement getSubmitButton() {
		return driver.findElement(By.cssSelector("button[type='submit']"));
	}
	
	public WebElement getLoginButton() {
		return driver.findElement(By.cssSelector("a[href='/login']"));
	}

	public WebElement getBadCredentialsNotification() {
		return driver.findElement(By.xpath("//p[contains(text(), 'Bad Credentials')]"));
	}

	public void clickOnEmailField() {
		getEmailField().click();
		getEmailField().clear();
	}
	
	public void clickOnPasswordField() {
		getPasswordField().click();
		getPasswordField().clear();
	}
	
	public void clickOnSubmitButton() {
		getSubmitButton().click();
	}
}
