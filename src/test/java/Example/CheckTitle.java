package Example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CheckTitle {
public static void main(String[] args) {
	   // declaration and instantiation of objects/variables
	System.setProperty("webdriver.gecko.driver", "src\\test\\resources\\driver\\geckodriver.exe");
	WebDriver driver = new FirefoxDriver();
	//comment the above 2 lines and uncomment below 2 lines to use Chrome
	//System.setProperty("webdriver.chrome.driver","src\\test\\resources\\driver\\chromedriver.exe");
	//WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
    String baseUrl = "http://demo.guru99.com/test/newtours/";
    String expectedTitle = "Welcome: Mercury Tours";
    String actualTitle = "";

    // launch Fire fox and direct it to the Base URL
    driver.get(baseUrl);
    

    // get the actual value of the title
    actualTitle = driver.getTitle();
System.out.println(actualTitle);
    /*
     * compare the actual title of the page with the expected one and print
     * the result as "Passed" or "Failed"
     */
    if (actualTitle.contentEquals(expectedTitle)){
        System.out.println("Test Passed!");
    } else {
        System.out.println("Test Failed");
    }
   
    //close Fire fox
    driver.close();
    
}
}
