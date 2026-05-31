/* 
	This program implements a solution for the Towers of Hanoi problem.
	A tower of 5 disks must be moved from rod A to rod C using B as a
	spare or temporary storage space
*/

public class TowerOfHanoi2
{	   int noOfMoves = 0;
 	   boolean explain = true;

	   
	   public int getNoOfMoves()
	   {	 return noOfMoves;
        }

	   public void run()
        {	 int n =5;
	   	 System.out.println("The task is to move "+n+" disks from rod A to C using B as spare storage space \n");
		 moveTowers(4,'A','B','C'); 
	   }
    
  	   public void moveTowers(int n, char A, char B, char C)
        {    noOfMoves++;
		  if (n==1)
                System.out.println(" Move a disk from rod "+A+" to rod "+C);
             else
             {  
			if (explain) 
				System.out.println("subtask is to move "+n+" disks from rod A to B using C as spare storage space ");

			moveTowers(n-1, A, C, B);
                
			System.out.println("   Move a disk from rod "+A+" to rod "+B);

			if (explain) 
				System.out.println("subtask is to move "+n+" disks from rod B to C using A as spare storage space ");

			moveTowers(n-1, B, A, C);
             }
        }

        public static void main(String[] args)
        { 		TowerOfHanoi2 objct = new TowerOfHanoi2();
			objct.run();
			
		  System.out.println("\nNumber of moves to move tower: "+objct.getNoOfMoves());

        }
 }
                                

        


