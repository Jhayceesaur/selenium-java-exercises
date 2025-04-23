import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class EndToEndTestingExercise 
{
	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click(); //Select 'From' destination 
		driver.findElement(By.xpath("//a[@value='BLR']")).click(); //Select Bengaluru (BLR)
		System.out.println(driver.findElement(By.xpath("//a[@value='BLR']")).getText()); //Print selected from location
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a[@value='HKG'])[2]")).click(); //Select Hongkong (HKG) in 'To' destination
		System.out.println(driver.findElement(By.xpath("(//a[@value='HKG'])[2]")).getText()); //Print selected to location
		
		driver.findElement(By.cssSelector("a[class='ui-state-default ui-state-active']")).click(); //Click current date for departure
		
		Thread.sleep(1000);
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click(); //Select Round Trip radio button
		
		//Verify if Return Date CalendarUI is enabled or disabled
		if (driver.findElement(By.id("Div1")).getDomAttribute("style").contains("0.5"))
		{
			System.out.println("Warning! Calendar UI Enabled");
			Assert.assertTrue(true);
		}
		
		else 
		{
			Assert.assertTrue(false);
		}
		
		driver.findElement(By.id("divpaxinfo")).click(); //Click Passengers drop down
		Thread.sleep(1000);
		
		//Adding Passengers 9 times
		for (int passenger = 1; passenger < 9; passenger++) 
		{
			driver.findElement(By.id("hrefIncAdt")).click();
		}
		
		driver.findElement(By.id("btnclosepaxoption")).click(); //Click Done button
		Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "9 Adult"); //Verify if 9 passengers were added
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText()); //Print how many passengers were added
		
		//Handling static Currency drop down
		WebElement currency = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select currencyDropdown = new Select(currency);
		currencyDropdown.selectByValue("USD");
		System.out.println(currencyDropdown.getFirstSelectedOption().getText()); //Print selected option in Currency drop down
		
		driver.findElement(By.name("ctl00$mainContent$chk_friendsandfamily")).click(); //Select Family and Friends checkbox
		Assert.assertTrue(driver.findElement(By.name("ctl00$mainContent$chk_friendsandfamily")).isSelected()); //Verify if Family and Friends was selected
		
		driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click(); //Click Search button
	}
}
