package WebDriverExample;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WorkingWithWebtable 
{
	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "F:\\D-Drive\\FromC\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver Driver=new ChromeDriver();
		WebDriverWait wait=new WebDriverWait(Driver, 60);
		//------------------------------------------------
		//open application
		Driver.get("http://classroom:90/webapp/AssertXPath.html");
		//wait for home page
		boolean res=wait.until(ExpectedConditions.titleIs("AssertXPath"));
		if(res)
		{
			System.out.println("AssertXPath page displayed");
		}
		//-------------------------------------------------------
		//Get row count
		int rc=Driver.findElements(By.xpath("//table[@id='idCourse']/tbody/tr")).size();
		System.out.println("Row count: "+rc);
		//Get column count count
		int colc=Driver.findElements(By.xpath("//table[@id='idCourse']/tbody/tr[1]/td")).size();
		System.out.println("Column count: "+colc);
		//Get cell count
		int cellc=Driver.findElements(By.xpath("//table[@id='idCourse']/tbody/tr/td")).size();
		System.out.println("Cell count: "+cellc);	
		//---------------------------------------------------
		//Print cell data
		//===================================================
		//Way 1
		for(int i=1;i<=rc;i++)
		{
			for(int j=1;j<=colc;j++)
			{
				//Get cell data
				String data=Driver.findElement(By.xpath("//table[@id='idCourse']/tbody/tr["+i+"]/td["+j+"]")).getText();
				System.out.println(data);
			}
		}	
		System.out.println("-----------------------------------------------");
		//way 2: using for each
		List<WebElement> TDS=Driver.findElements(By.xpath("//table[@id='idCourse']/tbody/tr/td"));
		for (WebElement TD : TDS)
		{
			System.out.println(TD.getText());
		}
		//=====================================================
		Driver.close();
		Driver.quit();
	}
	
}
