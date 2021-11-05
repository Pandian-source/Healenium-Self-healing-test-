package Login;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import BrowserDriver.Browser;
import Locators.LoginPage;

public class Source extends Browser
{

	@Test
	public static void CheckTittle()
	{

		PageFactory.initElements(driver, LoginPage.class);

		try
		{
			ExtentTest test = extent.createTest("Got the title");

			test.log(Status.INFO,"Successfully Got the title");
		}
		catch (Exception e)
		{
			e.getStackTrace();

		}
		System.out.println("Window maximised");

		String baseUrl = "https://b2bui2.tltid.com/login";

		String expectedTitle = "Login";

		String actualTitle = "";

		driver.get(baseUrl);

		actualTitle = driver.getTitle();

		System.out.println(actualTitle);

		if (actualTitle.contentEquals(expectedTitle))
		{

			System.out.println("Test Passed");
		}
		else
		{
			System.out.println("Test Failed");

		}
	}

    @Test
	public static void Login() throws InterruptedException
	{

		ExtentTest test = extent.createTest("Login successfully");

		WebDriverWait wait =new WebDriverWait(driver,100);

		Thread.sleep(10);

		WebElement Element= wait.until(ExpectedConditions.visibilityOf(LoginPage.submit));

		String b = Element.getText();

		System.out.println(b);

		Element.click();

		if(b.contentEquals("Login"))
		{
			test.log(Status.PASS,"Text Equal");
		}
		else
		{
			test.log(Status.FAIL,"Text Not Equal");
		}

        System.out.println("driver="+driver);

		ExtentTest test1 = extent.createTest("Password");

		test1.log(Status.PASS, "Text details");

		LoginPage.Username.click();

		System.out.println("username field clicked");

        LoginPage.Username.sendKeys("a.pandian@wintlt.com");

		System.out.println("Username field entered");

		LoginPage.Password.click();

		System.out.println("password field clicked");

	    LoginPage.Password.sendKeys("12345S#");

		System.out.println("password field entered");

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].click();", LoginPage.submit);
	}

    @Test
	public static void Search() throws InterruptedException
	{
		System.out.println("driver="+driver);

		ExtentTest test = extent.createTest("FromOption");

		test.log(Status.PASS, "Text details");

		WebDriverWait wait2 = new WebDriverWait(driver, 100);

		Thread.sleep(3000);

		WebElement Element= wait2.until(ExpectedConditions.visibilityOf(LoginPage.Hotel));

		Element.click();

		Element.sendKeys("Chennai");

		Thread.sleep(3000);
	}

}


