package Example;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FindElementsMethod {

	public static void main(String[] args) throws InterruptedException {
		//System.setProperty("webdriver.gecko.driver", "src\\test\\resources\\driver\\geckodriver.exe");
		//WebDriver driver = new FirefoxDriver();

		System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://demo.actitime.com/login.do");
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.name("pwd")).sendKeys("manager");
		driver.findElement(By.xpath("//a[@id='loginButton']/div")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@id='container_tasks']")).click();
		Thread.sleep(2000);
	
		/*	//selectedTask = new ArrayList<WebElement>();
		List<WebElement> selectedTask= driver.findElements(By.xpath("//body/div/div/div/div/div/div/div/div/div/div/div/table/tbody/tr/td[2]/div[1]/div[1]/div[1]/div[2]"));
		
		int size = selectedTask.size();
		System.out.println("TaskSize"+size);
		//WebElement lastElement= driver.findElement(By.xpath("/html[1]/body[1]/div[21]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/table[1]/tbody[1]/tr[62]/td[2]/div[1]/div[1]/div[1]/div[2]"));
		//for (int i = 0; i < size; i++) 
		for(WebElement j :selectedTask)
		{
			JavascriptExecutor je = (JavascriptExecutor) driver;
			// j = selectedTask.get(i);
			je.executeScript("arguments[0].scrollIntoView(true);",j);//window.scrollTo(0,document.body.scrollHeight)");
			
			System.out.println(j.getText());
			Thread.sleep(2000);
		}*/
		/*for(int row=1; row<40; row++) {
			JavascriptExecutor je = (JavascriptExecutor) driver;
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("/html[1]/body[1]/div[21]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/table[1]/tbody[1]/tr["+row+"]/td[2]/div[1]/div[1]/div[1]/div[2]"))));
		
		WebElement selectedTask=driver.findElement(By.xpath("//body/div/div/div/div/div/div/div/div/div/div/div/table/tbody/tr["+row+"]/td[2]/div[1]/div[1]/div[1]/div[2]"));
				//html[1]/body[1]/div[21]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/table[1]/tbody[1]/tr["+row+"]/td[2]/div[1]/div[1]/div[1]/div[2]"));
		//je.executeScript("arguments[0].click()",selectedTask);
		je.executeScript("arguments[0].scrollIntoView(true);",selectedTask);//This will scroll horizontally
	
		
		System.out.println(selectedTask.getText());
		
		
		}*/

		
		driver.findElement(By.xpath("//table[contains(@class,'headerRowTable')]//div[contains(@class,'img')]")).click();
		List<WebElement> selectedTask=driver.findElements(By.xpath("//tr//td[2]"));
		int size = selectedTask.size();
		System.out.println("TaskSize"+size);
		for(WebElement j :selectedTask)
		{
			JavascriptExecutor je = (JavascriptExecutor) driver;
			// j = selectedTask.get(i);
			je.executeScript("arguments[0].scrollIntoView(true);",j);//window.scrollTo(0,document.body.scrollHeight)");
			
			System.out.println(j.getText());
			Thread.sleep(2000);
		}
		driver.close();
	}
}