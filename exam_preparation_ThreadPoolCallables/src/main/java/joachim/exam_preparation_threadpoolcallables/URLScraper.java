package joachim.exam_preparation_threadpoolcallables;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 *
 * @author craci
 */
public class URLScraper implements Callable {

    private ArrayBlockingQueue<String> a1 = new ArrayBlockingQueue(11);
    
    @Override
    public Object call() throws Exception {
        Document doc = Jsoup.connect(a1.take()).get();
        Elements authors = doc.select("#authors");
        Elements classD = doc.select("#class");
        Elements group = doc.select("#group");
        String authors1 = authors.text();
        String class1 = classD.text();
        String group1 = group.text();
        Group thisgroup = new Group(authors1, class1, group1);
        return thisgroup;
    }
    
    public ArrayBlockingQueue<String> init(){
        a1.add("http://165.227.151.92:8080/CA1/");
        a1.add("http://alfen.me/CA1");
        return a1;
    }
}
