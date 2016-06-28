package Exercises;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
public class ThamNT_testNG01 {
	private WebDriver driver;
	private String baseUrl;
	
	@BeforeTest
	public void setUp() throws Exception{
		driver= new FirefoxDriver();
		driver.manage().window().maximize();
		baseUrl= "http://ironsummitmedia.github.io";
		
		driver.get(baseUrl+ "/startbootstrap-agency/");
	}
	
	// Verify avatar by Selector= [attribute*=value]
	@Test (priority= 3, enabled= true)
	public void test01() throws Exception {
		WebElement ImageFile = driver.findElement(By.cssSelector("img[src*='img/team/1.jpg']"));
		Boolean ImagePresent = (Boolean) ((JavascriptExecutor)driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", ImageFile);
		if (!ImagePresent)
		{
		     System.out.println("Image not displayed.");
		}
		else
		{
		   System.out.println("Image displayed.");
		}		
	
	}
	
	//Input infor
	@Test (priority= 0, enabled= false)
	public void test02() throws Exception{
		driver.findElement(By.cssSelector("a[href='#contact']")).click();
		Thread.sleep(5000);
		
		driver.findElement(By.cssSelector("#name")).sendKeys("Dolphin");
		driver.findElement(By.cssSelector("#email")).sendKeys("dolphin@ntq.ntq");
		driver.findElement(By.cssSelector("#phone")).sendKeys("12345");
		driver.findElement(By.cssSelector("#message")).sendKeys("Hello Dolphin");
		Thread.sleep(5000);
		
		driver.findElement(By.xpath(".//*[@id='contactForm']/div/div[4]/button")).click();
		Thread.sleep(5000);
		
		String actualText= driver.getPageSource();
		Thread.sleep(10000);
		String expectText= "it seems that my mail server is not responding. Please try again later!";
		if (actualText.contains(expectText)) {
			System.out.println("It is error message!");
		}
		else {
			System.out.println("It is OK!");
		}
	}
	// Verify URL
	@Test (priority= 1, enabled= true)
	public void test03() throws Exception {
		
		String actualUrl= driver.getCurrentUrl();
		String expectUrl = "http://ironsummitmedia.github.io";
		if (actualUrl.equals(expectUrl))
		{
		     System.out.println("It is match");
		}
		else
		{
		   System.out.println("It is not match");
		}		
	}
	
	@AfterTest
	public void quit() {
		driver.quit();
	}

}
