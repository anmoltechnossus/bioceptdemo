package biocept.qa.listeners;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Parameters;

import biocept.qa.base.BioceptBase;
import biocept.qa.utill.Screenshot;

public class CustomListeners extends BioceptBase implements ITestListener, ISuiteListener {
	Screenshot screenshot = new Screenshot();
	// public static ThreadLocal<ExtentTest> testReport = new
	// ThreadLocal<ExtentTest>();

	public void onFinish(ITestContext arg0) {
		Driver().quit();

	}

	@Parameters("browser")

	public void onStart(ITestContext arg0, String browser) {
		initialization(browser);

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	public void onTestFailure(ITestResult arg0) {

		// String screenShotPath = null;
		// try {
		// screenShotPath = screenshot.captureScreenshot(arg0.getName());
		// } catch (IOException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// getTest().log(Status.FAIL,
		// MarkupHelper.createLabel(arg0.getName() + " Test case FAILED due to
		// below issues:", ExtentColor.RED));
		// getTest().fail(arg0.getThrowable());
		// try {
		// getTest().fail("Snapshot below: " +
		// getTest().addScreenCaptureFromPath(screenShotPath));
		// } catch (IOException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// extent.flush();

	}

	public void onTestSkipped(ITestResult arg0) {
		// getTest().log(Status.SKIP, MarkupHelper.createLabel(arg0.getName() +
		// " Test Case SKIPPED", ExtentColor.ORANGE));
		// getTest().skip(arg0.getThrowable());
		// extent.flush();

	}

	public void onTestStart(ITestResult arg0) {
		// try {
		// getResult(arg0);
		// } catch (IOException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
	}

	public void onTestSuccess(ITestResult arg0) {
		// getTest().log(Status.PASS, MarkupHelper.createLabel(arg0.getName() +
		// " Test Case PASSED", ExtentColor.GREEN));
		// extent.flush();
	}

	public void onFinish(ISuite arg0) {
		// extent.flush();

	}

	public void onStart(ISuite arg0) {
		// BioceptBase.startReport();

	}

	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub

	}

}
