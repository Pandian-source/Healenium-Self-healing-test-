package Locators;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage
{

    @FindBy(how=How.XPATH, using="//button[@type='submit']")
	public static WebElement submit;

	@FindBy(how=How.XPATH, using="//input[@placeholder='Enter Your Email*']")
	public static WebElement Username;

	@FindBy(how=How.XPATH, using="//input[@placeholder='Enter Password*']")
	public static WebElement Password;

	@FindBy(how=How.XPATH, using="//a[contains(.,'Hotels')]")
	public static WebElement Hotel;

}
