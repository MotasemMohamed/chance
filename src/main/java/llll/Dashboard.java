package llll;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Dashboard {
	WebDriver driver;

	public Dashboard(WebDriver driver)
	{
		this.driver = driver;
	}
	public void Choose_system()
	{
		Actions actions= new Actions(driver);
		actions.moveToElement(driver.findElement(By.xpath("(//*[@class='nm-icons'])[1]")));
		actions.click().perform();
		actions.moveToElement(driver.findElement(By.xpath("//a[@title='Infor M3']")));
		actions.click().perform();

		/*	JavascriptExecutor js = (JavascriptExecutor)driver; 
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//*[@class='nm-icons'])[1]")));
		 */
	}
	public void openprogram()
	{
		Actions actions= new Actions(driver);
		actions.keyDown(Keys.CONTROL).sendKeys(Keys.chord("R")).keyUp(Keys.CONTROL).perform();	
	}
	public WebElement expandRootElement(WebElement element) {
		WebElement ele = (WebElement) ((JavascriptExecutor)driver).executeScript("return arguments[0].shadowRoot", element);
		return ele;
	}
}
