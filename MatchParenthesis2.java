import java.util.Scanner;
/**
 *<br>Author : Lihlelenkosi Nkala
 *<br>Student number:3541366
 *<br>Date:15 October 2015
 *<br>Practical 6
 */

/**This class will match the left and right parenthesis of any algebraic expression. */
public class MatchParenthesis2
{
    /**
	 *The main method of the class will run the program
         * @param args
	 */
	public static void main(String[] args)
	{
	    //Creating a generic list of nodes called list of class LinkedStack
		LinkedStack<Integer> list = new LinkedStack<Integer>();
		//Creating a Scanner object
		Scanner keyboard = new Scanner(System.in);
		//Prompting the user for the algebraic expression
		System.out.println("Enter the algebraic expression to match parenthesis:");
		//Allowing keyboard input from the user
		String algebraicExpression = keyboard.nextLine();
		//Creating a duplicate of the string to hold indices of interest
		String temp = space(algebraicExpression.length());
		//Iterating through the string checking for unmatched parenthesis to be displayed
		for(int i = 0; i < algebraicExpression.length(); i++)
		{
			if(algebraicExpression.charAt(i) == '(')
			{
			    //Appendind lonely parenthesis' indices to the LinkedStack.
				list.push(new Integer(i));
			}
			else
			{
			    //Locating left parenthesis
				if(algebraicExpression.charAt(i) == ')')
				{
					if(!list.isEmpty())
					{
					    //Unloading the top element of our stack
						list.pop();
					}
					else
					{
					    
						System.out.println("Unmatched right parenthesis at position "+ i  );
						temp = temp.substring(0, (i - 1)) +"<" + temp.substring(i);
						
					}
				}
			}
		}
		while(!list.isEmpty())
		{
		    int position = list.pop().intValue();
			
			temp = temp.substring(0, (position - 1))+ ">" + temp.substring(( position +1));
			System.out.println("Unmatched left parenthesis at position "+ position );
		}
		System.out.println(algebraicExpression +"\n"+temp +"\n"+ insertIndices(algebraicExpression.length()));
	}
        
        /**This method inserts the spaces between the values of indices */
	public static String space(int n)
	{   String spaces = "";
		for(int i = 0; i < n; i++)
		{
			spaces = spaces + " ";
		}
		return spaces;
	}
        
        /**This method is for showing the value of indices
         @param n
         @return the values of the indices*/
	public static String insertIndices(int n)
	{   String spaces = "";
		
		for(int i = 0; i < (n/10); i++)
		{
			spaces = spaces + "0123456789";
		}
		for(int k = 0; k <= (n%10); k++)
		{
			spaces = spaces + k;
		}
		String temp = "";
		int count = 0;
		for(int x = 0; x < spaces.length(); x++)
		{
			if((spaces.charAt(x) == '0') && (x!=0))
			{
				count ++;
			    temp = temp + count;
			}
			else
			{
				temp = temp + " ";
			}
		}
		return spaces + "\n" + temp ;
	}
}