
/**
 Class for sorting an array of integers from smallest to largest
 using the merge sort algorithm.
*/
public class MergeSort
{
    /**
     Precondition: Every indexed variable of the array a has a value.
     Postcondition: a[0] <= a[1] <= ... <= a[a.length - 1].
    */
    public static void sort(int[] a)
    {
boolean explain = true;

        if (a.length >= 2)
        {
            int halfLength = a.length / 2;
            int[] firstHalf = new int[halfLength];
            int[] lastHalf = new int[a.length - halfLength];
if(explain)
{		  System.out.println("\nDividing array ");
}
            divide(a, firstHalf, lastHalf);
if(explain)
{		 display("firstHalf",firstHalf);
		 display("secondHalf",lastHalf);
		 System.out.println("\nFirst sort first half");
}
            sort(firstHalf);
if(explain)
{
		 System.out.println("\nThen sort second half");
}
            sort(lastHalf);
if(explain)
{ 		 System.out.println("\nnow to merge the two arrays ");
		 display("firstHalf",firstHalf);
		 display("secondHalf",lastHalf);
}
            merge(a, firstHalf, lastHalf);
        }
        //else do nothing. a.length == 1, so a is sorted.
    }

    //Precondition: a.length = firstHalf.length + lastHalf.length.
    //Postcondition: All the elements of a are divided
    //between the arrays firstHalf and lastHalf.
    private static void divide(int[] a, int[] firstHalf, int[] lastHalf)
    {
        for (int i = 0; i < firstHalf.length; i++)
            firstHalf[i] = a[i];
        for (int i = 0; i < lastHalf.length; i++)
            lastHalf[i] = a[firstHalf.length + i];
    }

    //Precondition: Arrays firstHalf and lastHalf are sorted from 
    //smallest to largest; a.length = firstHalf.length + 
    //lastHalf.length.
    //Postcondition: Array a contains all the values from firstHalf 
    //and lastHalf and is sorted from smallest to largest.
	private static void merge(int[] a, int[] firstHalf, int[] lastHalf)
    {
        int firstHalfIndex = 0, lastHalfIndex = 0, aIndex = 0;

        while ((firstHalfIndex < firstHalf.length) &&
			   (lastHalfIndex < lastHalf.length))
        {
            if (firstHalf[firstHalfIndex] < lastHalf[lastHalfIndex])
            {
                a[aIndex] = firstHalf[firstHalfIndex];
                firstHalfIndex++;
            }
            else
            {
                a[aIndex] = lastHalf[lastHalfIndex];
                lastHalfIndex++;
            }
            aIndex++;
        }
        //At least one of firstHalf and lastHalf has been
        //completely copied to a.

        //Copy rest of firstHalf, if any.
		while (firstHalfIndex < firstHalf.length)
        {
            a[aIndex] = firstHalf[firstHalfIndex];
            aIndex++;
            firstHalfIndex++;
        }

        //Copy rest of lastHalf, if any.
        while (lastHalfIndex < lastHalf.length)
        {
            a[aIndex] = lastHalf[lastHalfIndex];
            aIndex++;
            lastHalfIndex++;
        }
    }
	
    public static void display(String strng, int[] arr)
    {		System.out.print(strng+": ");
		for(int i=0; i<arr.length; i++)
		{	System.out.print(arr[i]);
			if (i != arr.length -1)
		 		System.out.print(",");
		}
		if (strng.equals("lastHalf"))
			System.out.println();
		else
			System.out.print("\t");
    }

}
