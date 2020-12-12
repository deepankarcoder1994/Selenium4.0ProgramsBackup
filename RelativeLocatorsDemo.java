import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.withTagName;

/*
 * 
 * Selenium Version 4.0.0-alpha-7 demo 
 * 
 */

public class RelativeLocatorsDemo {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\Personal_docs\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		//Test Case 1 :: Find the Label Name which is above Name Text Box
		WebElement nameEditBox = driver.findElement(By.xpath("//input[@name='name']"));
		//above():Element located above with respect to the specified Element.
		System.out.println(driver.findElement(withTagName("label").above(nameEditBox)).getText());
		
		//Test Case 2 :: Find the Date of Birth Text box which is below Date of Birth Label
		WebElement dateofBirth = driver.findElement(By.xpath("//label[@for='dateofBirth']"));
		//below():Element located below with respect to the specified Element
		driver.findElement(withTagName("input").below(dateofBirth)).sendKeys("02/02/2020");
		
		
		//Test Case 3:: Check the checkbox which is left of the text called "Check me out if you Love IceCreams!"
		WebElement label = driver.findElement(By.xpath("//label[@for='exampleCheck1']"));
		//toLeftOf():Element located toLeftOf with respect to the specified Element
		driver.findElement(withTagName("input").toLeftOf(label)).click();
		
		
		//Test Case 4 :: Check the radio button to the right of the label Employment Status.
		WebElement employmentlabel = driver.findElement(By.xpath("//label[@for='exampleFormControlRadio1']"));
		driver.findElement(withTagName("input").toRightOf(employmentlabel)).click();
	}

}
