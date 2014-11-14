/*
 * Shaun Mbateng
 * Minimum Average of Slice of Two
 * This program finds the position of the minimal average of slices in an array.
 * This program has an O(N^2) time complexity (Not Counting for Inputs).
 */
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class MinAvgTwoSlice 
{
	public static void main(String[] args) throws IOException
	{
		int minAvg; //Position of Minimal Average in Array
		int [] A; //Array of Values
		int t = 1; //Index Number When Printing Results
		Scanner filename  =  new Scanner(new FileReader("./src/Arrays.txt")); //Get File With Inputs
		AvgSlicer Numbs = new AvgSlicer(); //Class That Handles Slicing of Numbers
		
		while (filename.hasNext()) //Read Arrays in One At A Time
		{
			String [] arrtmp; //Inputs to be Stored in String Array
			String tmp = filename.nextLine().replace(" ", ""); //Current Line/Array
			int pos = tmp.length(); //Character Position in String, Starts At Length of String
			
			while (tmp.charAt(0)<'0' || tmp.charAt(0)>'9') //Remove Leading Non Numbers
				tmp = tmp.substring(1, pos--);
			while (tmp.charAt(--pos)<'0' || tmp.charAt(pos)>'9') //Remove Trailing Non Numbers
				tmp = tmp.substring(0, pos);

			arrtmp = tmp.split(",|\\;"); //Remove Delimiters, Convert to Array
			
			A = new int [arrtmp.length]; //Set Size to Length of arrtmp
			
			for (int i=0; i<A.length; i++) //Fill Array of Integers
				A[i] = Integer.parseInt(arrtmp[i]);
			
			minAvg = Numbs.getMinIndex(A); //Get Minimum Average from Array
			
			System.out.println("Minimum Average Index "+(t++)+": "+minAvg); //Print Minimum
		}
		
		filename.close(); //Input File No Longer Needed
	}
}
