package pkg;
import java.io.*;
import java.util.*;









public class Issue extends Logintest
{
	int avail;
	String bookName;
	String bookId;
	int quantity;
	String usernm;
	
	
	
	ArrayList <String>lst2	= new ArrayList<String>();
	
	
	public void setDetails(Logintest loginhere)
	{
		//this.bookName = bookName;
		this.avail = 0;
		
		
		this.usernm = loginhere.getDetails();
		//System.out.println(this.usernm);
		//System.out.println(usernm);
		
	}
	

	
	
	public void showAvail() 
	{
		try 
		{
			FileReader tempFile = new FileReader("books.txt");
			BufferedReader br;
			br = new BufferedReader(tempFile);
			String str;
			System.out.println("Book ID	    Book Name           Quantity"); 
			while((str=br.readLine())!=null)
			{
				System.out.println(str + "         " + br.readLine() + "           " + br.readLine());
		
			}
			
			br.close();
			
			FileReader tempFile2 = new FileReader("books.txt");
			BufferedReader br2;
			br2 = new BufferedReader(tempFile2);
			String str2;
			
			while((str2=br2.readLine())!=null)
			{
				lst2.add(str2);
				
			}
			
			//System.out.println(lst2);
			
			br2.close();
			
			
			
		
			
			
			
			
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
	
	
	public void checkAvail(String bookId)
	{
		try 
		{
			FileReader tempFile = new FileReader("books.txt");
			BufferedReader br;
			br = new BufferedReader(tempFile);
			String str;
			
			FileReader tempFile2 = new FileReader(this.usernm + ".txt");
			BufferedReader br3 = new BufferedReader(tempFile2);
			
			String str4;
			int alreadyhave = 0;
			while((str4=br3.readLine())!=null)
			{
				if(str4.equals(bookId))
				{
					alreadyhave = 1;
				}
			}
		
			
			
			while((str=br.readLine())!=null)
			{
				
				
				if(bookId.equalsIgnoreCase(str))
				{
					
					this.bookId = str;
					this.bookName = br.readLine();
					this.quantity = Integer.parseInt(br.readLine());
					//System.out.println(this.bookId);
				
					avail = 1;
					
				}
				
				
				
		
			
			}
			
			
			
			
		
			
			if(avail == 0)
			{
				System.out.println("Book Not Available");
			}
			
			else if(alreadyhave == 1)
			{
				System.out.println("Book Already Issued");
			}
			
			
			else if(avail == 1 && alreadyhave != 1)
			{
				
				//System.out.println("Book Issued");
				
				
				
				
				
				
				
				this.bookIssue(this.bookName);
				
				System.out.println("Do you want to issue more books(Y/N)");
				Scanner sc = new Scanner(System.in);
				char st = sc.next().charAt(0);
				avail = 0;
				
				if(st == 'Y' || st == 'y')
				{
				System.out.println("Enter the Id of the Book you want to issue : ");
				Scanner sc2 = new Scanner(System.in);
				
				String bookid1 = sc2.nextLine();
				
				checkAvail(bookid1);
				}
             }

		/*		
			else
			{
					System.exit(0);
			}
		*/	
			br.close();
				
		
			
			
		}
		catch(FileNotFoundException e)
		{
			System.out.println("File Not Found");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	
		
	}
		
		public void bookIssue(String bookName1) throws IOException
		{
			if(this.quantity == 0)
			{
				System.out.println("Book is Unavailable");
			
			}
			
			else
			{
				
				FileWriter fw2 = new FileWriter("books.txt");
				BufferedWriter bw2;
				bw2 = new BufferedWriter(fw2);
				
				
				
				this.quantity--;
				String str1 = Integer.toString(this.quantity);
				//System.out.println(lst2.get(3));
				//System.out.println(lst2.size());
				//System.out.println(lst2.get(5));
				
				for(int j=0;j<lst2.size();j++)
				{
					if((this.bookId).equals(lst2.get(j)))
					{
						lst2.set(j+2, str1);
						
						
					}
					
				}
				
			
				
				
				for(int i=0;i<lst2.size();i++)
				{
					bw2.write(lst2.get(i) + "\n");
				}
				
				
				bw2.close();
				
				
				System.out.println("Book Issued");
				
				
				try 
				{
					
				
					
					
					File file = new File(this.usernm + ".txt");
					FileWriter fr = new FileWriter(file, true);
					fr.write("\n");
					fr.write(bookId);
			    	fr.close();
			    	//System.out.println(lst2);
					
					
				
					
			
					
				}
				catch(Exception e)
				{
					System.out.println("File Not Found");
				}
				
			}
			
			
			
			
			
		}
		
		




	public void runissue() {
		
		this.showAvail();
		System.out.println("Enter the Id of the Book you want to issue : ");
		Scanner sc = new Scanner(System.in);
		String bookname1 = sc.nextLine();
		//issue.setDetails();
		this.checkAvail(bookname1);
		
		
		
		
	}


}
