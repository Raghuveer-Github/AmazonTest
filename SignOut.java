package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class SignOut {

	//Declaration of the Elements
	WebDriver driver;
	
	//ManageProfile
	@FindBy (xpath="//*[@id=\"nav-link-accountList\"]")
	private WebElement MouseHovertonManageProfileBtn;
	
	//Sign Out
	@FindBy (xpath="//*[@id=\"nav-item-signout\"]")
	private WebElement ClickonSignOut;
	
	//Initialization of Elements Using Constructor
  	public SignOut(WebDriver driver) {
  		this.driver = driver;
  		PageFactory.initElements(driver,this);
  	}
  	
  //Utilization of Elements
  	public WebElement ClickOnManageProfileBtn(){
  		return MouseHovertonManageProfileBtn;
  	}
  	
  	public WebElement ClickonSignOut() {
  		return ClickonSignOut;
  	}
  	
  //Business Library of the elements

  	public void MouseHoverToProfileLogo(){

  		Actions actions = new Actions(driver); // 'driver' should be your WebDriver instance
	    actions.moveToElement(MouseHovertonManageProfileBtn).build().perform();
	    try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
  	}

  	public void ClickOnSignOutLink(){
  		ClickonSignOut.click();
  	}
  	
}
