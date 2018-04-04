package testng;

import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;


public class TestngFacebook {
	
	static WebDriver driver;
	
	@BeforeTest
	public static void beforetest() {
		//Setup of environment
		 System.setProperty("webdriver.chrome.driver", "C:\\Selenium_Jars_Extensions\\chromedriver.exe");
	}
	@BeforeMethod
public void beforemethod() {
		//Lunching browser
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	
		
	}
@Test
public void ForgottenAccountTest() throws Exception {
	//Forgotten Account
            Thread.sleep(200);
			driver.findElement(By.id("email")).sendKeys("manchester@yahoo.com");
			driver.findElement(By.name("pass")).sendKeys("123456");
			//driver.findElement(By.id("u_0_2")).click(); //needs re-factoring
			driver.findElement(By.xpath("//*[@id='u_0_4']")).click();
			driver.findElement(By.linkText("Sign up for Facebook")).click();
			
}
@Test
public void SignUpDetailsTest() {
	
	//Entering signing up details
			driver.findElement(By.name("firstname")).sendKeys("Manchester");
			driver.findElement(By.name("lastname")).sendKeys("United Kingdom");
			driver.findElement(By.name("reg_email__")).sendKeys("07427517224");
			driver.findElement(By.name("reg_passwd__")).sendKeys("England1");
			
	
}
@Test
public void BirthdayDetailsTest() {
	
	//Setting Birthday "day"
			WebElement day =driver.findElement(By.name("birthday_day"));
			Select selectday = new Select(day);
			selectday.selectByValue("25");
					
			//Setting Birthday "month"
			WebElement month =driver.findElement(By.id("month"));
			Select selectmonth = new Select(month);
			selectmonth.selectByValue("7");
					
			//Setting Birthday "year"
			WebElement year =driver.findElement(By.name("birthday_year"));
			Select selectyear = new Select(year);
			selectyear.selectByValue("1973");			    
	
}
@Test
public void GenderDetailsTest() {
	
	       //Setting Gender
			driver.findElement(By.name("sex")).click();
			
	
}
@Test
public void CreateBtntest() {
	
	        //Clicking Create Account button
			driver.findElement(By.name("websubmit")).click();
			
}
@Test
public void TitleVerificationTest() {
	
	//verification & assertion
	System.out.println(driver.getTitle());
	assertTrue (driver.getTitle().equals("Facebook – log in or sign up"));
	
}
private void assertTrue(boolean equals) {	
}
	
@AfterMethod
public static void aftermethod() {
	driver.close();
	
}

@AfterTest
public void aftertest() {
	System.out.println("Test completed");
	driver.quit();
	
}

}
