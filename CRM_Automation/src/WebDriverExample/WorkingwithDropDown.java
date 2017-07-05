package WebDriverExample;
import java.util.Iterator;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
public class WorkingwithDropDown
{
	public static void main(String[] args)throws Exception
	{
		System.setProperty("webdriver.chrome.driver", "F:\\D-Drive\\FromC\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver Driver=new ChromeDriver();
		//------------------------------------------------
		//open application
		Driver.get("http://classroom:90/webapp/SelectAWebSite.html");
		Thread.sleep(2000);
		//----------------------------------------------
		WebElement E=Driver.findElement(By.name("OptWeb"));
		//Create select object
		Select Sel=new Select(E);
		//-----------------------------------------------
		//To get all options
		List<WebElement> Options=Sel.getOptions();
		//get items count
		System.out.println(Options.size());
		//-----------------------------------------------
		//Print all items from drop down
		//way 1
		for(int i=0;i<Options.size();i++)
		{
			String text=Options.get(i).getText();
			System.out.println(text);
		}
		System.out.println("=-----------------------------------");
		//--------------------------------------------------
		//Way 2
		for(WebElement E1 : Options)
		{
			System.out.println(E1.getText());
		}
		System.out.println("=-----------------------------------");
		//-------------------------------------------------------
		//Way 3
		Iterator<WebElement> ITRT=Options.iterator();
		while (ITRT.hasNext())
		{
			WebElement E2=ITRT.next();
			System.out.println(E2.getText());
		}
		//----------------------------------------------------------
		Driver.close();
		Driver.quit();
	}
}
