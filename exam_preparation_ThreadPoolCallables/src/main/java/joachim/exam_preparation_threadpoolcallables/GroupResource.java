package joachim.exam_preparation_threadpoolcallables;

import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author craci
 */
@Path("group")
public class GroupResource {

    Gson gs = new Gson();


    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GroupResource
     */
    public GroupResource() {
    }

    /**
     * Retrieves representation of an instance of
     * joachim.exam_preparation_threadpoolcallables.GroupResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        List<Group> groupList = new ArrayList();
        ExecutorService es = Executors.newFixedThreadPool(10);
        List<Future> fl = new ArrayList();
        ArrayBlockingQueue<String> a1 = null;
        URLScraper us = new URLScraper();
        
        a1 = us.init();
        
        for (int i = 0; i < a1.size(); i++) {
            Future<Group> f1 = es.submit(us);
            fl.add(f1);
        }
        
        try {
            for (Future<Group> future : fl) {
                groupList.add(future.get());
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(GroupResource.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ExecutionException ex) {
            Logger.getLogger(GroupResource.class.getName()).log(Level.SEVERE, null, ex);
        }

        es.shutdown();
        try {
            es.awaitTermination(3, TimeUnit.MILLISECONDS);
        } catch (InterruptedException ex) {
            Logger.getLogger(ex.getMessage());
        }

        return gs.toJson(groupList);
    }

    /**
     * PUT method for updating or creating an instance of GroupResource
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }
}
