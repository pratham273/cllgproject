package pkg;
import java.io.*;

import java.util.Scanner;

public class Login {
	
	String username;
	String password;
	
	
	public void setDetails(String username, String password)
	{
		this.username = username;
		this.password = password;
	}
	
	public String getDetails()
	{
		return this.username;
	}

	
	public void checkCredentials(String username, String password)
	{
		File tempFile = new File(username + ".txt");
		
		if(tempFile.exists())
		{
			BufferedReader br;
			
			try
			{
				br = new BufferedReader(new FileReader(username + ".txt"));
				String a = br.readLine();
				br.close();
				
				if(a.equals(password))
				{
					System.out.println("Successful Login");
				}
				
				else
				{
					System.out.println("Wrong Password");
				}
				
			}
			catch(FileNotFoundException e)
			{
				System.out.println("File Not Found!");
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
		
		else
		{
			Scanner sc = new Scanner(System.in);
			System.out.println("Please sign up first");
			System.out.println("Enter Username");
			String username1 = sc.nextLine();
			
			
			System.out.println("Enter password");
			String password1 = sc.nextLine();
			this.signUp(username1,password1);
		}
	}
	
	
	public void signUp(String username,String password)
	{
		File tempFile = new File(username + ".txt");
		
		
		if(tempFile.exists())
		{
			System.out.println("Username already exists");
		}
		
		else
		{
			try
			{
				tempFile.createNewFile();
				FileWriter fw = new FileWriter(tempFile);
				fw.write(password);
				fw.close();
				System.out.println("SignUp Successful");
			}
			
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
	}
	
	
}
	
	
	






class Logintest{
	
	String username2;
    
    public void runlogin(){
        Login login = new Login();    
    System.out.println("1.sign in \n2.sign up(create account) \n3.press '0' to exit the program");

    
    Scanner option = new Scanner(System.in);
    int b = option.nextInt(); 
    
    
     if(b == 0){
        System.exit(0);
    }
    else{
        System.out.println("enter your username: ");
    Scanner sc = new Scanner(System.in);
    String username = sc.nextLine();
    this.username2 = username;
    
   
    
    
    
    
/*    Console console = System.console();
    char[] password1 = console.readPassword("enter the password: ");
    
    String password = String.valueOf(password1); */
    
     System.out.println("Enter password : ");
     String password = sc.nextLine();
     
        login.setDetails(username, password);
        
       

    if(b == 1){
        login.checkCredentials(username, password);

    }
    else if(b == 2){
        login.signUp(username, password);
    }
    
    }
    
    
    
    
    }
    
    
    public String getDetails()
    {
    	String user = this.username2;
    	//System.out.println(user);
    	return user;
    	
    }
}