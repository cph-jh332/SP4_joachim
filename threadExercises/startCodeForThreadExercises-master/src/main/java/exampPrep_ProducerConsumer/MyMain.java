package exampPrep_ProducerConsumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MyMain {
    
    private static ArrayBlockingQueue<Integer> s1 = new ArrayBlockingQueue(11);
    private static ArrayBlockingQueue<Integer> s2 = new ArrayBlockingQueue(11);
    
    public static void main(String[] args) {
        initialize();
        
        Fibonacci fib = new Fibonacci();
        
        Thread p1 = new Thread(()->{
            try {
                while(true){
                    long temp = fib.fib(s1.take());
                    s2.put((int) temp);
                    if(s1.isEmpty()){
                        return;
                    }
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(MyMain.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        Thread p2 = new Thread(()->{
            try {
                while(true){
                    long temp = fib.fib(s1.take());
                    s2.put((int) temp);
                    if(s1.isEmpty()){
                        return;
                    }
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(MyMain.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        Thread p3 = new Thread(()->{
            try {
                while(true){
                    long temp = fib.fib(s1.take());
                    s2.put((int) temp);
                    if(s1.isEmpty()){
                        return;
                    }
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(MyMain.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        Thread p4 = new Thread(()->{
            try {
                while(true){
                    long temp = fib.fib(s1.take());
                    s2.put((int) temp);
                    if(s1.isEmpty()){
                        return;
                    }
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(MyMain.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        p1.start();
        p2.start();
        p3.start();
        p4.start();
        
        Thread c1 = new Thread(()->{
            int total = 0;
            boolean running = true;
            while(running){
                try {
                    long temp = s2.take();
                    System.out.println(temp);
                    total += (int) temp;
                    if(s2.isEmpty() && !p1.isAlive() && !p2.isAlive() && !p3.isAlive() && !p4.isAlive()){
                        running = false;
                    }
                } catch (InterruptedException ex) {
                    Logger.getLogger(MyMain.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            System.out.println("Total sum = " + total);
        });
        
        c1.start();
    }
    
    private static void initialize() {
        s1.add(4);
        s1.add(5);
        s1.add(8);
        s1.add(12);
        s1.add(21);
        s1.add(22);
        s1.add(34);
        s1.add(35);
        s1.add(36);
        s1.add(37);
        s1.add(42);
    }
}
/*
1)
    It's smart to use Threads when tasks are heavy and you can split them up,
    also when you want to have a responsive design. So if you wanna do something
    parallel in the program

2)
    A race condition can happen when you don't use a atomic method like i++

3/5) 
    The consumer can't consume if the producer haven't produced, that's why we
    use blocking queue. Then you can use the put and take function, so the thread
    either waits for space to put something in the queue or it waits for something
    to be in the queue

4)
   If the threads run all the time while it waits for something like a lock instead
    of sleeping
*/
