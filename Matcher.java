import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;
public class Matcher
{    
    
    
    //public static Coordinate[] testFile = new Coordinate[30];
   // public static Coordinate[] person1 = new Coordinate[30];
    //public static Coordinate[] person2 = new Coordinate[30];

    public static void main(String[] args)
    {
	 try
	 {
	   Matcher n = new Matcher();
	    Coordinate[] testFile = new Coordinate[30];
		Coordinate[] person1 = new Coordinate[30];
		Coordinate[] person2 = new Coordinate[30];
		n.loadArray("TestFile1.csv", testFile);
		n.loadArray("PersonA.csv", person1);
		n.loadArray("PersonB.csv", person2);
		
		double[] defTestFile = n.accuDifference(testFile);
		
		double[] defPA = n.accuDifference(person1);
		
		double[] defPB = n.accuDifference(person2);
		
		System.out.println("It is "+ n.areArraysEqual(defTestFile, defPA) +" that the finger prints for person A match." );
		System.out.println("It is "+ n.areArraysEqual(defTestFile, defPB) +" that the finger prints for person B match." );
	  }
	  catch(FileNotFoundException e)
	  {
	  	System.out.println(e.getMessage());
	  }
		
		
		
		
    }
    public void loadArray(String fileName, Coordinate[] prints) throws FileNotFoundException
    {
       Scanner inputStream = new Scanner(new File(fileName));
      
       int count = 0;
       while(inputStream.hasNextLine())
      {
         String line = inputStream.nextLine();
         String[] lineArray = line.split(",");
         int x = Integer.parseInt(lineArray[0].trim());
         int y= Integer.parseInt(lineArray[1].trim());
         
         prints[count] = new Coordinate(x, y);
         count++; 
      }
      Coordinate.sortCoordinate(prints);
    }
    public double[] accuDifference(Coordinate[] a)
    {
        int defLength = (a.length*(a.length - 1))/2;
		double[] accum = new double[defLength];
		int index = 0;
		for(int i = 0; i< a.length - 1; i++)
		{
			for(int j = i +1; j< a.length; j++)
			{
				accum[index] = Coordinate.distanceBetween(a[i], a[j]);
				index++;
			}
		}
		return accum;
    }
	public boolean areArraysEqual(double[] x, double[] y)
	{
		boolean res = true;
		if(x.length != y.length)
		{
			res = false;
		}
		else
		{
			int index = 0;
			while((res == true) && (index < x.length))
			{
				if(x[index] != y[index])
				{
					res =false;
				}
				index++;
			}
		}
		return res;
	}
}
