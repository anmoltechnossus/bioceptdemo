package biocept.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import biocept.qa.base.BioceptBase;
import biocept.qa.utill.ExplicitWait;

public class LeftMenuItems extends BioceptBase {
	ExplicitWait explicitWait = new ExplicitWait();

	@FindBy(id = "expand")
	WebElement expandIcon;

	public LeftMenuItems() {

		PageFactory.initElements(Driver(), this);
	}

	public void leftMenuSelection(String Parent, String Child) throws InterruptedException {

		int attempts = 0;

		while (attempts < 4) {
			try {
				// JavascriptExecutor executor = (JavascriptExecutor) driver;
				// executor.executeScript("arguments[0].click();", expandIcon);
				explicitWait.waitUntilElementToBeClickable(expandIcon).click();
				WebElement ParentElement = Driver().findElement(By.linkText(Parent));
				explicitWait.waitUntilElementToBeVisible(ParentElement);
				explicitWait.waitUntilElementToBeClickable(ParentElement).click();
				Thread.sleep(1000);
				WebElement ChildElement = Driver().findElement(By.linkText(Child));
				String ChildElementValue = explicitWait.waitUntilElementToBeVisible(ChildElement).getText();
				if (ChildElementValue.equalsIgnoreCase(Child)) {
					explicitWait.waitUntilElementToBeClickable(ChildElement).click();
				} else {
					System.out.println("Incorrect element selected");
				}

				break;
			} catch (Exception e) {
				System.out.println("++++++Left Menu Exception++++++" + e);
			}
			attempts++;

		}
	}

	public void leftMenuSelectionForExpendedItem(String Child) throws InterruptedException {
		int attempts = 0;

		while (attempts < 4) {
			try {
				JavascriptExecutor js = (JavascriptExecutor) Driver();
				js.executeScript("arguments[0].click();", expandIcon);
				WebElement Element = Driver().findElement(By.linkText(Child));
				js.executeScript("arguments[0].scrollIntoView();", Element);
				Element.click();
				break;
			} catch (Exception e) {
				System.out.println("++++++Left Menu Exception++++++" + e);
			}
			attempts++;

		}
	}
}
