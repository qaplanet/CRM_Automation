package WebDriverExample;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebdriverCommands 
{
	public static void main(String[] args) 
	{
		FirefoxDriver Driver=new FirefoxDriver();
		WebElement E1=Driver.findElement(By.id("id"));
		//---------------------------------------------------
		E1.sendKeys(Keys.ENTER);
		E1.sendKeys(Keys.ESCAPE);
		E1.sendKeys(Keys.EQUALS);
		E1.sendKeys(Keys.F10);
		E1.sendKeys(Keys.NUMPAD0);
		E1.sendKeys(Keys.ARROW_LEFT);
		//To perform multiple operations
		E1.sendKeys(Keys.chord(Keys.CONTROL,"a"));
		E1.sendKeys(Keys.chord(Keys.ALT,Keys.CONTROL,Keys.DELETE));
		
		
		
		//To find multiple elements
		List<WebElement> LIST=Driver.findElements(By.className("className"));
		//To get buttons count
		int bc=Driver.findElements(By.className("button")).size();
		//way 2
		List<WebElement> BList=Driver.findElements(By.className("button"));
		System.out.println(BList.size());
		//TO get links count
		int LC=Driver.findElements(By.tagName("a")).size();		
		//----------------------------------------------------
		WebElement E=Driver.findElement(By.id("id"));
		E.clear();
		E.sendKeys("data");
		E.click();
		//To verify element present or not
		E.isDisplayed();
		//To verify element enabled or not
		E.isEnabled();
		//To verify element selected or not
		E.isSelected();
		//To get text from element
		String text=E.getText();
		//To get property value
		String val=E.getAttribute("property name");
		//--------------------------------------------------
		//open web page/home page
		Driver.get("url");
		//To find single element
		Driver.findElement(By.id("id"));
		//TO get title from current web page
		String title=Driver.getTitle();
		//To close browser
		Driver.close();
		//To quit object
		Driver.quit();
		//----------------------------------
		//To clear text fields
		Driver.findElement(By.name("username")).clear();
		//To type data into text fields
		Driver.findElement(By.name("username")).sendKeys("data");
		//Click on element
		Driver.findElement(By.name("Login")).click();
		//---------------------------------------------------
		/*
		 1. open HRM
		 2. Enter username
		 3. Enter password
		 4. click on login
		 5. Click on logout
		 */
	}
}
