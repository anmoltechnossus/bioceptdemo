package biocept.qa.utill;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import biocept.qa.base.BioceptBase;

public class Screenshot extends BioceptBase {

	public String captureScreenshot(String screenShotName) throws IOException {
		try {

			TakesScreenshot ts = (TakesScreenshot) Driver();
			File source = ts.getScreenshotAs(OutputType.FILE);
			String dest = System.getProperty("user.dir") + "\\Screenshots\\" + screenShotName + ".png";
			File destination = new File(dest);
			FileUtils.copyFile(source, destination);

			return dest;
		} catch (Exception e)

		{
			System.out.println("Exception while tacking screenshot" + e.getMessage());
			return e.getMessage();

		}
	}
}
