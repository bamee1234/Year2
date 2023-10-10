public class Recursion {
	static int subsum(int n) {
		//Ex1. Complete the content of this method 
        if (n == 1) {
          return 1;
        }
        else {
          return (int) ((Math.pow(-1, n - 1) * n) + subsum (n - 1));
        }
    }
	static int sumDigit(int n) {
		//Ex2. Complete the content of this method 
        if (n < 10) {
          return n;
        }
     else {
          return (n % 10) + sumDigit (Math.floorDiv(n, 10));
     }
    }
	
	public static void main(String[] args) {
		System.out.println("Calculating subsum(10):");
		System.out.println("Your answer is "+subsum(10));
		System.out.println("The correct answer is -5");
		System.out.println("-----------------------"); 
              
		System.out.println("sumDigit(123456789)");
		System.out.println("Your answer is "+ sumDigit(123456789));
		System.out.println("The correct answer is 45");    
	}
	
}
