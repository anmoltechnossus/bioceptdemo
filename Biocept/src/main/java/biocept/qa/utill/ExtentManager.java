package biocept.qa.utill;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {

	public static ExtentReports extent;
	// public static ExtentHtmlReporter htmlReporter;

	public static ExtentReports startReport() {
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(
				System.getProperty("user.dir") + "/test-output/BioceptTestReport.html");

		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Project Name", "Biocept");
		extent.setSystemInfo("Environment", "Hotfix");
		extent.setSystemInfo("Operating Systems", "Window 10");
		extent.setSystemInfo("User Name", "Amarendra Singh");
		htmlReporter.config().setChartVisibilityOnOpen(true);
		htmlReporter.config().setReportName("Smoke Testing");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.DARK);
		return extent;
	}

}
