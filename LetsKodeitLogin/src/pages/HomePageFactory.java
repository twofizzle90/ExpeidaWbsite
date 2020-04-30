package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePageFactory {
		WebDriver driver;
//Test
		@FindBy(id="user_email")
		WebElement enterid;
		
		@FindBy(id="user_password")
		WebElement EnterPassword;
		
		@FindBy(name="commit")
		WebElement LoginButton;
		
		@FindBy(xpath="//div[@class='alert alert-danger']")
		WebElement heading;
		
		@FindBy(xpath=("//html/body/div/div/div/div/div/div/h1"))
		WebElement pageTittle;
		
		@FindBy(id=("DrpDwnMn04bg"))
		WebElement LoginPage;
	
		
		
		public HomePageFactory(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
		public void enterEmail(String email) {
			enterid.sendKeys(email);
		}
		
			
		public void EnterPassword(String password) {
			EnterPassword.sendKeys(password);
		}
		
		public void clickOnLogin () {
			LoginButton.click();
		}
		
		public boolean LoginIntoPage() {
			return heading.getText().toString().contains("Invalid email or password.");
		}
		
		public String getTittle() {
			return pageTittle.getText();
			
		}
		
		public void clickLoginPage() {
			LoginPage.click();
			
		}
		
}
