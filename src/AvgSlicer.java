/*
 * The class that solves for the starting position of the slice with the minimal average.
 * This assumes that 2<=A.length<=100,000, and that for each element in A, -10,000<=Ai<=10,000
 * This runs in O(N).
 */
class AvgSlicer 
{
	public int getMinIndex(int [] A)
	{
        //Edge Cases
		boolean same = true;
		int N = A.length;
        
        for (int i=1; i<N; i++) //Check if Array is Filled With Same Value
        {
            if (A[i]!=A[0])
            {
                same = false;
                break;
            }
        }
        
        if (same) //If So, Return 0
            return 0;
        
        double avg; //Current Average
        double minAvg = (A[0]+A[1])/2.0; //Minimum Average, Initialize to Average of Slice of First Two Elements
        int minAvgInd = 0; //Position of Minimum Average, Initialize to First Position
        
        for (int i=0; i<N-2; i++) //Check From First to Penultimate Element
        {
        	//Check Next Two Element Slice
        	avg = (A[i]+A[i+1])/2.0; //Get Current Average
        	
        	if (avg<minAvg) //If Current Average is Less Than Minimum
        	{
        		minAvg = avg; //Replace Minimum Average
        		minAvgInd = i; //Replace Position
        	}
        	
        	//Check Next Three Element Slice
        	avg = (A[i]+A[i+1]+A[i+2])/3.0; //Get Current Average
        	
        	if (avg<minAvg) //If Current Average is Less Than Minimum
        	{
        		minAvg = avg; //Replace Minimum Average
        		minAvgInd = i; //Replace Position
        	}
        }
        
        //Check Slice of Last Two Elements
        avg = (A[N-1]+A[N-2])/2.0; //Get Average of Slice
        
        if (avg<minAvg) //If Current Average is Less Than Minimum
        {
        	minAvg = avg; //Replace Minimum Average
        	minAvgInd = N-2; //Replace Position
        }
        
		return minAvgInd; //Return Position
	}
}
