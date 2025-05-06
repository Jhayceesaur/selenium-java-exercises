import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class GrabTextAssignment 
{
	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		driver.findElement(By.id("checkBoxOption3")).click();
		
		//Get and print the checkbox label
		WebElement checkbox = driver.findElement(By.cssSelector("label[for='honda']"));
		String labelText = checkbox.getText();
		System.out.println("Text: " + labelText);
		
		//Check if value of checkbox label is existing in the dropdown. If yes, then select
		driver.findElement(By.name("dropdown-class-example")).click();
		Select dropDown = new Select (driver.findElement(By.name("dropdown-class-example")));
		dropDown.selectByContainsVisibleText(labelText);
		
		//Input the checkbox label to the text field
		Actions a = new Actions(driver);
		WebElement inputText = driver.findElement(By.name("enter-name"));
		a.moveToElement(inputText).click().sendKeys(labelText).build().perform();
		
		//Verify if alert message contains the checkbox label
		driver.findElement(By.id("alertbtn")).click();
		Alert alertText = driver.switchTo().alert();
		String actualAlert = alertText.getText();
		System.out.println("Alert text: " + actualAlert);
		Assert.assertTrue(actualAlert.contains(labelText));
	}
}
