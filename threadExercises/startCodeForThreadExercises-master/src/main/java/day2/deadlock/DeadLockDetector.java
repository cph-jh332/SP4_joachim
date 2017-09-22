package day2.deadlock;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;

/**
 *
 * @author craci
 */
public class DeadLockDetector extends Thread {

    ThreadMXBean bean = ManagementFactory.getThreadMXBean();
    private boolean running = true;
    
    public void run() {
        while (running) {
            long[] threadIds = bean.findDeadlockedThreads();
            if (threadIds != null) {
                System.out.println("DeadLock Detected");
            }

        }
    }
    
    public void exit(){
        running = false;
    }

}
