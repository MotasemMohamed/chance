package llll;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login {
	WebDriver driver;
	public Login(WebDriver driver)
	{
		this.driver = driver;
	}
	public void M3login(String username,String password)
	{
		WebElement usernamefield=driver.findElement(By.id("userNameInput"));
		WebElement passwordfield=driver.findElement(By.id("passwordInput"));
		WebElement loginbtn=driver.findElement(By.id("submitButton"));

		usernamefield.sendKeys(username);
		passwordfield.sendKeys(password);
		loginbtn.click();
	}

}
