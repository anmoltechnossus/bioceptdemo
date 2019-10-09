package biocept.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import biocept.qa.base.BioceptBase;
import biocept.qa.utill.ExplicitWait;

public class CellSepBatching extends BioceptBase {
	ExplicitWait explicitWait = new ExplicitWait();

	@FindBy(css = "input[data-bind*='value: ComponentValue']")
	WebElement cellSepInitials;

	public CellSepBatching() {
		PageFactory.initElements(Driver(), this);
	}

	public void cellSepInitials() {
		explicitWait.waitUntilElementToBeVisible(cellSepInitials).sendKeys(prop.getProperty("username"));

	}

}
