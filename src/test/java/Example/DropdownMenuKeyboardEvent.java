package Example;

//import java.awt.Desktop.Action;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;


public class DropdownMenuKeyboardEvent {
	public static void main(String[] args) throws InterruptedException {
		String baseUrl = "http://demo.guru99.com/test/newtours/";
		System.setProperty("webdriver.gecko.driver", "src\\test\\resources\\driver\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseUrl);
		WebElement link_Home = driver.findElement(By.linkText("Home"));
		WebElement td_Home = driver.findElement(By.xpath("//html/body/div" + "/table/tbody/tr/td" + "/table/tbody/tr/td"
				+ "/table/tbody/tr/td" + "/table/tbody/tr"));
//dropDown Menu
		Actions builder = new Actions(driver);
		org.openqa.selenium.interactions.Action mouseOverHome = builder.moveToElement(link_Home).build();

		String bgColor = td_Home.getCssValue("background-color");
		System.out.println("Before hover: " + bgColor);
		mouseOverHome.perform();//Parent or menu
		// System.out.println(getCssValue("background-color").);
		bgColor = td_Home.getCssValue("background-color");
		System.out.println("After hover: " + bgColor);

		
		WebElement txtUsername = driver.findElement(By.name("userName"));
//Keyboard action like clickAndHold(),contextClick(), doubleClick(), dragAndDrop(source, target), dragAndDropBy(source, x-offset, y-offset), moveByOffset(x-offset, y-offset), moveToElement(toElement), release(), sendKeys(onElement, charsequence)
		org.openqa.selenium.interactions.Action seriesOfActions = builder.moveToElement(txtUsername).click().keyDown(txtUsername, Keys.SHIFT)
				.sendKeys(txtUsername, "hello").keyUp(txtUsername, Keys.SHIFT).doubleClick(txtUsername).contextClick().build();
		Thread.sleep(2000);

		seriesOfActions.perform();
		WebElement txtpassword = driver.findElement(By.name("password"));
		txtpassword.sendKeys("password");
		driver.findElement(By.name("submit")).click();
		
		WebElement actual=driver.findElement(By.xpath("//h3[contains(text(),'Login Successfully')]"));
		System.out.println(actual.getText());
		driver.close();
	}
}
