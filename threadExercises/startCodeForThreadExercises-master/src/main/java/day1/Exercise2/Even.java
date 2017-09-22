package day1.Exercise2;

/**
 *
 * @author craci
 */
public class Even {

    private int n = 0;

    public synchronized int next() {
        n++;
        n++;
        return n;
    }

}
