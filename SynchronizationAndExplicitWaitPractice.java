	import java.time.Duration;
	import java.util.List;
	
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.chrome.ChromeOptions;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.Select;
	import org.openqa.selenium.support.ui.WebDriverWait;
	
	public class SynchronizationAndExplicitWaitPractice 
	{
		public static void main(String[] args) 
		{
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--incognito");
	
			WebDriver driver = new ChromeDriver(options);
			driver.manage().window().maximize();
			driver.get("https://rahulshettyacademy.com/loginpagePractise/");
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			
	
			String password = getPassword(driver);
			driver.findElement(By.cssSelector("#username")).sendKeys("rahulshettyacademy");
			driver.findElement(By.cssSelector("#password")).sendKeys(password);
			driver.findElement(By.xpath("(//span[@class='checkmark'])[2]")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='You will be limited to only fewer functionalities of the app. Proceed?']")));
			driver.findElement(By.id("okayBtn")).click();
			WebElement userAccess = driver.findElement(By.cssSelector("select[class='form-control']"));
			Select dropdown = new Select(userAccess);
			dropdown.selectByValue("teach");
			driver.findElement(By.id("terms")).click();
			driver.findElement(By.id("signInBtn")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='ProtoCommerce Home']")));
			//Add all items by clicking "Add" button on each item in the list
			List <WebElement> products = driver.findElements(By.cssSelector("button[class='btn btn-info']"));
			for(int i =0; i<products.size(); i++)
			{
				products.get(i).click();
			}
			driver.findElement(By.partialLinkText("Checkout")).click();}
	
		public static String getPassword (WebDriver driver) 
		{
			String passwordText = driver.findElement(By.cssSelector("p[class='text-center text-white']")).getText();
			// (username is rahulshettyacademy and Password is learning)
			String[] passwordArray = passwordText.split(" ");
			String password = passwordArray[6].split("\\)")[0];
			return password;
		}
	}
