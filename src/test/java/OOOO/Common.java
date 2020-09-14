package OOOO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class Common {
	public static WebDriver driver;

	@BeforeSuite
	static void BeforeSuite() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver","src/test/resources/Drivers/chromedriver.exe");	
		driver = new ChromeDriver();
		driver.navigate().to("https://ios-test.ibnsina-pharma.com/infor/c61fc75a-cf65-4433-b6ad-8f1bc03c7dc9?favoriteContext=%3FLogicalId%3Dlid%3A%2F%2Finfor.wm.m3-sce-sctst%A%3DInforSCEASNReceipt%26SCE_Schema%3DInfor%253AAE5%253A%253AWHSE5%253A%26emptyList%3Dtrue&LogicalId=lid://infor.wm.m3-sce-sctst");
		 
   /*
		driver.navigate().to("https://m3-iso.ibnsina-pharma.com:19008/mne/");
		Alert alert = driver.switchTo().alert();
		alert.sendKeys("motasem.mohamed@ibnsina-pharma.com");
		alert.sendKeys("motaz@95");
		alert.dismiss();
	*/
		}
	@AfterSuite
	static void AfterSuite() {
		driver.close();
	}
}
