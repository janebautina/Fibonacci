import java.util.Scanner;


public class Fibonacci
{
   public static void main(String [] args) {
      System.out.println("Please enter fibonacci number: ");
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      for (int i = 0; i < n; i++) {
         System.out.print(fibonacci(i) + " ");
      }
      System.out.println("");
      int [] a = fibonacci1(n);
      for(int i = 0; i < n ; i++)  {
         System.out.print(a[i] + " ");
      }     
      System.out.println();
      for(int i = 0; i < n ; i++)  {
         System.out.print(fibonacci2(i + 1)+ " ");
      }     
      System.out.println();
   }
   public static int fibonacci(int n) {
      if ((n == 0) || (n == 1)) {
         return 1;
      }
      else {
         return fibonacci(n - 1) + fibonacci(n - 2) ;
      }
   }
   public static int [] fibonacci1(int n) {
      int [] a = new int[n];
      for (int i = 0; i < n; i++) {
         if((i == 0) || (i == 1))
            a[i] = 1;
         else 
            a[i]= a[i-1] + a[i-2];
      }     
      return a;
   }
   public static int fibonacci2(int n) {
      int [][] F = new int [][] {{1,1}, {1,0}};
      if(n == 0)
         return 1;
      power(F, n - 1);
      return F[0][0];
   }
   public static void power(int [][]F, int m) {
      if ((m == 0) || (m == 1))
         return;
      int M[][] = new int[][]{{1,1},{1,0}};
      power(F, m/2);
      multiply(F, F);
      if (m%2 != 0)
         multiply(F, M);   
   }
   public static void multiply(int [][]F, int [][]M) {
      int x = F[0][0] * M[0][0] + F[0][1] * M[1][0];
      int y = F[0][0] * M[0][1] + F[0][1] * M[1][1];
      int z = F[1][0] * M[0][0] + F[1][1] * M[1][0];
      int w = F[1][0] * M[0][1] + F[1][1] * M[1][1];
      F[0][0] = x;
      F[0][1] = y;
      F[1][0] = z;
      F[1][1] = w;
   }
}
