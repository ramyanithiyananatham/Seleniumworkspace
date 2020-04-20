package Example;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DateSelect {
	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://www.southwest.com/");
		// *[@id="LandingAirBookingSearchForm_destinationAirportCode"]
		// Select Arrival city
		driver.findElement(By.xpath("//*[@id=\"LandingAirBookingSearchForm_destinationAirportCode\"]")).sendKeys("LGA");

//select depart date
		driver.findElement(By.xpath("//input[@id='LandingAirBookingSearchForm_departureDate']")).click();

		String month = "June 2020";
		String date = "15";

		while (true) {
// selecting arrow 
			// checking displayed is expected or not
			// div[@class='calendar---watermark'][contains(text(),'Apr')]
			// div[@class='calendar---watermark'][contains(text(),'May')]
			String text = driver.findElement(By.xpath("//*[@id=\"calendar-112\"]/div/div[1]/div[1]")).getText();

			// div[contains(text(),'June 2020')]
			if (text.equals(month)) {

				break;
			}

			else {
				driver.findElement(By.xpath(
						"//button[@class='actionable actionable_button actionable_icon-only actionable_light button calendar-controls--button calendar-controls--next']"))
						.click();

			}
			System.out.println("Depart does not match" + text);
		}

		List<WebElement> allDates = driver.findElements(By.xpath("//button[@role='gridcell']"));

		for (WebElement ele : allDates) {
			String date_text = ele.getText();

			if (date_text.equals(date)) {

				ele.click();

				break;
			}

		}

//return date get focus automatically
		// driver.findElement(By.xpath("id=\"LandingAirBookingSearchForm_returnDate\"")).click();
		Thread.sleep(2000);// Since it takes time to show return date
		String month1 = "September 2020";
		String numMonth ="09";
		String date1 = "25";
		String find=numMonth+"-"+date1;
		System.out.println("find date"+find);
		while (true) {
			// *[@id="calendar-115"]/div/div[1]/div[1]
			String text1 = driver.findElement(By.xpath("//*[@id=\"calendar-115\"]/div/div[1]/div[1]")).getText();

			if (text1.equals(month1)) {

				break;
			}

			else {// *[@id="calendar-115"]/div/button[2]
				driver.findElement(By.xpath("//*[@id=\"calendar-115\"]/div/button[2]")).click();
				// span[@role='presentation']//this cant be found
			}
			System.out.println("Return does not match" + text1);
		}
Thread.sleep(5000);
// These commented code can select date in visible are only
		WebElement dateofReturn = driver.findElement(By.xpath("//button[@id='calendar-115-2020-"+find+"']"));

		String d = dateofReturn.getAttribute("aria-label");
		System.out.println("Selected dateofReturn" + d);
		dateofReturn.click();
//*[contains(@id,'calendar-115-2020-07-25')]=//*[@id="calendar-115-2020-05-19"]   + //*[@id="calendar-115-2020-05-20"]   +  //*[@id="calendar-115-2020-04-13"]

		/*
		 * List<WebElement> allreturnDates =
		 * driver.findElements(By.xpath("//button[@role='gridcell']"));
		 * 
		 * for (WebElement ele1 : allreturnDates) { String date_text1 = ele1.getText();
		 * 
		 * // String date1[]=date_text.split("\n");line lo vache text ni split 	 * cheyyadaniki
		 * 
		 * if (date_text1.equals(date1)) {
		 * 
		 * ele1.click();
		 * 
		 * break; }
		 * 
		 * }
		 */
		// select number of passengers
		driver.findElement(By.xpath("//*[@id=\"LandingAirBookingSearchForm_adultPassengersCount\"]")).click();
		// select 3 as passengers count
		// Thread.sleep(1000);

		driver.findElement(By.xpath("//*[@id=\"LandingAirBookingSearchForm_adultPassengersCount--item-2\"]/button"))
				.click();
		// select search
		Thread.sleep(2000);

		driver.findElement(By.xpath("//*[@id=\"LandingAirBookingSearchForm_submit-button\"]")).click();

		Thread.sleep(1000);
		// get the new url
		System.out.println("PresentURL " + driver.getTitle());

		//driver.close();
	}
}
