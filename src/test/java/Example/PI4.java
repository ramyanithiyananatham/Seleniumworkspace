package Example;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.sikuli.api.Screen;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
public class PI4 {
	public static void main(String[] args) throws FindFailed {
		String baseUrl = "http://demo.guru99.com/test/newtours/";
		System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		String underConsTitle = "Under Construction: Mercury Tours";
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		driver.navigate().to(baseUrl);
		List<WebElement> linkElements = driver.findElements(By.tagName("a"));
		String[] linkTexts = new String[linkElements.size()];
		int i = 0;
		System.out.println("number og tags" + linkElements.size());
		// extract the link texts of each link element
		for (WebElement e : linkElements) {
			if(e.getText() != null && !e.getText().trim().isEmpty())
			{
			linkTexts[i] = e.getText();
			//if(linkTexts[i] != null && !linkTexts[i].trim().isEmpty())
			System.out.println("Text"+linkTexts[i]);
			i++;
			}
		}
		System.out.println("Trim size"+linkTexts.length);
		// test each link
		for (String t : linkTexts) {
			try {
				driver.findElement(By.linkText(t)).click();
			}catch(Exception e)
			{
				
			}//Learn Layout table to find this image
			//WebElement mytable = driver.findElement(By.xpath("//td//td[2]//table[1]"));//tr//tr//tr//tr[1]//td[1]//img[1]
			// the below element is image so wont work
			//WebElement w=mytable.findElement(By.cssSelector("font:nth-child(1) b:nth-child(1) font:nth-child(2) b:nth-child(1) > font:nth-child(1)"));
	/*		Screen s=new Screen();
			 s.click("notepad_icon.png");
			 s.find("notepad.png");
			 s.type("notepad.png","This is Nice Sikuli Tutorial!!!!");	
			if (s.isObserving()) {
					System.out.println("\"" + t + "\"" + " is under construction.");
				} else {
					System.out.println("\"" + t + "\"" + " is working.");
				}
			*/
			driver.navigate().back();
		}		
		driver.quit();
	}
}
