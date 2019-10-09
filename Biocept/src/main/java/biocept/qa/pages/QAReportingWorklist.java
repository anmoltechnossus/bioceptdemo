package biocept.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import biocept.qa.base.BioceptBase;
import biocept.qa.utill.ExplicitWait;

public class QAReportingWorklist extends BioceptBase {
	ExplicitWait explicitWait = new ExplicitWait();

	@FindBy(id = "titleHeader")
	WebElement titleHeader;
	@FindBy(xpath = "//*[@id='dataTable_filter']/label/input")
	WebElement searchElement;
	@FindBy(tagName = "tbody")
	WebElement table;

	@FindBy(className = "fa-check")
	WebElement review;

	@FindBy(css = "button[data-bind*='QcReportingComplete']")
	WebElement qaReporting;

	@FindBy(id = "expand")
	WebElement expandIcon;

	public QAReportingWorklist() {
		PageFactory.initElements(Driver(), this);
	}

	public void openQAWorklist(String Child) throws InterruptedException {

		explicitWait.waitUntilElementToBeClickable(expandIcon).click();
		// Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) Driver();
		WebElement Element = Driver().findElement(By.linkText(Child));
		js.executeScript("arguments[0].scrollIntoView();", Element);
		Element.click();

	}

	public void search(String AccessionID, String TestName) throws InterruptedException {
		explicitWait.waitUntilElementToBeVisible(searchElement).sendKeys(AccessionID);
		// Thread.sleep(2000);
		explicitWait.invisibilityOfLoader();
		try {
			List<WebElement> allRow = table.findElements(By.tagName("tr"));
			explicitWait.waitUntilAllElementToBeVisible(allRow);
			boolean found = false;
			for (int i = 0; i < allRow.size(); i++) {
				WebElement tr = allRow.get(i);
				List<WebElement> allCol = tr.findElements(By.tagName("td"));
				for (int j = 0; j < allCol.size(); j++) {
					WebElement testNameEle = allCol.get(8);
					String testName = testNameEle.getText();
					if (testName.equalsIgnoreCase(TestName)) {
						WebElement Button = testNameEle.findElement(By.tagName("a"));
						JavascriptExecutor js = (JavascriptExecutor) Driver();
						js.executeScript("arguments[0].click();", Button);
						found = true;
						// break;
					}
				}
				if (found) {
					break;
				}
			}
		} catch (StaleElementReferenceException e) {

		}
	}

	public void qaReporting() throws InterruptedException {
		explicitWait.invisibilityOfLoader();
		WebDriverWait wait = new WebDriverWait(Driver(), 80);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='panel-default']/div[1]/strong")));
		explicitWait.waitUntilElementToBeVisible(review);
		explicitWait.waitUntilElementToBeClickable(review);
		JavascriptExecutor js = (JavascriptExecutor) Driver();
		js.executeScript("arguments[0].click();", review);
		explicitWait.waitUntilElementToBeVisible(qaReporting).click();

	}
}
