package day2.writer;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;

/**
 *
 * @author craci
 */
public class Backup extends Thread {

    private volatile List<String> text = new ArrayList();
    private volatile boolean running = true;

    @Override
    public void run() {
        while (running) {
            System.out.println("!!!!!!!!!!!Saving!!!!!!!!");
            System.out.println(text.toString());
            try {
                String userDir = new JFileChooser().getFileSystemView().getDefaultDirectory().toString();
                FileWriter writer = new FileWriter(userDir + "/backup.txt", false);
                PrintWriter out = new PrintWriter(writer); 
                out.println(text.toString());
                out.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            } finally {
                try {
                    Thread.sleep(15000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Backup.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public void updateText(List<String> text) {
        this.text = text;
    }
}
