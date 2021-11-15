package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using="//input[@name='txtUsername']")
	public WebElement txtUsername;
	
	@FindBy(how = How.XPATH, using="//input[@name='txtPassword']")
	public WebElement txtPassword;
	
	@FindBy(how = How.XPATH, using="//input[@name='Submit']")
	public WebElement btnLogin;
	
	public void Login(String username, String password) throws InterruptedException
	{
		Thread.sleep(3000);
		txtUsername.sendKeys(username);
		txtPassword.sendKeys(password);
	}
	
	public void clickLogin()
	{
		btnLogin.click();
	}
}
