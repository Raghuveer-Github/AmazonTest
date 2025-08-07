package AmazonDashboard;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import GenericLibrary.BaseClass;

public class DashboardFeatures extends BaseClass {

	@Test
	public void dashbordTest() throws Throwable{


		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		

		wait.until(ExpectedConditions.titleContains("Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in"));

		String actualTitle = driver.getTitle();
		System.out.println("Page Title:" + actualTitle);
		Thread.sleep(2000);

		// Assertion - Adjust expected title as per the real title
		Assert.assertTrue(actualTitle.contains("Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in"), "Title does not contain expected text.");
	

		WebElement hamburgerMenu = wait.until(ExpectedConditions.elementToBeClickable(By.id("nav-hamburger-menu")));
		Thread.sleep(2000);
		hamburgerMenu.click();

		WebElement mobilesComputers =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='hmenu-content']//section[3]//ul/li[1]/a")));
		//		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)", mobilesComputers);
		mobilesComputers.click();
		Thread.sleep(2000);
	
		// Wait for "All Mobile Phones" to become visible and clickable
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement allMobilePhones = wait1.until(ExpectedConditions.elementToBeClickable(
		    By.xpath("//a[text()='All Mobile Phones']")));

		// Scroll into view if needed (some items are hidden below fold)
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", allMobilePhones);

		// Try normal click
		try {
		    allMobilePhones.click();
		} catch (ElementClickInterceptedException e) {
		    // Fallback to JS click if normal click fails
		    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", allMobilePhones);
		}
		Thread.sleep(2000);


		WebElement Apple_iPhone15_128GB_Black = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//img[@alt='Apple iPhone 15 (128 GB) - Black']) [position()=3]")));
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true)",Apple_iPhone15_128GB_Black);
		Thread.sleep(2000);
		Apple_iPhone15_128GB_Black.click();
		Thread.sleep(5000);

	
		
			WebElement AddToCartButton = driver.findElement(By.xpath("(//input[@id='add-to-cart-button']/parent::span[@class='a-button-inner'])[position()=2]")); 
			Thread.sleep(1000);
			Actions actions = new Actions(driver);
			actions.moveToElement(AddToCartButton).build().perform();
		    AddToCartButton.click();

		
		try {
			WebElement closePopup = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@aria-label='Exit this panel and return to the product page.']")));
			closePopup.click();
			Thread.sleep(1000);
		} catch (Exception e) {
			System.out.println("No close button appeared.");
		}


		WebElement Cart = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("nav-cart")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", Cart);
		Thread.sleep(5000);
		Cart.click();
		
		WebElement removeFromCart= driver.findElement(By.xpath("//fieldset[@data-decrementlabel='Delete OnePlus 13 | Smarter with OnePlus AI | Lifetime Display Warranty (12GB RAM, 256GB Storage Black Eclipse)']//span[@class='a-icon a-icon-small-trash']"));
		removeFromCart.click();
		Thread.sleep(2000);
	}

}
