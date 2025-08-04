package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	//Declaration Of the Elements
	WebDriver driver;

	@FindBy(xpath="//span//button[text()='Continue shopping']")
	private WebElement ContinueShoppingbtn;

	@FindBy(xpath="//*[@id=\"nav-link-accountList\"]/a")
	private WebElement helloSignInbtn;

	@FindBy(xpath = "//span[text()='Sign in']")
	private WebElement signInBtn;

	@FindBy(xpath="//*[@id=\"ap_email_login\"]")
	private WebElement EnterMobileNumberORemailtxt;

	@FindBy(xpath="//*[@id=\"continue\"]/span/input")
	private WebElement ClickonContinueButton;

	@FindBy(xpath="//*[@id=\"ap_password\"]")
	private WebElement EnterPasswordtxt;

	@FindBy(xpath="//*[@id=\"signInSubmit\"]")
	private WebElement ClickonSignInButton;

	//Initialization of Elements Using Constru
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}

	//Utilization of Elements
	public WebElement ContinueShoppingbtn() {
		return ContinueShoppingbtn;
	}
	public WebElement helloSignInbtn() {
		return helloSignInbtn;
	}
	public WebElement signInBtn() {
		return signInBtn;
	}
	public WebElement EnterMobileNumberORemail(String USERNAME){
		return EnterMobileNumberORemailtxt;
	}

	public WebElement ClickonContinueButton(){
		return ClickonContinueButton;
	}
	public WebElement EnterPassword(String PASSWORD){
		return EnterPasswordtxt;
	}
	public WebElement ClickonSignInButton(String username, String password){
		return ClickonSignInButton;
	}

	//Business Library of the elements
	public void ContinueShopping() {
//		ContinueShoppingbtn.click();
		try {
			ContinueShoppingbtn().click(); // Safe to ignore if not visible
		} catch (Exception e) {
			System.out.println("No continue shopping button to click.");
		}
	}

	public void helloSignIn()  {
		Actions actions = new Actions(driver); // 'driver' should be your WebDriver instance
		actions.moveToElement(helloSignInbtn).build().perform();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void signIn()  {
		signInBtn.click();

	}
	public void EnterMobileNumberORemailTxt(String userName) {
		EnterMobileNumberORemailtxt.sendKeys(userName);

	}
	public void ClickonContinueBTN() {
		ClickonContinueButton.click();

	}
	public void EnterPasswordTxt(String password) {
		EnterPasswordtxt.sendKeys(password);

	}
	public void ClickonSignInBTN() {
		ClickonSignInButton.click();

	}
}
