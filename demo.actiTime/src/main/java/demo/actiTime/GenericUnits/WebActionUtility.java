package demo.actiTime.GenericUnits;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebActionUtility 
{
	WebDriver driver;
	JavascriptExecutor js;
	Actions action;

	public WebActionUtility(WebDriver driver) 
	{
		this.driver = driver;
		js = (JavascriptExecutor)driver;
		action = new Actions(driver);
	}
	
	public void enterData(WebElement targetElement,String KeysToEnter)
	{
		targetElement.clear();
		targetElement.sendKeys(KeysToEnter);
	}
	
	public void clickOnElement(WebElement targetElement)
	{
		targetElement.click();
	}
	
	public void jsClick(WebElement targetElement)
	{
		js.executeAsyncScript("arguments[0].click()", targetElement);
	}
	
	public void enterJsData(WebElement targetElement,String KeysToEnter)
	{
		js.executeAsyncScript("arguments[0].value='"+KeysToEnter+"'", targetElement);
	}
	
	public void mouseHovering(WebElement targetElement)
	{
		action.moveToElement(targetElement).perform();
		action.click();
	}
	
	public void rightClick(WebElement targetElement)
	{
		action.contextClick(targetElement).perform();
	}
	
	public void doubleClick(WebElement targetElement)
	{
		action.doubleClick(targetElement).perform();
	}
	
	public void dragAndDrop(WebElement source,WebElement destination)
	{
		action.dragAndDrop(source, destination).perform();
	}
	
	public void WaitAndClick(WebElement targetElement)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(targetElement));
		targetElement.click();
	}
	
	public void switchToFrame(int index)
	{
		driver.switchTo().frame(index);
	}
	
	public void switchToFrame(String idOrName)
	{
		driver.switchTo().frame(idOrName);
	}
	
	public void switchToFrame(WebElement targetElement)
	{
		driver.switchTo().frame(targetElement);
	}
	
	public List<WebElement> getDropDownElement(WebElement dropDown)
	{
		Select select = new Select(dropDown);
		return select.getOptions();
	}
	
	public void selectUsingValue(WebElement dropDown,String valueText)
	{
		Select select = new Select(dropDown);
		select.selectByValue(valueText);
	}	
}
