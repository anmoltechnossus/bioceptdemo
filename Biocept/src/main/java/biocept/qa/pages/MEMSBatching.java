package biocept.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import biocept.qa.base.BioceptBase;
import biocept.qa.utill.ExplicitWait;

public class MEMSBatching extends BioceptBase {
	ExplicitWait explicitWait = new ExplicitWait();

	@FindBy(css = "input[data-bind*='value: ComponentValue']")
	WebElement memsInitials;

	public MEMSBatching() {
		PageFactory.initElements(Driver(), this);
	}

	public void memsInitials() {
		explicitWait.waitUntilElementToBeVisible(memsInitials).sendKeys(prop.getProperty("username"));

	}
}
