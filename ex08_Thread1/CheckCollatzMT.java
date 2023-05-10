import java.math.BigInteger;
import java.util.Date;
import java.util.Set;
import java.util.HashSet;

public class CheckCollatzMT {

  public static class MThreads implements Runnable{
    BigInteger lower;
    BigInteger upper;
    MThreads(BigInteger lw,BigInteger up){
      lower=lw;
      upper=up;
    }
    public void run(){
        for(BigInteger ix=lower; ix.compareTo(upper)<0;
            ix=ix.add(BigInteger.ONE)){
          HashSet<BigInteger> visited=new HashSet<BigInteger>();
          //System.out.println(this.getClass()+" check "+ix);
          if(check(ix,visited)==false) {
            System.out.println("The conjecture is not valid for" + ix);
            System.exit(1);
          }
        }
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
  }


    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage:");
            System.out.println("java CheckCollatzMT n num_threads");
            System.out.println("where positive integers i: 1<= i <= n will be checked");
            System.out.println("and num_threads is the number of threads to use");
            System.exit(1);
        }
  
      int n = Integer.parseInt(args[0]);
      int num_threads = Integer.parseInt(args[1]);
      
      long start_time = new Date().getTime();

      BigInteger lower=BigInteger.ONE;
      BigInteger upper= BigInteger.valueOf( (int)Math.ceil((double)n/num_threads) );
      BigInteger temp=upper;
      Thread[] multiThread = new Thread[num_threads];
      for (int i = 0; i < num_threads; i++) {
          System.out.println("thread"+ i +" do [lower "+lower+"  uppper "+upper+"]");
          multiThread[i] = new Thread(new MThreads(lower, upper));
          multiThread[i].start();
          lower = upper.add(BigInteger.ONE);
          upper = upper.add(temp);
      }

      for (int i = 0; i < num_threads; i++) { // wait all threads finish, or the end_time is wrong
        try {
            multiThread[i].join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
      }
      long end_time = new Date().getTime();
      System.out.println("Ellapsed time: " + (end_time-start_time) + "ms");
      System.out.println("The conjecture seems valid up to n="+n);
  }
}