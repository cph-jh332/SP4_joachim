package day1.Exercise2;

/**
 *
 * @author craci
 */
public class MyMain {

    public static void main(String[] args) {
        Even even = new Even();
        Thread t1 = new Thread(()->{
            for (int i = 0; i < 20; i++) {
                System.out.println("t1: " + even.next());
            }
        });
        
        Thread t2 = new Thread(()->{
            for (int i = 0; i < 20; i++) {
                System.out.println("t2: " + even.next());
            }
        });
        
        t1.start();
        try {
            t1.join();
        } catch (Exception e) {
        }
        t2.start();
    }
}

/*
Question a)
    Yes, sometimes the t2 writes its number before t1 does, but everyone was even 
    and didn't skip any numbers

Question b)
    Everytime I've pressed run

Question c/b)
    I've made the method synchronized, so it only can be used one at a time,
    and the I've put a join on t1, so it runs all the way through without
    interruption.
*/
