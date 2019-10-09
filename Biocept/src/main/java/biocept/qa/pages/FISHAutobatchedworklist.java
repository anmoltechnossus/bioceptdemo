package biocept.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import biocept.qa.base.BioceptBase;
import biocept.qa.utill.ExplicitWait;

public class FISHAutobatchedworklist extends BioceptBase {
	ExplicitWait explicitWait = new ExplicitWait();

	@FindBy(css = "input[data-bind*='value: ComponentValue']")
	WebElement fishBatchInitials;
	@FindBy(css = "input[placeholder='Date Time']")
	WebElement fishAutobatchStartEndDateTime;

	public FISHAutobatchedworklist() {
		PageFactory.initElements(Driver(), this);
	}

	public void fishAutobatchInitials() {
		explicitWait.waitUntilElementToBeVisible(fishBatchInitials).sendKeys(prop.getProperty("username"));

	}

}
