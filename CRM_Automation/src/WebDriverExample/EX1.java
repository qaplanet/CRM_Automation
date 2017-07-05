package WebDriverExample;
import org.openqa.selenium.firefox.FirefoxDriver;
public class EX1
{
	public static void main(String[] args) 
	{
		System.setProperty("webdriver.gecko.driver", "F:\\D-Drive\\FromC\\geckodriver-v0.15.0-win64\\geckodriver.exe");
		FirefoxDriver x=new FirefoxDriver();
	}
}
