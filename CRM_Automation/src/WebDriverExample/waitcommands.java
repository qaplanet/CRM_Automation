package WebDriverExample;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class waitcommands
{
	public static void main(String[] args)
	{
		FirefoxDriver Driver=new FirefoxDriver();
		Driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
		Driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		
		//Explicit wait object
		WebDriverWait wait=new WebDriverWait(Driver, 60);
		//------------------------------------------------
		//wait until title displayed
		wait.until(ExpectedConditions.titleIs("title"));
		//wait for partial title
		wait.until(ExpectedConditions.titleContains("title"));
		//wait for alert
		wait.until(ExpectedConditions.alertIsPresent());
		//wait for object
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("name")));
		//wait for text
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("xpath"), "text"));
		//wait for frame and switch to it
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("locator"));
	}
}
