package test02;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class pagefact {
	
	
	WebDriver d;

	
	@FindBy(how=How.ID,using="user_login") 
	//@FindBy(id="user_login") 
	@CacheLookup
	WebElement username; 

	@FindBy(how=How.ID,using="user_pass")
	@CacheLookup
	WebElement password;

	@FindBy(how=How.XPATH,using=".//*[@id='wp-submit']")
	@CacheLookup
	WebElement submit_button;

	@FindBy(how=How.LINK_TEXT,using="Lost your password?")
	@CacheLookup
	WebElement forget_password_link;


	public void login_wordpress(String uid,String pass)
	{
	username.sendKeys(uid);
	password.sendKeys(pass);
	submit_button.click();
	}


	}


