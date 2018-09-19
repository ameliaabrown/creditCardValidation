import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class CreditCardValidation {
	static long [] userNumberArray = new long [16];
	static int userChoice;
	
public static void main(String[] args) throws IOException
{
	pathOne();
	pathTwo();

		//pick a path
			Scanner userPath = new Scanner(System.in);
			System.out.println("1. Would you like to enter a credit card number to check?" 
							+ " OR 2. Would you like to import a text file to check?");
			int userChoice = userPath.nextInt();
			long [] userNumberArray = new long [16];
	
	if (userChoice == 1)
	{
		pathOne();
	}
	else 
	{
		pathTwo();
	}
	
}
public static void pathOne()
{
	if (userChoice == 1)
		{
			
			System.out.println("Please enter your credit card number below.");
			Scanner userInput = new Scanner(System.in);
			long userNumber = userInput.nextLong();
			
			for (int i = 15; i >= 0; i--)
			{
				long originalDigitStrip = userNumber %10;
				userNumberArray [i] = originalDigitStrip;
				userNumber = userNumber/10;
				//System.out.println(userNumberArray[i]);
			}
			
			
	

			for (int i = 0; i < 16; i = i+2)
			{
				userNumberArray[i] = userNumberArray[i] *2; 
				//System.out.println(userNumberArray[i]);
				
			}
			
	
			// add up doubled numbers 
			for (int i = 0; i < 16; i++)
			{
				if (i%2 == 0)
				{
					if (userNumberArray[i] > 9)
					{
						long secondDigit = userNumberArray[i] % 10;
						long firstDigit = (int) userNumberArray[i] / 10;
						long addDigits = secondDigit + firstDigit;
						userNumberArray[i] = addDigits;
					
					}
				}
			}
				//System.out.println(Arrays.toString(userNumberArray));
			
			//find the sum 
			long sum = 0;
			for (int i = 0; i < 16; i++)
			{
				sum = sum + userNumberArray[i];
			}
			//System.out.println("The sum is " + sum);
	
			
			//tell them if number is valid 
			if (sum%10 == 0)
			{
				System.out.println("Your credit card number is valid.");
			}
			else
			{
				System.out.println("Your credit card number is not valid.");
			}
		
		}
}

public static void pathTwo() throws IOException
	{
		
		if (userChoice == 2)
		{
			Scanner importedCardNumbers = new Scanner (new File ("creditCardNumbers.txt"));
			while(importedCardNumbers.hasNext())
			{
			System.out.println(importedCardNumbers.next());
			}
			
		}
		
	
	}
}

				

