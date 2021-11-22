package stepDefinitions;

	
import java.util.List;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.junit.Assert;
import org.openqa.selenium.By;

import com.aventstack.extentreports.GherkinKeyword;

import Base.BaseUtils;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;

public class LoginStepDefs extends BaseUtils{
	
	//private BaseUtils base;	
	LoginPage page;
	
//	public LoginStepDefs(BaseUtils base)
//	{
//		this.base = base;
//	}
	
	@Then("^User opens the OrangeHRM website$")
	public void user_opens_the_OrangeHRM_website() throws Throwable {
	    scenarioDef.createNode(new GherkinKeyword("Then"), "User opens the OrangeHRM website");
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/");
	}

	@When("^User provides his \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_provides_his_and(String username, String password) throws Throwable {
		scenarioDef.createNode(new GherkinKeyword("When"), "User provides his \"<UserID>\" and \"<Password>\"");
		page = new LoginPage(driver);
		page.Login(username, password);
	}

	@Then("^User should logs into the website$")
	public void user_should_logs_into_the_website() throws Throwable {
		scenarioDef.createNode(new GherkinKeyword("Then"), "User should logs into the website");
		page = new LoginPage(driver);
		page.clickLogin();
	}
	@Then("^User verifies the landing page$")
	public void user_verifies_the_landing_page() throws Throwable {
		scenarioDef.createNode(new GherkinKeyword("Then"), "User verifies the landing page");
		String DashHDR = "//div[@class='head']";
		System.out.println("Page title is :"+driver.getTitle());
		Assert.assertTrue("Not landed in dashboard", driver.findElement(By.xpath(DashHDR)).isDisplayed());
		System.out.println("Landed into dashboard");
		Assert.assertEquals(driver.getTitle(), "OrangeHRM");
	    
	}
	@Then("^User provides his credentails in Datatable format$")
	public void loginUsingDatatable(DataTable table) throws Throwable {
		scenarioDef.createNode(new GherkinKeyword("Then"), "User provides his credentails in Datatable format");
		page = new LoginPage(driver);
		List<List<String>> data = table.asLists();
		String username = data.get(1).get(0).toString();
		String password = data.get(1).get(1).toString();
		page.Login(username, password);
	}
}
