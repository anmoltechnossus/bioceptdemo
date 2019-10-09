package biocept.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import biocept.qa.base.BioceptBase;
import biocept.qa.utill.ExplicitWait;

public class LoginAndLogOut extends BioceptBase {
	ExplicitWait explicitWait = new ExplicitWait();

	@FindBy(id = "username")
	WebElement username;

	@FindBy(id = "password")
	WebElement password;

	@FindBy(id = "btn-Login")
	WebElement loginButton;

	@FindBy(id = "logOut")
	WebElement logOutButton;

	@FindBy(id = "welcomename")
	WebElement welomename;

	@FindBy(id = "logout")
	WebElement logOutButton_Clientportal;

	public LoginAndLogOut() {
		PageFactory.initElements(Driver(), this);
	}

	public void LIMSlogin() {

		Driver().get(prop.getProperty("LIMSurl"));
		explicitWait.waitUntilElementToBeClickable(username).sendKeys(prop.getProperty("username"));
		password.sendKeys(prop.getProperty("password"));
		explicitWait.waitUntilElementToBeClickable(loginButton).click();
		log.debug("LIMS Login successfully executed");

	}

	public void LIMSLogOut() {
		try {
			explicitWait.waitUntilElementToBeVisible(logOutButton);
			explicitWait.waitUntilElementToBeClickable(logOutButton).click();
		} catch (Exception e) {
			explicitWait.waitUntilElementToBeVisible(logOutButton);
			explicitWait.waitUntilElementToBeClickable(logOutButton).click();
		}

	}

	public void ClientPortalLogin() {

		Driver().get(prop.getProperty("PhysicianPortal"));
		explicitWait.waitUntilElementToBeClickable(username).sendKeys(prop.getProperty("PhysicianUserName"));
		password.sendKeys(prop.getProperty("PhysicianPassword"));
		explicitWait.waitUntilElementToBeClickable(loginButton).click();

	}

	public void ClientPortalLogOut() {
		try {
			JavascriptExecutor executor = (JavascriptExecutor) Driver();
			executor.executeScript("arguments[0].click();", welomename);
			executor.executeScript("arguments[0].click();", logOutButton_Clientportal);
		} catch (Exception e) {
			JavascriptExecutor executor = (JavascriptExecutor) Driver();
			executor.executeScript("arguments[0].click();", welomename);
			executor.executeScript("arguments[0].click();", logOutButton_Clientportal);
		}

	}

	public String validateLoginPageTitle() {

		return Driver().getTitle();
	}

}
