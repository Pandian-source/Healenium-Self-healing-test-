package BrowserDriver;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.epam.healenium.SelfHealingDriver;
import com.epam.healenium.SelfHealingEngine;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import com.typesafe.config.ConfigValueFactory;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Browser
{
	//public static WebDriver driver;

	public static SelfHealingDriver driver;


    public static ExtentReports extent;

	@BeforeMethod
	public void launchBrowser() throws IOException
	{
		extent = new ExtentReports();

		ExtentSparkReporter spark = new ExtentSparkReporter("Extend.html");

		spark.config().setTheme(Theme.DARK);

		spark.config().setDocumentTitle("Automation Report");

		spark.config().setReportName("Extend Report");

		extent.attachReporter(spark);

		String browsertest = "chrome";

		if(browsertest.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();

			//WebDriver chrome = new ChromeDriver();

			ChromeOptions options = new ChromeOptions();

	        options.setHeadless(false);

	        WebDriver delegate = new ChromeDriver(options);

	        Config config = ConfigFactory.parseResources("healenium.properties")

	                .withValue("heal-enabled", ConfigValueFactory.fromAnyRef(true)).resolve();

	        SelfHealingEngine engine = new SelfHealingEngine(delegate, config);

	        driver = SelfHealingDriver.create(engine);

	        driver.manage().window().maximize();
		}
		else if (browsertest.equalsIgnoreCase("FireFox"))
		{
			WebDriverManager.firefoxdriver().setup();

			driver = (SelfHealingDriver) new FirefoxDriver();

			driver.manage().deleteAllCookies();

			driver.manage().window().maximize();
		}
		else if (browsertest.equalsIgnoreCase("Opera"))
		{
			WebDriverManager.operadriver().setup();

			driver = (SelfHealingDriver) new FirefoxDriver();

			driver.manage().deleteAllCookies();

			driver.manage().window().maximize();
		}
		else if (browsertest.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();

			driver = (SelfHealingDriver) new FirefoxDriver();

			driver.manage().deleteAllCookies();

			driver.manage().window().maximize();
		}
	}

	@AfterMethod
	public void quitBrowser()
	{
		driver.quit();

		extent.flush();
	}
}


