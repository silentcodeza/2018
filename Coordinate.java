public class Coordinate
{
   private int x, y;
   public Coordinate()
   {
      this(0, 0);
   }
   public Coordinate(int initialX, int initialY)
   {
     set(initialX, initialY);
   }
   public void set(int initialX, int initialY)
   {
      x = initialX;
      y = initialY;
   }
   public int getX()
   {return x;}
   public int getY()
   {return y;}


   public void setX(int x)
   {this.x = x;}
   public void setY(int y)
   {this.y = y;}
   
   public String toString()
   {
     return "(" + x+ ", "+ y+")";
    }
   public int compareTo(Coordinate otherCoordinate)
   {
     int out = 10;
     if((x < otherCoordinate.x) || ((x == otherCoordinate.x) && (y < otherCoordinate.y)))
     {
	     out = -1;
	 }
     else if((x == otherCoordinate.x) && (y == otherCoordinate.y))
     {
	    out = 0;
     }
     else
     {
	     out =  1;
	 }
     return out;
   }
   public static double distanceBetween(Coordinate co1, Coordinate co2)
   {
     double out =  Math.pow((co1.x-co2.x), 2.0) + Math.pow((co1.y - co2.y), 2.0);
     return Math.pow(out, 0.5);
   }
   public static void sortCoordinate(Coordinate[] a)
   {
      for(int i = 0; i < a.length - 1; i++)
      {
         for(int j = i+1; j < a.length; j++)
         {
            if(a[i].compareTo(a[j]) > 0)
            {
              Coordinate temp = a[i];
              a[i] = a[j];
              a[j] = temp;
            }
         }
      }
   }
}
