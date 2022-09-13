package orangeCRM.orangeCRM;
import java.awt.Robot;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.testng.annotations.Parameters;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import org.testng.annotations.Test;

import methods.methods;
import pages.pages;

//Author: Benito Paul G J
//HR: Divya Srinivasan
//Date given: 12-sep-2022 9:30 PM


// from the below code the Testcase gets started
// All the methods mentioned in this class are derived from its child class "methods"
public class components extends methods {
	@Test
	@Parameters({"UserName","Password","LName"})
	public void test(String Name, String pwd, String lname) throws FileNotFoundException, IOException
	{
		Properties sysProperty = new Properties();
		sysProperty.load(new FileInputStream(new File("./configs/properties.properties")));
		
		try
		{
			
			
			int total_steps = 5;
				System.out.println(" Orange HRM Page Automation by Benito Paul G J");

				for (int i = 1; i <= total_steps; i++) 
				{
					switch (i) {

					case 1:
						System.out.println("Open Orange HR page");
						//Launch url in browser
						OpenBrowser(sysProperty.getProperty("url"));
						pageloadcheck(pages.OrangeEle("username"));
						break;
					case 2:
						//Login with admin username and password
						System.out.println("Login");
						sendkeys(pages.OrangeEle("username"),sysProperty.getProperty("Username"));
						sendkeys(pages.OrangeEle("password"),sysProperty.getProperty("password"));
						click(pages.OrangeEle("SignIn"));
						break;
					case 3:
						
						//create user
						System.out.println("Create user");
						pageloadcheck(pages.OrangeEle("createuser"));
						click(pages.OrangeEle("createuser"));
						pageloadcheck(pages.OrangeEle("fname"));
						sendkeys(pages.OrangeEle("fname"),Name);
						sendkeys(pages.OrangeEle("lname"),lname);

						//create user login details
						click(pages.OrangeEle("clogin"));
						
						sendkeys(pages.OrangeEle("cusername"),Name);
						sendkeys(pages.OrangeEle("cpass"),pwd);
						sendkeys(pages.OrangeEle("conpass"),pwd);
						
						sendkeys(pages.OrangeEle("empid"),"123");
						
						click(pages.OrangeEle("sbutton"));
						pageloadcheck(pages.OrangeEle("pdetails"));
						
						//logout from the admin user
						click(pages.OrangeEle("pclick"));
						click(pages.OrangeEle("logout"));
						
						break;
					case 4:
						//Login with the new user created
						
						System.out.println("New User login");
						pageloadcheck(pages.OrangeEle("username"));
						sendkeys(pages.OrangeEle("username"),Name);
						sendkeys(pages.OrangeEle("password"),pwd);
						click(pages.OrangeEle("SignIn"));
						break;
					case 5:
						//uploading the documents
						
						System.out.println("Upload Docs");
						click(pages.OrangeEle("Add"));
						click(pages.OrangeEle("browse"));
						String path = System.getProperty("user.dir");
						 StringSelection s = new StringSelection(sysProperty.getProperty("testSupportfilespath"));
						Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s,null);
						Thread.sleep(2000);
						 Robot r = new Robot();
					      //pressing enter
					      r.keyPress(KeyEvent.VK_ENTER);
					      //releasing enter
					      r.keyRelease(KeyEvent.VK_ENTER);
					      //pressing ctrl+v
					      r.keyPress(KeyEvent.VK_CONTROL);
					      r.keyPress(KeyEvent.VK_V);
					      //releasing ctrl+v
					      r.keyRelease(KeyEvent.VK_CONTROL);
					      r.keyRelease(KeyEvent.VK_V);
					      //pressing enter
					      r.keyPress(KeyEvent.VK_ENTER);
					      //releasing enter
					      r.keyRelease(KeyEvent.VK_ENTER);
						
						
						
						//clicking save 
					      click(pages.OrangeEle("savef"));
					      
					      
					default:
						System.out.println(" please check the above code");
						break;
					}
				
				}
		}	
		catch(Exception e)
		{
			System.out.println("Exception occurred  in switch is "+e);
		}
			
		}
	}
		
		
		
		
