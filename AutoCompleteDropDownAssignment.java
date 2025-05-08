import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoCompleteDropDownAssignment 
{
	public static void main(String[] args) 
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.findElement(By.cssSelector("#autocomplete")).sendKeys("phi");
		List <WebElement> countryList = driver.findElements(By.cssSelector(".ui-menu-item-wrapper"));
		
		for (WebElement option : countryList) 
		{
			if(option.getText().equals("Philippines")) 
			{
				option.click();
				break;
			}
		}
	}
}
