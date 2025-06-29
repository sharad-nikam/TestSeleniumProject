package pageobjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//div[@class='nav-line-1-container']/span")
	private WebElement signInButton;

	public LoginPage signInButton() {

		signInButton.click();

		return new LoginPage(driver);

	}

	@FindBy(xpath = "//span[@class='a-list-item']")
	private WebElement warningmsg;

	public String retrieveInvalidCredentailsWarningMessage()

	{
		return warningmsg.getText();
	}

	@FindBy(xpath = "//*[@id=\"ap_email_login\"]")
	WebElement username;
	@FindBy(xpath = "//*[@id=\"ap_password\"]")
	WebElement password;
	@FindBy(id = "signInSubmit")
	WebElement button;
	@FindBy(id = "continue")
	WebElement continueButton;
	@FindBy(xpath = "//div[@role='alert']//div//div//ul//li//span")
	WebElement span;
	@FindBy(xpath = "//a[@id='nav-item-signout']")
	WebElement signout;

	public void set_username(String usern) {
		username.clear();
		username.sendKeys(usern);
	}

	public void set_password(String userp) {
		password.clear();
		password.sendKeys(userp);
	}

	public void continueButtonClick() {
		continueButton.submit();
	}

	public LoginPage click_button() {

		button.click();
		return new LoginPage(driver);
	}

	public boolean retrievevalidCredentails() {

		return false;
	}

	public void clickOncontinueButton() {
		continueButton.submit();

	}

	public void clickOnSignout() {

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].click();", signout);

	}

}
