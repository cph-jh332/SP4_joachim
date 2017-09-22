package day1.Exercise1;

import java.io.IOException;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author craci
 */
public class MyMain {
    private static volatile boolean run = true;

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1e9; i++) {
                System.out.println("Computed number" + i);

            }
        }
        );

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Computed number" + i);
                try {
                    sleep(2000);
                } catch (Exception e) {
                }
            }
        }
        );

        Thread t3 = new Thread(() -> {
            int i = 10;
            while (run) {
                i++;
                System.out.println("Computed number" + i);
                try {
                    sleep(3000);
                } catch (Exception e) {
                }
            }
        }
        );
        
        t1.start();
        t2.start();
        t3.start();
        
        try {
            System.in.read();
            run = false;
        } catch (IOException ex) {
            Logger.getLogger(MyMain.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        /*
        question a)
            No i don't need synchronization, because they don't share same method
        
        question b)
            There is a problem with the boolean that the main thread has to write to and
            the t3 thread has to read from. So we have to make it volatile.
        
        question c)
            My solution is correct because the numbers are written correctly and the boolean
            is volatile, so the boolean stays the same between threads (not cached)
        
        */
    }
}
