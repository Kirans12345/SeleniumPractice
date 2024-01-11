package utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import pages.TestBase;

public class ScreenShotUtility extends TestBase{
	WebDriver driver;
	public File screenshot() throws IOException {
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		String path="C:\\Screenshots\\myscreenshot_"+System.currentTimeMillis()+".png";
		File target=new File(path);
		FileUtils.copyFile(source, target);
		return target;
	}

}
