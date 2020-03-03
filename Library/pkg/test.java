package pkg;
/*
 
import pkg.Login.*;
import pkg.Issue.*;
import java.io.*;
import java.util.*;


*/

import java.io.BufferedReader;

import java.io.Console;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;






class test{

	public static void main(String args[])
	{
		Logintest loginhere = new Logintest();
		

		for(;;)
		{
			Issue issue2 = new Issue();
			Return return2 = new Return();
			loginhere.runlogin();
			issue2.setDetails(loginhere);
			return2.setDetails(loginhere);

		for(;;)
		{


			System.out.println("1.Issue 2.Return 3.Check the books 4.Exit");
			Scanner sc = new Scanner(System.in);
			int option = sc.nextInt();
			
			

			if(option == 1)
			{
				
				
				

    
						issue2.runissue();


			}
			
			else if(option == 2)
			{
				
				return2.booksuserhas();
				return2.deletebook();
				
			}
			
			else if(option == 3)
			{
				Checkbookstest checkbk = new Checkbookstest();
				
				checkbk.runcheckbooks();
			}
		
			
			else
			{
				break;
			}
		}


		}

		}

	}
