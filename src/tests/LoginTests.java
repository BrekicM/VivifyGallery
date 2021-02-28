package tests;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{
	
	@BeforeMethod
	public void loadPage() {
		driver.navigate().to("https://gallery-app.vivifyideas.com/");
	}
	
	@Test
	public void invalidPasswordLoginAttempt() {
		pageLogin("markob@fakemail.com", "12345");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Assert.assertEquals(loginPage.getBadCredentialsNotification().getText(), "Bad Credentials");
	}
	
	@Test
	public void invalidEmailLoginAttempt() {
		pageLogin("m@m.com", "markob82");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Assert.assertEquals(loginPage.getBadCredentialsNotification().getText(), "Bad Credentials");
	}
	
	@Test
	public void noCredentialsLoginAttempt() {
		pageLogin("", "");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Assert.assertEquals(true, loginPage.getLoginButton().isDisplayed());
	}
	
	@Test
	public void invalidEmailAndPasswordLoginAttempt() {
		pageLogin("mb@mail.com", "654321");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Assert.assertEquals(true, loginPage.getLoginButton().isDisplayed());	
	}
}
