package StepDefinitions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class LoginStepDefinition {
	WebElement element;
	WebDriver driver;
	static Properties prop;
	WebElement ele;

	static {
		InputStream is;
		try 
		{
			is = new FileInputStream(System.getProperty("user.dir")+"//src//main//resources//OR.properties");
			prop = new Properties();
			prop.load(is);
		} catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} catch (IOException e) 
		{

			e.printStackTrace();
		}


	}

	//unitary methods only 

	@Given("^Application \"(.*)\" is launched$")
	public void loginPage(String appName)
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\leo\\Downloads\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.walmart.ca/en");
	}

	@When("^Verify title of page is \"(.*)\"$")
	public void checkTitle(String actualTitle)
	{
		String expectedTitle = driver.getTitle();
		System.out.println(expectedTitle);
		if(expectedTitle.contains(actualTitle))
			System.out.print("The title of the page is "+expectedTitle);
		else {
			System.out.print("The title of the page is wrong i.e. "+expectedTitle);
		}
	}

	@Then("^User enters \"(.*)\" on \"(.*)\" element$")
	public void enterTextInElement(String value,String elementLocator) //TBC
	{
		getWebElementAndSendKeys(value, elementLocator);
	}

	@Then("^User hovers over \"(.*)\"$")
	public void hoversOnElement(String locator) //TBC
	{
		element= getWebElement(locator);
		Actions action = new Actions(driver);      //TBC
		action.moveToElement(element).click().build().perform();

	}


	@Then("^User clicks on \"(.*)\" button$")
	public void elementClick(String locator)
	{
		element = getWebElement(locator);
		element.click();
	}

	@Then("^User is on the home page$")
	public void homePage()
	{

		String title = driver.getTitle();
		System.out.print("The user is on the home page "+title);
	}


	@Then("^User closes the browser$")
	public void quitBrowser()
	{
		driver.quit();
	}


	public WebElement getWebElement(String locator)
	{
		By by = By.xpath(prop.getProperty(locator));
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(by));

		ele = driver.findElement(by); 
		return ele;
	}

	public void getWebElementAndSendKeys(String value, String locator)
	{
		ele = getWebElement(locator);
		ele.sendKeys(value);
		ele.sendKeys(Keys.ENTER);
	}



}
