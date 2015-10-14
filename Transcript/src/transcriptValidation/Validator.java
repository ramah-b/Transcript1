package transcriptValidation;

import java.util.Scanner;

public class Validator {
	public static String getString(Scanner sc, String prompt)
	{
		
		
	    System.out.print(prompt);
	    String s = sc.next(); 
	    sc.nextLine();
	    return s;
	 
	}
	
	public static int getInt(Scanner sc, String prompt)
	{
	    int i = 0;
	    boolean isValid = false;
	    while (isValid == false)
	    {
	        System.out.print(prompt);
	        if (sc.hasNextInt())
	        {
	            i = sc.nextInt();
	            isValid = true;
	        }
	        else
	        {
	            System.out.println("Error! Invalid integer value. Try again.");
	        }
	        sc.nextLine();  // discard any other data entered on the line
	    }
	    return i;
	}

	public static int getInt(Scanner sc, String prompt,
	int min, int max)
	{
	    int i = 0;
	    boolean isValid = false;
	    while (isValid == false)
	    {
	        i = getInt(sc, prompt);
	        if (i <= min || i >= max)
	            System.out.println(
	                "Error! Number must be less than " + max + ".");
	        else
	            isValid = true;
	    }
	    return i;
	}

}
