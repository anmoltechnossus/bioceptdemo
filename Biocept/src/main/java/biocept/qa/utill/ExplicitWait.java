package biocept.qa.utill;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import biocept.qa.base.BioceptBase;

public class ExplicitWait extends BioceptBase {

	public void invisibilityOfLoader() {
		WebDriverWait wait = new WebDriverWait(Driver(), 90);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loaderDiv")));
	}

	public void visibilityOfLoader() {
		WebDriverWait wait = new WebDriverWait(Driver(), 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loaderDiv")));
	}

	public WebElement waitUntilElementToBeClickable(WebElement Element) {
		WebDriverWait wait = new WebDriverWait(Driver(), 90);
		WebElement Ele = wait.until(ExpectedConditions.elementToBeClickable(Element));
		return Ele;
	}

	public void waitUntilElementToBeInvisible(WebElement Element) {
		WebDriverWait wait = new WebDriverWait(Driver(), 90);
		wait.until(ExpectedConditions.invisibilityOf(Element));

	}

	public WebElement waitUntilElementToBeVisible(WebElement Element) {
		WebDriverWait wait = new WebDriverWait(Driver(), 90);
		WebElement Ele = wait.until(ExpectedConditions.visibilityOf(Element));
		return Ele;
	}

	public List<WebElement> waitUntilAllElementToBeVisible(List<WebElement> Element) {
		WebDriverWait wait = new WebDriverWait(Driver(), 90);
		List<WebElement> Ele = wait.until(ExpectedConditions.visibilityOfAllElements(Element));
		return Ele;
	}

	public void waitUntilTextToBePresentInElement(WebElement Element, String text) {
		WebDriverWait wait = new WebDriverWait(Driver(), 30);
		wait.until(ExpectedConditions.textToBePresentInElement(Element, text));

	}

}
