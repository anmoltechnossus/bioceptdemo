package biocept.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import biocept.qa.base.BioceptBase;
import biocept.qa.utill.ExplicitWait;

public class MolecularReviewAndApproveWorklist extends BioceptBase {
	ExplicitWait explicitWait = new ExplicitWait();

	@FindBy(className = "fa-check")
	WebElement review;

	@FindBy(css = "button[data-bind*='SignOff']")
	WebElement signOff;

	@FindBy(xpath = "//*[@id='panel-default']/div[1]/strong")
	WebElement reportPreview;

	public MolecularReviewAndApproveWorklist() {
		PageFactory.initElements(Driver(), this);
	}

	public void reportSignoff() {
		explicitWait.invisibilityOfLoader();
		try {
			explicitWait.waitUntilElementToBeVisible(reportPreview);
			explicitWait.waitUntilElementToBeVisible(review);
			explicitWait.waitUntilElementToBeClickable(review);
			JavascriptExecutor js = (JavascriptExecutor) Driver();
			js.executeScript("arguments[0].click();", review);
			explicitWait.waitUntilElementToBeClickable(signOff).click();

		} catch (Exception e) {

			explicitWait.waitUntilElementToBeVisible(reportPreview);
			explicitWait.waitUntilElementToBeVisible(review);
			explicitWait.waitUntilElementToBeClickable(review);
			JavascriptExecutor js = (JavascriptExecutor) Driver();
			js.executeScript("arguments[0].click();", review);
			explicitWait.waitUntilElementToBeClickable(signOff).click();
		}
	}

}
