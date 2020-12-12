import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * 
 * Selenium 4.0 Important Features
 */
public class MultipleWindowsDemo {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver", "D:\\Personal_docs\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		//Opening New tab
		driver.switchTo().newWindow(WindowType.TAB);
		
		//Getting the number of windows currently opened
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> it = handles.iterator();
		String parentWindowId = it.next();
		String childWindow = it.next();
		
		//The below command will shift it's focus to the new Tab Opened
		driver.switchTo().window(childWindow);
		driver.get("https://rahulshettyacademy.com/#/index");
		//Getting the name of the first course
		String courseName = driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']"))
		.get(1).getText();
		//Again switching back to parent tab
		driver.switchTo().window(parentWindowId);
		//Populating the Name TextBox with courseName grabbed 
		WebElement name = driver.findElement(By.xpath("//input[@name='name']"));
		name.sendKeys(courseName);
		//Getting screenshot of a webElement.Introduced in Version 4.0
		File file = name.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("D://logo.png"));
		
		//Get Height,Width of WebElement using Selenium
		System.out.println(name.getRect().getDimension().getHeight());
		System.out.println(name.getRect().getDimension().getWidth());
	}

}
