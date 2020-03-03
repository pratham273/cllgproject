package pkg;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class CheckBooks {
	
	String bookName;
	String bookId;
	int quantity;
	int avail = 0;
	
	public void checkAvail(String bookId)
	{
		try 
		{
			FileReader tempFile = new FileReader("books.txt");
			BufferedReader br;
			br = new BufferedReader(tempFile);
			String str;
		
			
			
			while((str=br.readLine())!=null)
			{
				if(bookId.equalsIgnoreCase(str))
				{
					//System.out.println("Book Available");
					this.bookName = str;
					//this.bookName = br.readLine();
					this.quantity = Integer.parseInt(br.readLine());
					//System.out.println(this.bookId);
					//System.out.println(this.bookName);
					//System.out.println(this.quantity);
				
					
					avail = 1;
					//System.exit(0);
					
				}
		
			}
			
			
			if(this.quantity == 0)
			{
				System.out.println("Book Not Available");
			}
			else if(avail == 0)
			{
				System.out.println("Book Not Available");
			}
				
			
			else
			{
				System.out.println("Book Available");
			}
			
			
			
			br.close();
			
		}
		catch(FileNotFoundException e)
		{
			System.out.println("File Not Found");
		}
		catch(NumberFormatException e)
		{
			System.out.println("");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	
		
	}

}


class Checkbookstest
{
	public void runcheckbooks()
	{
		CheckBooks checkbook = new CheckBooks();
		System.out.println("Enter Book you want to search");
		Scanner sc = new Scanner(System.in);
		String bookname2 = sc.nextLine();
		
		checkbook.checkAvail(bookname2);
		
		
	}
}
