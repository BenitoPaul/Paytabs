package pages;

import java.util.Hashtable;
//Author: Benito Paul G J
//HR: Divya Srinivasan
//Date given: 12-sep-2022 9:30 PM
public class pages {
	
	//This class contains all the DOM Web Elements
	
	public synchronized static String OrangeEle(String locator){

	Hashtable<String,String> PageHash= new Hashtable<String, String>();

	PageHash.put("username", "//input[@name='username']");
	PageHash.put("password", "//input[@name='password']");
	PageHash.put("SignIn", "//button[@type='submit']");
	PageHash.put("createuser", "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[1]/button");
	
	PageHash.put("fname", "//input[@name='firstName']");
	PageHash.put("lname", "//input[@name='lastName']");
	
	PageHash.put("clogin", "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[2]/div/label/span");
	
	PageHash.put("cusername", "//label[text()='Username']/parent::div//following-sibling::div//input");
	PageHash.put("cpass", "//label[text()='Password']/parent::div//following-sibling::div//input");
	PageHash.put("conpass", "//label[contains(text(),'Confirm Password')]/parent::div//following-sibling::div//input");
	
	PageHash.put("sbutton", "//button[@type='submit']");
	
	PageHash.put("pdetails", "//a[contains(text(),'Personal Details')]");
	PageHash.put("pclick", "//img[@alt='profile picture']");
	PageHash.put("logout", "//*[contains(text(),'Logout')]");
	PageHash.put("sbutton3", "//*[contains(text(),'Logout')]");
	
	PageHash.put("Add", "//button[@class='oxd-button oxd-button--medium oxd-button--text']");
	PageHash.put("browse", "//div[text()='Browse']");
	PageHash.put("sbuttons", "//button[@type='submit']");
	
	PageHash.put("empid", "//label[contains(text(),'Employee Id')]/parent::div//following-sibling::div//input");
	
	
	PageHash.put("savef", "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[3]/div/form/div[3]/button[2]");
	if(PageHash.get(locator)==null) {
		return null;
	}
	System.out.println("locator :"+locator);
	return PageHash.get(locator);
		
	}
	

}
