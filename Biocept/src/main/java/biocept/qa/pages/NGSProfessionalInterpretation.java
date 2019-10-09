package biocept.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import biocept.qa.base.BioceptBase;
import biocept.qa.utill.ExplicitWait;

public class NGSProfessionalInterpretation extends BioceptBase {
	ExplicitWait explicitWait = new ExplicitWait();

	@FindBy(css = "input[accept='.pdf']")
	WebElement addFileButtonElement;

	@FindBy(css = "input[value='Save']")
	WebElement saveButtonElement;

	@FindBy(css = "input[value='Complete']")
	WebElement completeButtonElement;

	@FindBy(className = "progress-bar-success")
	WebElement progress_bar_success;

	@FindBy(xpath = "//*[@id='panel-default']/div[1]/strong")
	WebElement reportPreviewElement;

	public NGSProfessionalInterpretation() {
		PageFactory.initElements(Driver(), this);
	}

	public void uploadFile() {
		explicitWait.waitUntilElementToBeVisible(reportPreviewElement);
		addFileButtonElement.sendKeys(System.getProperty("user.dir") + "/src/main/java/biocept/qa/testdata/sample.pdf");
		explicitWait.waitUntilElementToBeInvisible(progress_bar_success);

	}

	public void clickOnSaveButon() {
		explicitWait.waitUntilElementToBeClickable(saveButtonElement).click();

	}

	public void clickOnCompleteButon() {

		((JavascriptExecutor) Driver()).executeScript("window.scrollTo(0, document.body.scrollHeight)");
		explicitWait.waitUntilElementToBeClickable(completeButtonElement).click();

	}

}
