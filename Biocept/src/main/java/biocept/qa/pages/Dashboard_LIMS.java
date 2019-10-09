package biocept.qa.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import biocept.qa.base.BioceptBase;
import biocept.qa.utill.ExplicitWait;

public class Dashboard_LIMS extends BioceptBase {
	ExplicitWait explicitWait = new ExplicitWait();
	int allLinkCount;

	@FindBy(css = "a[data-bind='text: CustomPageName, attr: { href: CustomUrl}']")
	public List<WebElement> allDashboardLink;

	public Dashboard_LIMS() {
		PageFactory.initElements(Driver(), this);
	}

	public int dashboardLinks() {
		allLinkCount = allDashboardLink.size();

		return allLinkCount;
	}

	public void clickOnPlaceNewOrder(String linkName) {
		boolean found = false;
		for (int i = 0; i < allDashboardLink.size(); i++) {

			WebElement link = allDashboardLink.get(i);
			String linktext = explicitWait.waitUntilElementToBeClickable(link).getText();

			if (linktext.contains(linkName)) {
				found = true;
				link.click();
			}
			if (found) {

				break;
			}
		}
	}

}
