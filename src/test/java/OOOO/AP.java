package OOOO;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import llll.Dashboard;
import llll.Login;

public class AP extends Common {
	Login loginpage;
	Dashboard dashboardpage;
	@Test
	public void Open_IOS()
	{
		loginpage= new Login(driver);
		loginpage.M3login("motasem.mohamed@ibnsina-pharma.com", "motaz@95");
		WebDriverWait wait= new WebDriverWait(Common.driver, 10);
		wait.until(driver -> driver.findElement(By.id("pName")));
		Assert.assertEquals(driver.findElement(By.id("pName")).getText(), "Motasem Mohamed");
	}
	@Test(dependsOnMethods = "Open_IOS")
	public void Choose_system()
	{
		dashboardpage= new Dashboard(driver);
		dashboardpage.Choose_system();    
		WebDriverWait wait= new WebDriverWait(driver, 20);
		wait.until(driver -> driver.findElement(By.name("m3h5_fc35cf33-7a38-4c35-b3c2-c265e303ac69")));
		driver.switchTo().frame(driver.findElement(By.name("m3h5_fc35cf33-7a38-4c35-b3c2-c265e303ac69")));
		wait.until(driver -> driver.findElement(By.xpath("//span[@id='startDiv']")));
		Assert.assertEquals(driver.findElement(By.xpath("//span[@id='startDiv']")).getTagName(),"span");
	}
	@Test(dependsOnMethods = "Choose_system")
	public void openAPS100() 
	{
		dashboardpage= new Dashboard(Common.driver);
		dashboardpage.openprogram();
		WebElement root1 = driver.findElement(By.id("cmdText"));
		WebElement shadowRoot = (WebElement) ((JavascriptExecutor)driver).executeScript("return arguments[0].shadowRoot", root1);
		//WebElement shadowRoot = dashboardpage.expandRootElement(root1);
		shadowRoot.findElement(By.id("placeholder"));
		//driver.execute_script('return arguments[0].shadowRoot', driver.find_element_by_tag_name('downloads-manager'));
		//driver.findElement(By.xpath("//div/input[@id='cmdText']")).sendKeys("APS100");
		//driver.findElement(By.xpath("//div/input[@id='cmdText']")).sendKeys(Keys.ENTER);
		WebDriverWait wait= new WebDriverWait(driver, 20);
		wait.until(driver -> shadowRoot.findElement(By.id("placeholder")));
		Assert.assertEquals(shadowRoot.findElement(By.id("placeholder")).getText(),"Search and Start");

	}
}
