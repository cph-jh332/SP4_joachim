package exampPrep_ProducerConsumer;

/**
 *
 * @author craci
 */
public class Fibonacci {
    public long fib(long n){
        if((n==0)||(n==1)){
            return n;
        }else{
            return fib(n - 1) + fib(n -2);
        }
    }
}
