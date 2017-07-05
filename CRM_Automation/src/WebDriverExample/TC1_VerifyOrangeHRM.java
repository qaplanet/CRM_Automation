package WebDriverExample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TC1_VerifyOrangeHRM
{
	public static void main(String[] args) throws Exception
	{
		System.setProperty("webdriver.gecko.driver", "F:\\D-Drive\\FromC\\geckodriver-v0.15.0-win64\\geckodriver.exe");
		FirefoxDriver Driver=new FirefoxDriver();
		//----------------------Step1---------------------------------
		//Open application
		Driver.get("http://classroom:90/qahrm/login.php");
		Thread.sleep(2000);
		//Verify home page
		if(Driver.getTitle().equals("OrangeHRM - New Level of HR Management"))
		{
			System.out.println("Home page displayed");
		}
		else
		{
			System.out.println("Failed to open home page");
			return;
		}
		//----------------------------------------------------------
		//Create webelements for user name,password,login and clear
		WebElement objUN=Driver.findElement(By.name("txtUserName"));
		WebElement objPWD=Driver.findElement(By.name("txtPassword"));
		WebElement objLogin=Driver.findElement(By.name("Submit"));
		WebElement objClear=Driver.findElement(By.name("clear"));
		//-----------------------------------------------------------
		//Verify user name
		if(objUN.isDisplayed())
		{
			System.out.println("User name displayed");
		}
		//Verify password
		if(objPWD.isDisplayed())
		{
			System.out.println("Password displayed");
		}
		//Verify login and clear
		if(objLogin.isDisplayed() && objClear.isDisplayed())
		{
			System.out.println("Login and clear buttons are displayed");
		}
		//------------------------Step2-----------------------------------------------------
		String sUN="qaplanet1";
		String sPWD="user1";
		//---------------------------------------------------------------------------------
		objUN.clear();
		objUN.sendKeys(sUN);
		objPWD.clear();
		objPWD.sendKeys(sPWD);
		//-------------------------------------------------------------------------------
		//Get value property from login button
		String val=objLogin.getAttribute("value");
		System.out.println(val);
		//------------------------------------------------------------------------------
		objLogin.click();
		Thread.sleep(3000);
		//----------------------------------------------------------------------------
		//Verify orangeHRM
		if(Driver.getTitle().equals("OrangeHRM"))
		{
			System.out.println("Sign in sucessfull & OrangeHRM page displayed");
		}
		//Verify Welcome qaplanet1
		if(Driver.findElement(By.xpath("//ul[@id='option-menu']/li[1]")).getText().equals("Welcome "+sUN))			
		{
			System.out.println("Welcome "+sUN+" displayed");
		}
		//----------------------------------------------------------------------------
		WebElement objCP=Driver.findElement(By.linkText("Change Password"));
		WebElement objLogout=Driver.findElement(By.linkText("Logout"));
		//Verify Change Password & Logout
		if(objCP.isDisplayed() && objLogout.isDisplayed())
		{
			System.out.println("Change Password & Logout are displayed");
		}
		//-----------------------step3--------------------------------------------
		objLogout.click();
		Thread.sleep(2000);
		//Verify home page
		if(Driver.getTitle().equals("OrangeHRM - New Level of HR Management"))
		{
			System.out.println("Sign off sucessfull & Home page displayed");
		}
		//---------------------------------------
		Driver.close();
		Driver.quit();
	}
}
