package biocept.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import biocept.qa.base.BioceptBase;
import biocept.qa.utill.ExplicitWait;

public class FISHReviewAndApproveWorklist extends BioceptBase {
	ExplicitWait explicitWait = new ExplicitWait();

	String message;

	@FindBy(id = "titleHeader")
	WebElement titleHeader;

	@FindBy(css = "input[type='search']")
	WebElement searchElement;

	@FindBy(xpath = "//*[@id='queueResults']/tbody/tr[1]/td[9]/a")
	WebElement testNameElement;

	@FindBy(tagName = "tbody")
	WebElement table;

	@FindBy(xpath = "//*[@id='panel-default']/div[1]/strong")
	WebElement reportPreviewElement;

	@FindBy(className = "fa-check")
	WebElement review;

	@FindBy(css = "button[data-bind*='SignOff']")
	WebElement signoff_Element;

	@FindBy(css = "h4[id='myModalLabel']")
	WebElement popUpMessageEle;

	@FindBy(css = "select[data-bind*='ReportVersionTypes()']")
	WebElement reportVersionEle;

	@FindBy(css = "textarea[placeholder='Enter a Reason...']")
	WebElement resonElement;

	@FindBy(css = "button[class='btn btn-primary']")
	WebElement saveButton;

	public FISHReviewAndApproveWorklist() {
		PageFactory.initElements(Driver(), this);
	}

	public void search(String AccessionID, String TestName) throws InterruptedException {
		explicitWait.waitUntilElementToBeVisible(searchElement).sendKeys(AccessionID);
		Thread.sleep(2000);
		explicitWait.invisibilityOfLoader();
		explicitWait.waitUntilElementToBeVisible(testNameElement).click();

	}

	public void reportSignoff() {
		explicitWait.invisibilityOfLoader();
		explicitWait.waitUntilElementToBeVisible(reportPreviewElement);
		explicitWait.waitUntilElementToBeVisible(review);
		explicitWait.waitUntilElementToBeClickable(review).click();
		explicitWait.waitUntilElementToBeVisible(signoff_Element).click();

	}

	public String reportVersionSelectionPopup() {

		explicitWait.waitUntilElementToBeVisible(popUpMessageEle);
		String message = popUpMessageEle.getText();
		return message;

	}

	public void reportVersionType(String Type) {
		try {
			Select version = new Select(reportVersionEle);
			version.selectByVisibleText(Type);
		} catch (Exception e) {
		}
	}

	public void reason(String Reason) {
		resonElement.sendKeys(Reason);
	}

	public void clickOnSaveChanges() {
		try {
			explicitWait.waitUntilElementToBeClickable(saveButton).click();
		} catch (Exception e) {
			explicitWait.waitUntilElementToBeClickable(saveButton).click();
		}
	}
	// public String distributionConfirmationMessage(){
	//
	// explicitWait.invisibilityOfLoader();
	// message=explicitWait.waitUntilElementToBeVisible(completeMessage).getText();
	// System.out.println("Message 1+++"+ message);
	// while(message!="Automated distribution has been triggered for this
	// Report"){
	// String message1 =
	// explicitWait.waitUntilElementToBeVisible(completeMessage).getText();
	// System.out.println("Message 2+++"+ message1);
	// message = message.replace(message1, message);
	// if(message1.contains("Automated distribution has been triggered for this
	// Report")){
	//
	// }
	// }
	// return message;
	//
	// }

	public void visibilityOfSearchTextBox() {
		try {
			explicitWait.waitUntilElementToBeVisible(searchElement);
		} catch (Exception e) {
			explicitWait.waitUntilElementToBeClickable(saveButton).click();
		}
	}
}
