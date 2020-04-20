package Example;

//import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

public class FileDownload {
	public static void main(String[] args) throws InterruptedException {

		FileDownload f = new FileDownload();
		f.chromeBrowserDownload();		
		f.firefoxBrowserDownload();
	}
	public void chromeBrowserDownload() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\driver\\chromedriver.exe");

	

		Map<String, Object> prefsMap = new HashMap<String, Object>();
		prefsMap.put("profile.default_content_settings.popups", 0);// used to handle the download notification bar
		prefsMap.put("download.default_directory", "C:\\chrome");// desired path of our downloaded file

		ChromeOptions option = new ChromeOptions();
		option.setExperimentalOption("prefs", prefsMap);
		option.addArguments("--test-type");
		option.addArguments("--disable-extensions");

		WebDriver driver = new ChromeDriver(option);
		FileDownload f = new FileDownload();
		f.toDo(driver);
	}

	public void firefoxBrowserDownload() throws InterruptedException
	{
	System.setProperty("webdriver.gecko.driver", "src\\test\\resources\\driver\\geckodriver.exe");
//Settings of Browser is called preference, Group of preferences is called profile
	FirefoxProfile profile = new FirefoxProfile();
	String key = "browser.helperApps.neverAsk.saveToDisk";
	String value = "application/zip";
	profile.setPreference(key, value);
	profile.setPreference("browser.download.dir", "C:\\firefox");
	// The best way to construct a FirefoxDriver with various options is to make use
	// of the FirefoxOptions, like so:
	FirefoxOptions foption = new FirefoxOptions().setProfile(profile);
	WebDriver driver = new FirefoxDriver(foption);
	FileDownload f = new FileDownload();
	f.toDo(driver);
	}

	private void toDo(WebDriver driver1) throws InterruptedException {
		driver1.get("https://www.seleniumhq.org/download/");
		driver1.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver1.manage().window().maximize();
		driver1.findElement(By.linkText("64 bit Windows IE")).click();
		System.out.println("Downloaded");
		Thread.sleep(5000);// browser should not close until file is downloaded
		driver1.close();
	}
}
