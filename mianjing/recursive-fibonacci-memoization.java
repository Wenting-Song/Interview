/*   0：0
     1: 1
 *   2: 1
 *   3: 2
 *   4: 3
 *   5: 5
 *   6: 8
 *   7: 13
*/
 class Fibonacci {
    int fibonacci(int n) {
     int[] fn = new int[n+1];
     return helper(fn,n);
   }
    int helper(int fn[],int n){
      if(n==0 ) return 0;
      if(n==1 || n==2) return 1;
      if(fn[n]!=0) return fn[n];
      fn[n] = helper(fn,n-1)+helper(fn,n-2);
      return fn[n];      
    }
  }
  

public class Main {
  public static void main(String[] args){
      Fibonacci fn = new Fibonacci();
      int n = fn.fibonacci(5);
      System.out.println(n);
    }
}

