package pkg;
import java.io.*;
import java.util.Scanner;
import java.util.*;
public class Return extends Logintest {
	
	String bookName;
	String bookId;
	int quantity;
	String username2;
	
	
	ArrayList <String>lst = new ArrayList<String>();
	
	
	public void setDetails(Logintest loginhere)
	{
		//this.bookName = bookName;
		
		
		
		this.username2 = loginhere.getDetails();
		//System.out.println(this.usernm);
		//System.out.println(usernm);
		
	}
	
	public void booksuserhas()
	{
		try 
		{
			FileReader tempFile = new FileReader(this.username2 + ".txt");
			BufferedReader br;
			br = new BufferedReader(tempFile);
			String str;
			//br.readLine();
			System.out.println("The Books User has : ");
			int i =0;
			while((str=br.readLine())!=null)
			{
				if (i!=0)
				{
				System.out.println(str);
				}
				i++;
				
				lst.add(str);
		
			}
			
		/*	for(int j=1;j<lst.size();j++)
			{
				System.out.println(lst.get(j));
			}
		*/
			br.close();
			

			
		}
		catch(FileNotFoundException e)
		{
			System.out.println("File Not Found");
		}
		catch(IOException e)
		{
			//
		}
		

	}
	
	
	public void deletebook()
	{
		
		
		try
		{
		String str3;
		System.out.println("Enter the book you want to delete : ");
		Scanner sc4 = new Scanner(System.in);
		str3 = sc4.nextLine();
		
		sc4.close();
		lst.remove(str3);
		
		
		
		FileWriter fw2 = new FileWriter(this.username2 + ".txt");
		BufferedWriter bw2;
		bw2 = new BufferedWriter(fw2);
		for(int i=0;i<lst.size();i++)
		{
			bw2.write(lst.get(i) + "\n");
			
		}
		bw2.close();
		
		
		
		
		
		}
		
		catch(FileNotFoundException e)
		{
			System.out.println("File Not Found");
		}
		catch(IOException e)
		{
			//
		}
		catch(NoSuchElementException e)
		{
			System.out.println("");
		}
		
	}
}


