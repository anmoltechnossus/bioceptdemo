package biocept.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import biocept.qa.utill.ExtentManager;

public class BioceptBase {

	private WebDriver driver;
	public static Properties prop;
	public static Properties accessionprop;
	public static Logger log = Logger.getLogger("devpinoyLogger");
	public static final ThreadLocal<WebDriver> dr = new ThreadLocal<WebDriver>();

	public static ExtentReports extent = ExtentManager.startReport();

	private ExtentTest test;
	public static ThreadLocal<ExtentTest> testReport = new ThreadLocal<ExtentTest>();

	public void getResult(ITestResult result) throws IOException {
		test = extent.createTest(result.getName());
		setExtentTest(test);
	}

	public ExtentTest getTest() {
		return testReport.get();
	}

	public void setExtentTest(ExtentTest test) {
		testReport.set(test);
	}

	public WebDriver Driver() {
		return dr.get();
	}

	public void WebDriver(WebDriver driver) {
		dr.set(driver);
	}

	public BioceptBase() {

		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "/src/main/java/biocept/qa/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			accessionprop = new Properties();
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "/src/main/java/biocept/qa/testdata/Accession.properties");
			accessionprop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void initialization(String browser) {

		PropertyConfigurator
				.configure(System.getProperty("user.dir") + "/src/test/java/biocept/qa/logs/log4j.properties");

		// String browserName = prop.getProperty(browser);

		if (browser.equals("chrome")) {

			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")
					+ "/src/main/java/biocept/qa/config/Browsers Driver/chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			// options.addArguments("--headless");
			// options.addArguments("--window-size=1920,1080");
			options.addArguments("disable-infobars");
			driver = new ChromeDriver(options);
			log.debug("Chrome Launched !!!");

		} else if (browser.equals("FF")) {
			System.setProperty("webdriver.chrome.driver",
					"C:/Users/amarendra.singh/workspace/Biocept/drivers/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		WebDriver(driver);
		Driver().manage().window().maximize();
		Driver().manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		Driver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		Driver().manage().deleteAllCookies();

	}

	public void jsClick(WebElement Element) {
		JavascriptExecutor js = (JavascriptExecutor) Driver();
		js.executeScript("arguments[0].click();", Element);

	}

	public void scrollIntoView(WebElement Element) {
		JavascriptExecutor js = (JavascriptExecutor) Driver();
		js.executeScript("arguments[0].scrollIntoView();", Element);

	}

}
