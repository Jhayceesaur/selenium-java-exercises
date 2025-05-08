import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTablesAssignment 
{
	public static void main(String[] args) 
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		List <WebElement> numColumns = driver.findElements(By.cssSelector("table tbody tr th"));
		int columnCount = numColumns.size();
		System.out.println("Column count is: " + columnCount);
		
		List <WebElement> numRows = driver.findElements(By.cssSelector(".table-display tr"));
		int rowCount = numRows.size();
		System.out.println("Row count is: " + rowCount);
		
		String instructor = driver.findElement(By.cssSelector(".table-display tr:nth-child(3) td:nth-child(1)")).getText();
		System.out.println("The instructor is: " + instructor);
		
		String course = driver.findElement(By.cssSelector(".table-display tr:nth-child(3) td:nth-child(2)")).getText();
		System.out.println("For the course: " + course);
		
		String price = driver.findElement(By.cssSelector(".table-display tr:nth-child(3) td:nth-child(3)")).getText();
		System.out.println("Which cost: $"+ price +" only");
	}
}
