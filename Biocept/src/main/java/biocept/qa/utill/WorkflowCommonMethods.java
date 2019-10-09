package biocept.qa.utill;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import biocept.qa.base.BioceptBase;

public class WorkflowCommonMethods extends BioceptBase {
	ExplicitWait explicitWait = new ExplicitWait();

	@FindBy(tagName = "h3")
	WebElement activityName;

	@FindBy(css = "input[placeholder='Date Time']")
	WebElement DateTime;

	@FindBy(css = "input[value='Complete']")
	WebElement ctcFishCompleteButtonElement;

	@FindBy(css = "span[data-notify='message']")
	WebElement completeMessage;

	@FindBy(id = "btn-Complete")
	WebElement molecularCompleteButton;

	@FindBy(id = "btn-Save")
	WebElement molecularSaveButton;

	String title;

	public WorkflowCommonMethods() {
		PageFactory.initElements(Driver(), this);
	}

	public String pageTitle() {
		try {
			explicitWait.invisibilityOfLoader();

			title = explicitWait.waitUntilElementToBeVisible(activityName).getText();

		} catch (Exception e) {
			explicitWait.invisibilityOfLoader();

			title = explicitWait.waitUntilElementToBeVisible(activityName).getText();
		}
		return title;

	}

	public void activityStartEndDateTime() {
		try {
			explicitWait.invisibilityOfLoader();
			explicitWait.waitUntilElementToBeClickable(DateTime).click();
			DateTime.sendKeys(Keys.TAB);
			DateTime.sendKeys(Keys.TAB);
		} catch (Exception e) {

		}

	}

	public void ctcFishCompleteButton() {
		explicitWait.invisibilityOfLoader();
		explicitWait.waitUntilElementToBeClickable(ctcFishCompleteButtonElement);
		jsClick(ctcFishCompleteButtonElement);

	}

	public void molecularCompleteButton() {
		explicitWait.invisibilityOfLoader();
		jsClick(molecularCompleteButton);
		// explicitWait.waitUntilElementToBeClickable(molecularCompleteButton).click();

	}

	public void molecularSaveButton() {
		explicitWait.invisibilityOfLoader();
		jsClick(molecularSaveButton);
		// explicitWait.waitUntilElementToBeClickable(molecularSaveButton).click();

	}

	public String completeMessage() {
		// explicitWait.invisibilityOfLoader();

		String message = explicitWait.waitUntilElementToBeVisible(completeMessage).getText();
		explicitWait.invisibilityOfLoader();
		return message;
	}

}
