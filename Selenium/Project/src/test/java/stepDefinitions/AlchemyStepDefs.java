package stepDefinitions;

import Base.BaseUtils;
import com.aventstack.extentreports.GherkinKeyword;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.AlchemyJobsPage;

public class AlchemyStepDefs extends BaseUtils {

    AlchemyJobsPage alchemyJobsPage;

    @Given("User opens the Alchemy website")
    public void userOpensTheAlchemyWebsite() throws ClassNotFoundException {
//        scenarioDef.createNode(new GherkinKeyword("Given"), "User opens the Alchemy website");
        driver.navigate().to("https://alchemy.hguy.co/jobs/");
    }

    @And("User verifies the title {string} of the Website")
    public void userVerifiesTheTitleOfTheWebsite(String expTitle) throws ClassNotFoundException {
//        scenarioDef.createNode(new GherkinKeyword("And"), "User verifies the title of the Website");
        String actualWebsiteTitle = driver.getTitle();
        System.out.println("Website title is: "+actualWebsiteTitle);
        Assert.assertEquals(expTitle, actualWebsiteTitle);
    }

    @And("User verifies the heading {string} of the Website")
    public void userVerifiesTheHeadingOfTheWebsite(String expHeading) throws ClassNotFoundException {
//        scenarioDef.createNode(new GherkinKeyword("And"), "User verifies the heading of the Website");
        alchemyJobsPage = new AlchemyJobsPage(driver);
        String ActualWebsiteHeading = alchemyJobsPage.websiteHeading.getText();
        System.out.println("Website heading is: "+ActualWebsiteHeading);
        Assert.assertEquals(expHeading, ActualWebsiteHeading);
    }

    @And("User gets the URL of the header image")
    public void userGetsTheURLOfTheHeaderImage() throws ClassNotFoundException {
//        scenarioDef.createNode(new GherkinKeyword("And"), "User gets the URL of the header image");
        alchemyJobsPage = new AlchemyJobsPage(driver);
        String URLHeaderImg = alchemyJobsPage.headerImage.getAttribute("src");
        System.out.println("URL of yhe header image is: "+URLHeaderImg);
    }

    @And("User verifies the second heading {string} of the Website")
    public void userVerifiesTheSecondHeadingOfTheWebsite(String expHeading) throws ClassNotFoundException {
//        scenarioDef.createNode(new GherkinKeyword("And"), "User verifies the second heading of the Website");
        alchemyJobsPage = new AlchemyJobsPage(driver);
        String ActualWebsiteHeading = alchemyJobsPage.websiteSecondHeading.getText();
        System.out.println("Website's second heading is: "+ActualWebsiteHeading);
        Assert.assertEquals(expHeading, ActualWebsiteHeading);
    }

    @Then("User navigates to the job page")
    public void userNavigatesToTheJobPage() throws ClassNotFoundException {
//        scenarioDef.createNode(new GherkinKeyword("And"), "User navigates to the job page");
        alchemyJobsPage = new AlchemyJobsPage(driver);
        alchemyJobsPage.menuItemJob.click();
    }

    @And("User verifies the title {string} of the Job page")
    public void userVerifiesTheTitleOfTheJobPage(String expTitle) throws ClassNotFoundException {
//        scenarioDef.createNode(new GherkinKeyword("And"), "User verifies the second heading of the Website");
        alchemyJobsPage = new AlchemyJobsPage(driver);
        String actualTitle = driver.getTitle();
        System.out.println("Title of Job page is: "+actualTitle);
        Assert.assertEquals(expTitle, actualTitle);
    }

    @Then("User search for the job with keyword {string}")
    public void userSearchForTheJobWithKeyword(String searchKeyWord) throws ClassNotFoundException, InterruptedException {
//        scenarioDef.createNode(new GherkinKeyword("Then"), "User search for the job with keyword");
        alchemyJobsPage = new AlchemyJobsPage(driver);
        alchemyJobsPage.jobSearchBox.sendKeys(searchKeyWord);
        Thread.sleep(2000);
        alchemyJobsPage.jobSearchBtn.click();
        Thread.sleep(2000);
    }

    @And("User opens one of the job listed")
    public void userOpensOneOfTheJobListed() throws ClassNotFoundException, InterruptedException {
//        scenarioDef.createNode(new GherkinKeyword("And"), "User opens one of the job listed");
        alchemyJobsPage = new AlchemyJobsPage(driver);
        alchemyJobsPage.openJobFromListing.click();
        Thread.sleep(2000);
    }

    @When("User applies for that opened job")
    public void userAppliesForThatOpenedJob() throws ClassNotFoundException, InterruptedException {
//        scenarioDef.createNode(new GherkinKeyword("When"), "User applies for that opened job");
        alchemyJobsPage = new AlchemyJobsPage(driver);
//        alchemyJobsPage.explicitlyWait(alchemyJobsPage.applyJobBtn);
        alchemyJobsPage.applyJobBtn.click();
        Thread.sleep(2000);
    }

    @Then("User prints the email to the console")
    public void userPrintsTheEmailToTheConsole() throws ClassNotFoundException {
//        scenarioDef.createNode(new GherkinKeyword("Then"), "User prints the email to the console");
        alchemyJobsPage = new AlchemyJobsPage(driver);
        String emailText = alchemyJobsPage.getEmailText.getText();
        System.out.println("The email to send details is: "+emailText);
    }

    @Then("User navigates to the Post job page")
    public void userNavigatesToThePostJobPage() throws ClassNotFoundException, InterruptedException {
//        scenarioDef.createNode(new GherkinKeyword("And"), "User navigates to the job page");
        alchemyJobsPage = new AlchemyJobsPage(driver);
        alchemyJobsPage.menuItemPostJob.click();
        Thread.sleep(2000);
    }

    @And("User needs to sign in with {string} and {string}")
    public void userNeedsToSignInWithAnd(String username, String pwd) throws ClassNotFoundException, InterruptedException {
//        scenarioDef.createNode(new GherkinKeyword("And"), "User navigates to the job page");
        alchemyJobsPage = new AlchemyJobsPage(driver);
        alchemyJobsPage.accountSignInBtn.click();
        Thread.sleep(2000);

        alchemyJobsPage.usernameTxtbox.sendKeys(username);
        alchemyJobsPage.passwordTxtbox.sendKeys(pwd);
        alchemyJobsPage.loginBtn.click();
        Thread.sleep(2000);
    }

    @And("User fills up JobPosting form with {string} {string} and {string}")
    public void userFillsUpJobPostingFormWithAnd(String JobTitle, String Location, String Description) throws ClassNotFoundException, InterruptedException {
//        scenarioDef.createNode(new GherkinKeyword("And"), "User navigates to the job page");
        alchemyJobsPage = new AlchemyJobsPage(driver);
        alchemyJobsPage.explicitlyWait(alchemyJobsPage.signOutBtn);

        alchemyJobsPage.jobTitleTextBox.sendKeys(JobTitle);
        alchemyJobsPage.jobLocationTextBox.sendKeys(Location);
        alchemyJobsPage.jobDescTextBox.click();
        alchemyJobsPage.jobDescTextBox.sendKeys(Description);
        Thread.sleep(3000);

        alchemyJobsPage.jobPreviewBtn.click();
        Thread.sleep(3000);
    }

    @Then("User clicks on Submit Listing button")
    public void userClicksOnSubmitListingButton() throws ClassNotFoundException, InterruptedException {
//        scenarioDef.createNode(new GherkinKeyword("And"), "User navigates to the job page");
        alchemyJobsPage = new AlchemyJobsPage(driver);
        alchemyJobsPage.submitListingBtn.click();
        Thread.sleep(3000);
    }

    @And("User verifies that Job listing with {string} and {string} has been listed successfully")
    public void userVerifiesThatJobListingWithAndHasBeenListedSuccessfully(String expJobTitle, String expJobDesc) throws ClassNotFoundException, InterruptedException {
//        scenarioDef.createNode(new GherkinKeyword("And"), "User navigates to the job page");
        alchemyJobsPage = new AlchemyJobsPage(driver);
        if(!alchemyJobsPage.verifyListingText.isDisplayed())
        {
            Assert.fail("Job not listed successfully");
        }
        alchemyJobsPage.checkListingBtn.click();
        Thread.sleep(3000);

        String ActualListedJobTitle = alchemyJobsPage.checkListedJobTitle.getText();
        System.out.println("Listed job title is: "+ActualListedJobTitle);
        Assert.assertEquals(expJobTitle, ActualListedJobTitle);

        String ActualListedJobDesc = alchemyJobsPage.checkListedJobDesc.getText();
        System.out.println("Listed job description is: "+ActualListedJobDesc);
        Assert.assertEquals(expJobDesc, ActualListedJobDesc);
    }

    @Given("User opens the Alchemy website backend")
    public void userOpensTheAlchemyWebsiteBackend() throws ClassNotFoundException {
//        scenarioDef.createNode(new GherkinKeyword("Given"), "User opens the Alchemy website");
        driver.navigate().to("https://alchemy.hguy.co/jobs/wp-admin");
    }

    @And("User signs in with admin {string} and {string}")
    public void userSignsInWithAdminAnd(String username, String pwd) throws ClassNotFoundException, InterruptedException {
//        scenarioDef.createNode(new GherkinKeyword("Given"), "User opens the Alchemy website");
        alchemyJobsPage = new AlchemyJobsPage(driver);
        Thread.sleep(2000);

        alchemyJobsPage.usernameTxtbox.sendKeys(username);
        alchemyJobsPage.passwordTxtbox.sendKeys(pwd);
        alchemyJobsPage.loginBtn.click();
        Thread.sleep(2000);
    }

    @Then("User clicks on Job Listings from menu item and clicks on Add new")
    public void userClicksOnJobListingsFromMenuItemAndClicksOnAddNew() throws ClassNotFoundException, InterruptedException {
//        scenarioDef.createNode(new GherkinKeyword("Given"), "User opens the Alchemy website");
        alchemyJobsPage = new AlchemyJobsPage(driver);
        Thread.sleep(2000);

        alchemyJobsPage.jobListingBtn.click();
        Thread.sleep(2000);
        alchemyJobsPage.jobListingAddNewBtn.click();
        Thread.sleep(2000);
        alchemyJobsPage.wordPressPopupCloseBtn.click();
    }

    @And("we scroll down through the web page to fill job data")
    public void weScrollDownThroughTheWebPageToFillJobData() throws ClassNotFoundException, InterruptedException {
//        scenarioDef.createNode(new GherkinKeyword("Given"), "User opens the Alchemy website");
        alchemyJobsPage = new AlchemyJobsPage(driver);
        Thread.sleep(2000);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement Element = alchemyJobsPage.addJobLocationTextBox;
        //This will scroll the page till the element is found
        js.executeScript("arguments[0].scrollIntoView();", Element);
        Thread.sleep(2000);
    }

    @And("User filled up the title {string} of the job listing")
    public void userFilledUpTheTitleOfTheJobListing(String JobTitle) throws InterruptedException {
        alchemyJobsPage = new AlchemyJobsPage(driver);
        Thread.sleep(2000);
        alchemyJobsPage.addJobListingTitle.click();
        alchemyJobsPage.addJobListingTitle.sendKeys(JobTitle);
    }

    @Then("we filled up the job listing with data {string} , {string}, {string}")
    public void weFilledUpTheJobListingWithData(String Location, String CompanyName, String CompanyWebsite) throws InterruptedException {
        alchemyJobsPage = new AlchemyJobsPage(driver);
        Thread.sleep(2000);

        alchemyJobsPage.addJobListingLocation.click();
        alchemyJobsPage.addJobListingLocation.sendKeys(Location);
        Thread.sleep(1000);
        alchemyJobsPage.addJobListingCompanyName.click();
        alchemyJobsPage.addJobListingCompanyName.sendKeys(CompanyName);
        Thread.sleep(1000);
        alchemyJobsPage.addJobListingCompanyWebsite.click();
        alchemyJobsPage.addJobListingCompanyWebsite.sendKeys(CompanyWebsite);
    }

    @And("User clicks on the publish button followed by View Job")
    public void userClicksOnThePublishButtonFollowedByViewJob() throws InterruptedException {
        alchemyJobsPage = new AlchemyJobsPage(driver);
        Thread.sleep(2000);

        alchemyJobsPage.addJobListingPublishBtn.click();
        Thread.sleep(2000);
        alchemyJobsPage.addJobListingPublishBtn.click();

        Thread.sleep(2000);
        alchemyJobsPage.addJobListingViewJob.click();
    }

    @Then("User verifies that JobListing with title {string} is posted successfully")
    public void userVerifiesThatJobListingWithTitleIsPostedSuccessfully(String expJobTitle) throws InterruptedException {
        alchemyJobsPage = new AlchemyJobsPage(driver);
        Thread.sleep(2000);

        String ActualListedJobTitle = alchemyJobsPage.checkListedJobTitle.getText();
        System.out.println("Listed job title is: "+ActualListedJobTitle);
        Assert.assertEquals(expJobTitle, ActualListedJobTitle);
    }
}
