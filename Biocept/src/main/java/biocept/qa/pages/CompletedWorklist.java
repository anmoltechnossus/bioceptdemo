package biocept.qa.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import biocept.qa.base.BioceptBase;
import biocept.qa.utill.ExplicitWait;

public class CompletedWorklist extends BioceptBase {
	ExplicitWait explicitWait = new ExplicitWait();
	@FindBy(xpath = "//*[@id='dataTable_filter']/label/input")
	WebElement searchElement;

	@FindBy(css = "a[onclick*='CTC-FISH']")
	List<WebElement> testNumber;

	@FindBy(css = "a[href*='/Orders/Accession']")
	List<WebElement> assessionNumber;

	@FindBy(className = "bootbox-body")
	WebElement popUp;
	@FindBy(css = "button[class*='btn-success']")
	WebElement accecptButton;

	public CompletedWorklist() {
		PageFactory.initElements(Driver(), this);
	}

	public void search(String AccessionID, String TestName) throws InterruptedException {
		explicitWait.waitUntilElementToBeVisible(searchElement).sendKeys(AccessionID);
		// Thread.sleep(2000);
		explicitWait.invisibilityOfLoader();
		explicitWait.waitUntilAllElementToBeVisible(testNumber);
		for (int i = 0; i < testNumber.size(); i++) {
			WebElement testNumberElement = testNumber.get(i);
			String testName = testNumberElement.getText();
			if (testName.contains(TestName)) {
				explicitWait.waitUntilElementToBeClickable(testNumberElement).click();
				break;
			}
		}
	}

	public void clickOnAccessionNo(String AccessionID) throws InterruptedException {
		explicitWait.waitUntilElementToBeVisible(searchElement).sendKeys(AccessionID);
		// Thread.sleep(2000);
		explicitWait.invisibilityOfLoader();
		explicitWait.waitUntilAllElementToBeVisible(testNumber);
		for (int i = 0; i < assessionNumber.size(); i++) {
			WebElement accessionIdElement = assessionNumber.get(i);
			String ID = accessionIdElement.getText();
			if (ID.contains(AccessionID)) {
				explicitWait.waitUntilElementToBeClickable(accessionIdElement).click();
				break;
			}
		}
	}

	public String confirmationMessage() throws InterruptedException {
		String text = "Are you sure, you want to reopen this report? This will require a new report to be created and issued.";
		explicitWait.waitUntilTextToBePresentInElement(popUp, text);
		// Thread.sleep(1000);
		String message = explicitWait.waitUntilElementToBeVisible(popUp).getText();
		return message;
	}

	public void accecptConfirmation() {
		explicitWait.waitUntilElementToBeClickable(accecptButton).click();

	}

}
