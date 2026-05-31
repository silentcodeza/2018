
public class writingSum{

  public static void main(String[] args){
    int[] D = new int[20];
    int n=5;
    D[0]=1;
    D[1]=1;
    D[2]=1;
    D[3]=2;
    int sum=0;
    for (int i = 4; i <=n; i++)
      sum+=D[i-1] + D[i-3]+ D[i-4];

    System.out.println(sum);
  }
}
