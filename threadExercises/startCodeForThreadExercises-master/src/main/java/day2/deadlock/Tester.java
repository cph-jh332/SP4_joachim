package day2.deadlock;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Tester {

    public static void main(String[] args) {

        DeadLockDetector dl = new DeadLockDetector();
        try {
            ResourceContainer resources = new ResourceContainer();
            ResourceUser1 t1 = new ResourceUser1(resources);
            ResourceUser2 t2 = new ResourceUser2(resources);
            
            dl.start();
            t1.start();
            t2.start();            
            t1.join();
            t2.join();


            System.out.println("Done");
            System.out.println("Words produced: " + resources.getResourceWords().size());
            System.out.println("Numbers produced: " + resources.getResourceNumbers().size());
        } catch (InterruptedException ex) {
            Logger.getLogger(Tester.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(0);
        }finally{
            dl.exit();
        }
    }
}

/*
Question a)
    The program runs forever.

Question c)
    They are only going to release both locks when they are done, but they still
    try to get information that the other thread has locked out

Question b)
    Done!

Question c2)
    DONE!
 */
