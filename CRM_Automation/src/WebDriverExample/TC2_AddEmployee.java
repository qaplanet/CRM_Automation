package WebDriverExample;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TC2_AddEmployee
{
	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver", "F:\\D-Drive\\FromC\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver Driver=new ChromeDriver();
		WebDriverWait wait=new WebDriverWait(Driver, 60);
		Actions act=new Actions(Driver);
		//----------------------Step1---------------------------------
		//Open application
		Driver.get("http://apps.qaplanet.in/qahrm/login.php");
		//wait for home page
		boolean HomeRes=wait.until(ExpectedConditions.titleIs("OrangeHRM - New Level of HR Management"));
		//Verify home page
		if(HomeRes)
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
		WebElement objUN=wait.until(ExpectedConditions.presenceOfElementLocated(By.name("txtUserName")));
		WebElement objPWD=wait.until(ExpectedConditions.presenceOfElementLocated(By.name("txtPassword")));
		WebElement objLogin=wait.until(ExpectedConditions.presenceOfElementLocated(By.name("Submit")));
		WebElement objClear=wait.until(ExpectedConditions.presenceOfElementLocated(By.name("clear")));
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
		//Click on login
		objLogin.click();
		//Verify orangeHRM
		if(wait.until(ExpectedConditions.titleIs("OrangeHRM")))
		{
			System.out.println("Sign in sucessfull & OrangeHRM page displayed");
		}
		//Verify Welcome qaplanet1
		//Way 1
		if(Driver.findElement(By.xpath("//ul[@id='option-menu']/li[1]")).getText().equals("Welcome "+sUN))			
		{
			System.out.println("Welcome "+sUN+" displayed");
		}
		//Verify user name text on OrangeHRM Page
		//------------------------------------------------------
		//Get Welcome text
		String sWelText=Driver.findElement(By.xpath("//ul[@id='option-menu']/li[1]")).getText();
		String[] Arr=sWelText.split(" ");
		if(Arr[1].equals(sUN))
		{
			System.out.println(sUN+" displayed");
		}
		//----------------------------------------------------------------------------
		WebElement objCP=Driver.findElement(By.linkText("Change Password"));
		WebElement objLogout=Driver.findElement(By.linkText("Logout"));
		//Verify Change Password & Logout
		if(objCP.isDisplayed() && objLogout.isDisplayed())
		{
			System.out.println("Change Password & Logout are displayed");
		}
		//-------------------------------------------------------------------
		//Create reference object for PIM
		WebElement objPIM=Driver.findElement(By.id("pim"));
		//Mouse over on PIM
		act.moveToElement(objPIM).perform();
		//click on add employee
		Driver.findElement(By.linkText("Add Employee")).click();
		//wait for frame and switch to it
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("rightMenu"));
		//wait for PIM : Add Employee text
		boolean blnPIMAddEmp=wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//div[@class='mainHeading']/h2"), "PIM : Add Employee"));
		if(blnPIMAddEmp)
		{
			System.out.println("PIM : Add Employee displayed");
		}
		//----------------------------------------------------------
		String strFN="sreedhar";
		String strLN="Metukuru";
		//-----------------------------------------------------------------
		//Get Employee ID
		String strEmpCode=Driver.findElement(By.id("txtEmployeeId")).getAttribute("value");
		//Crate reference object for save button
		WebElement objSave=Driver.findElement(By.id("btnEdit"));
		//Keep all fields as blank and click on save
		objSave.click();
		//wait for alert and switch to it
		Alert objAlert=wait.until(ExpectedConditions.alertIsPresent());
		//verify Last Name Empty! alert message
		if(objAlert.getText().equals("Last Name Empty!"))
		{
			System.out.println("Last Name Empty! displayed");
			objAlert.accept();
		}
		//Enter last name
		Driver.findElement(By.name("txtEmpLastName")).sendKeys(strLN);
		//click on save
		objSave.click();
		//wait for alert and switch to it
		Alert objAlert1=wait.until(ExpectedConditions.alertIsPresent());
		//verify First Name Empty! alert message
		if(objAlert1.getText().equals("First Name Empty!"))
		{
			System.out.println("First Name Empty! displayed");
			objAlert1.accept();
		}		
		//enter first name
		Driver.findElement(By.name("txtEmpFirstName")).sendKeys(strFN);
		//click on save
		objSave.click();
		//wait for Personal Details 
		boolean blnPerdsonalDetails=wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//div[@class='mainHeading']/h2"), "Personal Details"));
		if(blnPerdsonalDetails)
		{
			System.out.println("Personal Details displayed");
		}
		//switch to top frame
		Driver.switchTo().parentFrame();
		//-------------------------------------------------------------------------
		//Mouse over on PIM
		act.moveToElement(objPIM).perform();
		//click on Employee List
		Driver.findElement(By.linkText("Employee List")).click();
		//wait for frame and switch to it
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("rightMenu"));
		//wait for Employee Information
		boolean blnEmpInfo=wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//div[@class='mainHeading']/h2"), "Employee Information"));
		if(blnEmpInfo)
		{
			System.out.println("Employee Information displayed");
		}		
		//---------------------------------------------------------------------
		//Get row count
		int iRC=Driver.findElements(By.xpath("//table[@class='data-table']/tbody/tr")).size();
		int i;
		for(i=1;i<=iRC;i++)
		{
			//Get second column data
			String sEmpID=Driver.findElement(By.xpath("//table[@class='data-table']/tbody/tr["+i+"]/td[2]")).getText();
			//Get third column data
			String sEmpName=Driver.findElement(By.xpath("//table[@class='data-table']/tbody/tr["+i+"]/td[3]/a")).getText();
			if(sEmpID.equals(strEmpCode) && sEmpName.equals(strFN+" "+strLN))
			{
				System.out.println(strEmpCode+", "+sEmpName+" displayed at: "+i);
				break;
			}
		}
		//Go to top frame
		Driver.switchTo().defaultContent();
		//-----------------------step3--------------------------------------------
		objLogout.click();
		//Verify home page
		if(wait.until(ExpectedConditions.titleIs("OrangeHRM - New Level of HR Management")))
		{
			System.out.println("Sign off sucessfull & Home page displayed");
		}
		//---------------------------------------
		Driver.close();
		Driver.quit();
	}
}
