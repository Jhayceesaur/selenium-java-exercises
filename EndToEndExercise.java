import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class EndToEndExercise 
{
	public static void main(String[] args) 
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("(//input[@name='name'])[1]")).sendKeys("Melody Alarva"); //Input Name
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("melodyalarva042017@gmail.com"); //Input Email
		driver.findElement(By.id("exampleInputPassword1")).sendKeys("yourPassword123!"); //Input Password
		driver.findElement(By.id("exampleCheck1")).click(); //Tick Checkbox
		
		//Select Female in dropdown options
		WebElement genderDropdown = driver.findElement(By.id("exampleFormControlSelect1"));
		Select dropDown = new Select(genderDropdown);
		dropDown.selectByVisibleText("Female");
		
		driver.findElement(By.id("inlineRadio1")).click(); //Select Student in radio button options
		
		driver.findElement(By.cssSelector("input[name='bday']")).sendKeys("07-16-1998"); //Input Birthday
		
		driver.findElement(By.cssSelector("input[class='btn btn-success']")).click(); //Click Submit button
		
		//Print the successful message
		WebElement successMsg = driver.findElement(By.cssSelector("div[class='alert alert-success alert-dismissible']"));
		System.out.println(successMsg.getText());
	}
}
