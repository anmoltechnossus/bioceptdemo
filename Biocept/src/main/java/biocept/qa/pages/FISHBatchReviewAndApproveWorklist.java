package biocept.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import biocept.qa.base.BioceptBase;
import biocept.qa.utill.ExplicitWait;

public class FISHBatchReviewAndApproveWorklist extends BioceptBase {
	ExplicitWait explicitWait = new ExplicitWait();

	@FindBy(css = "input[type='search']")
	WebElement searchElement;

	@FindBy(id = "ReviewChkBox")
	WebElement reviewChkBox;

	@FindBy(id = "btn-Save")
	WebElement signOffAll;

	public FISHBatchReviewAndApproveWorklist() {
		PageFactory.initElements(Driver(), this);
	}

	public void search(String AccessionID) throws InterruptedException {
		explicitWait.waitUntilElementToBeVisible(searchElement).sendKeys(AccessionID);
		Thread.sleep(2000);

	}

	public void reportSignoff() {
		explicitWait.waitUntilElementToBeClickable(reviewChkBox).click();
		explicitWait.waitUntilElementToBeClickable(signOffAll).click();

	}

}
