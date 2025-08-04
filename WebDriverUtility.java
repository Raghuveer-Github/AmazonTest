package GenericLibrary;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class WebDriverUtility {


	//Method to Maximize the Window
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}

	//Method to Minimize the Window
	public void minimizeWindow(WebDriver driver)
	{
		driver.manage().window().minimize();
	}
	
	//Method to move to laptop screen(for multiMonitor)
	public void moveToLaptopScreen(WebDriver driver) {
		driver.manage().window().setPosition(new Point(0, 0));
		driver.manage().window().setSize(new Dimension(1366, 768));
	}
	
	//Method to move to laptop screen(for multiMonitor)
		public void moveToLeftMonitor(WebDriver driver) {
			driver.manage().window().setPosition(new Point(-1600, 0));
			driver.manage().window().setSize(new Dimension(1600, 900));
		}
	
	//Method to move to laptop screen(for multiMonitor)
		public void moveToRightMonitor(WebDriver driver) {
			driver.manage().window().setPosition(new Point(1366, 0));
			driver.manage().window().setSize(new Dimension(1920, 1080));
		}
		
	//Method to set specific size of window
	
	public void specificSize(WebDriver driver, int width, int height) {
		driver.manage().window().setSize(new Dimension(width,height));
	}
	

	//Method for implicit wait
	public void WaitForPageLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	//Method for Explicit Wait (element to be clickable)
	public void elementToBeClickable(WebDriver driver, WebElement element) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));

	}

	//Method for Explicit Wait (visibility of element)
	public void waitForElementToBeVisible(WebDriver driver, WebElement element) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	//Method for dropdown(selectByIndex)
	public void selectByIndex(WebElement element, int index) {
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}
	//Method for dropdown(deselectByIndex)
	public void deselectByIndex(WebElement element, int index) {
		Select sel = new Select(element);
		sel.deselectByIndex(index);
	}

	//Method for DropDown(select By Text)
	public void selectByText(WebElement element, String text) {
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}
	//Method for DropDown(deselect By Text)
	public void deselectByText(WebElement element, String text) {
		Select sel = new Select(element);
		sel.deselectByVisibleText(text);
	}

	//Method For DropDown(Select By Value)
	public void selectByValue(WebElement element, String value)
	{
		Select sel=new Select(element);
		sel.selectByValue(value);
	}	
	//Method For DropDown(Select By Value)
	public void deselectByValue(WebElement element, String value)
	{
		Select sel=new Select(element);
		sel.deselectByValue(value);
	}	

	//method for Mouse Hover Action
	public void mouseHoverAction(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).build().perform();
	}

	//Method for drag and drop action
	public void dragDrop(WebDriver driver, WebElement src, WebElement target) {
		Actions act = new Actions(driver);
		act.dragAndDrop(src, target).build().perform();
	}

	//Method for single click based on element
	public void clickAction(WebDriver driver, WebElement element) {
		element.click();
	}

	//Method for double click based on element
	public void doubleClickAction(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.doubleClick(element).build().perform();				}

	//Method for double click
	public void doubleClick(WebDriver driver) {
		Actions act = new Actions(driver);
		act.doubleClick().build().perform();
	}
	//Method for right click
	public void rightClick(WebDriver driver) {
		Actions act = new Actions(driver);
		act.contextClick().build().perform();
	}

	//Method for right Click based on element
	public void rightClick(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.contextClick(element).build().perform();
	}

	//Method for Enter the data in a text field by using keyboard functionality
	public void enterKeyPress(WebDriver driver) throws Throwable{
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ENTER).perform();
	}

	//Robot Class method to press Enter Key
	public void pressEnterKey(WebDriver driver) throws Throwable{
		Robot rb = new Robot();
		rb.keyPress(KeyEvent.VK_ENTER);
	}

	//This method will release Enter Key
	public void releaseEnterKey(WebDriver driver)throws Throwable{
		Robot rb = new Robot();
		rb.keyRelease(KeyEvent.VK_ENTER);
	}

	//Method to Switch to Window
	public void switchTowindow(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}

	public void switchToWindow(WebDriver driver, String nameOrId)
	{
		driver.switchTo().frame(nameOrId);
	}


	public void switchToWindow(WebDriver driver,WebElement address)
	{
		driver.switchTo().frame(address);
	}

	public void switchTowindows(WebDriver driver, String Partialwindowtitle) {

		//Step 1: use get window handles to capture all window
		Set<String> windows = driver.getWindowHandles();

		//Step 2: check whether there is a next window
		for(String winid : windows) {
			//Step 3: switch to current window and capture title
			// Step 4: Capture the title of the current window
			String currentwintitle = driver.switchTo().window(winid).getTitle();

			// Step 5: Check whether the current window title contains the expected partial title
			if(currentwintitle.contains(Partialwindowtitle)) {
				// Step 6: If it matches, stay in this window and exit the loop
				break;
			}
		}
	}

	//Method to get the screenshot
	public String getScreenshot(WebDriver driver, String screenShotName) throws Throwable{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String path = ".\\Screenshot\\"+screenShotName+".png";
		File dst = new File(path);
		Files.copy(src, dst);
		return dst.getAbsolutePath();
	}

	//Method for scroll action
	public void scrollAction(WebDriver driver)
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500);");
	}

	public void scrollAction(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("argument[0].scrollIntoView()", element);
	}


	//Method to click n Accept Alert
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}

	//Method to click on cancel alert
	public void cancelAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
}
