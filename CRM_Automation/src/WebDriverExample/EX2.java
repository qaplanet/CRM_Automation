package WebDriverExample;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
public class EX2
{
	public static void main(String[] args) throws Exception
	{
		System.setProperty("webdriver.gecko.driver", "F:\\D-Drive\\FromC\\geckodriver-v0.15.0-win64\\geckodriver.exe");
		FirefoxDriver Driver=new FirefoxDriver();
		//-----------------------------------------------------//Open hrm
		Driver.get("http://classroom:90/qahrm/login.php");
		Thread.sleep(2000);
		//Enter user name
		Driver.findElement(By.name("txtUserName")).clear();
		Driver.findElement(By.name("txtUserName")).sendKeys("qaplanet1");
		//Enter password
		Driver.findElement(By.name("txtPassword")).clear();
		Driver.findElement(By.name("txtPassword")).sendKeys("user1");
		//Click on login
		Driver.findElement(By.name("Submit")).click();
		Thread.sleep(3000);
		//click on logout
		Driver.findElement(By.linkText("Logout")).click();
		Thread.sleep(2000);
		//----------------------------------------------------
		Driver.close();
		Driver.quit();
	}
}
