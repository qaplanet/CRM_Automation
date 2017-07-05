package WebDriverExample;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
public class ActionsCommands
{
	public static void main(String[] args)
	{
		FirefoxDriver Driver=new FirefoxDriver();
		Actions A=new Actions(Driver);
		//---------------------------------------------------
		A.click(Driver.findElement(By.id("id"))).perform();
		A.doubleClick(Driver.findElement(By.id("id"))).build().perform();
		//---------------------------------------------------
		WebElement E=Driver.findElement(By.id("id"));
		//To click 
		A.click(E).perform();
		//To double click
		A.doubleClick(E).perform();
		//TO mouse over
		A.moveToElement(E).perform();
		//To per from drag and dropw
		//Way1
		WebElement Src=Driver.findElement(By.id("id"));
		WebElement Des=Driver.findElement(By.id("id"));
		A.clickAndHold(Src).perform();
		A.moveToElement(Des).perform();
		A.release(Des).perform();
		//Way 2
		A.dragAndDrop(Src, Des).perform();
		//-----------------------------------------------------
		//To perform right click
		A.contextClick(E).perform();
		//-----------------------------------------------------
		A.sendKeys(Keys.ARROW_RIGHT).perform();
		A.sendKeys(Keys.chord(Keys.ALT,Keys.TAB)).perform();
	}
}
