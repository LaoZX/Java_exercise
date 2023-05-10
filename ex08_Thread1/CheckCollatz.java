import java.math.BigInteger;
import java.util.Date;
import java.util.Set;
import java.util.HashSet;

// Collatz.check() checks the Collatz conjecture for a given
// number n.
// Now, to prove the conjecture to be correct, we would need to
// to verify it for all n.
// This is not possible to check for all n with a given computer
// but at least we can check for several values.
//
public class CheckCollatz {

  // Check the conjecture for 1 <= i <= n
    public static boolean check(BigInteger n) {
        for(BigInteger i = BigInteger.ONE; i.compareTo(n) < 0;
            i = i.add(BigInteger.ONE)){
            HashSet<BigInteger> visited = new HashSet<BigInteger>();
            if(check(i, visited)==false) return false;
        }
        return true;
    }
    
    public static boolean check(BigInteger n, Set<BigInteger> visited){
        if (n.equals(BigInteger.ONE)) { return true;}
        if (visited.contains(n)) { return false;}
        visited.add(n);
        
        if (n.mod(new BigInteger("2")).equals(BigInteger.ZERO)) {
            // Even
            n = n.divide(new BigInteger("2"));
        } else {
            // Odd
            n = n.multiply(new BigInteger("3")).add(BigInteger.ONE);
        }
        return check(n,visited);
    }


  public static void main(String[] args) {
    if (args.length != 1) {
      System.out.println("Usage:");
      System.out.println("java CheckCollatz n");
      System.out.println("will check the Collatz conjecture for");
      System.out.println("every 1 <= i <= n");
      System.exit(1);
    }

    long start_time = new Date().getTime();
    boolean v = CheckCollatz.check(new BigInteger(args[0]));
    long end_time = new Date().getTime();
    System.out.println("Ellapsed time: " + (end_time-start_time) + "ms");

    if (v) {
      System.out.println("The conjecture seems valid up to n="+args[0]);
    } else {
      System.out.println("The conjecture is not valid");
    }
  }
}
