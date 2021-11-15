package pages;

import Base.BaseUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlchemyJobsPage extends BaseUtils {

    public AlchemyJobsPage(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.XPATH, using="//h1[@class=\"entry-title\"]")
    public WebElement websiteHeading;

    @FindBy(how = How.XPATH, using="//div[@class=\"post-thumb-img-content post-thumb\"]/img")
    public WebElement headerImage;

    @FindBy(how = How.XPATH, using="//h2")
    public WebElement websiteSecondHeading;

    @FindBy(how = How.XPATH, using="//li[@id=\"menu-item-24\"]")
    public WebElement menuItemJob;

    @FindBy(how = How.XPATH, using="//input[@id=\"search_keywords\"]")
    public WebElement jobSearchBox;

    @FindBy(how = How.XPATH, using="//div[@class=\"search_submit\"]")
    public WebElement jobSearchBtn;

    @FindBy(how = How.XPATH, using="//ul[@class=\"job_listings\"]/li[1]")
    public WebElement openJobFromListing;

    @FindBy(how = How.XPATH, using="//input[@class=\"application_button button\"]")
    public WebElement applyJobBtn;

    @FindBy(how = How.XPATH, using="//a[@class=\"job_application_email\"]")
    public WebElement getEmailText;

    @FindBy(how = How.XPATH, using="//li[@id=\"menu-item-26\"]")
    public WebElement menuItemPostJob;

    @FindBy(how = How.XPATH, using="//a[@class=\"button\"]")
    public WebElement accountSignInBtn;

    @FindBy(how = How.XPATH, using="//input[@id=\"user_login\"]")
    public WebElement usernameTxtbox;

    @FindBy(how = How.XPATH, using="//input[@id=\"user_pass\"]")
    public WebElement passwordTxtbox;

    @FindBy(how = How.XPATH, using="//input[@id=\"wp-submit\"]")
    public WebElement loginBtn;

    @FindBy(how = How.XPATH, using="//a[text()=\"Sign out\"]")
    public WebElement signOutBtn;

    @FindBy(how = How.XPATH, using="//input[@id=\"job_title\"]")
    public WebElement jobTitleTextBox;

    @FindBy(how = How.XPATH, using="//input[@id=\"job_location\"]")
    public WebElement jobLocationTextBox;

    @FindBy(how = How.XPATH, using="//iframe[@id=\"job_description_ifr\"]")
    public WebElement jobDescTextBox;

    @FindBy(how = How.XPATH, using="//input[@name=\"submit_job\"]")
    public WebElement jobPreviewBtn;

    @FindBy(how = How.XPATH, using="//input[@id=\"job_preview_submit_button\"]")
    public WebElement submitListingBtn;

    @FindBy(how = How.XPATH, using="//div[contains(text(),\"Job listed successfully\")]")
    public WebElement verifyListingText;

    @FindBy(how = How.XPATH, using="//a[text()=\"click here\"]")
    public WebElement checkListingBtn;

    @FindBy(how = How.XPATH, using="//h1[@class=\"entry-title\"]")
    public WebElement checkListedJobTitle;

    @FindBy(how = How.XPATH, using="//div[@class=\"job_description\"]")
    public WebElement checkListedJobDesc;

    @FindBy(how = How.XPATH, using="//div[text()=\"Job Listings\"]")
    public WebElement jobListingBtn;

    @FindBy(how = How.XPATH, using="//a[@class=\"page-title-action\" and text()=\"Add New\"]")
    public WebElement jobListingAddNewBtn;

    @FindBy(how = How.XPATH, using="//button[@aria-label=\"Close dialog\"]")
    public WebElement wordPressPopupCloseBtn;

    @FindBy(how = How.XPATH, using="//input[@id=\"_job_location\"]")
    public WebElement addJobLocationTextBox;

    public void explicitlyWait(WebElement ele)
    {
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.visibilityOf(ele));
    }
}
