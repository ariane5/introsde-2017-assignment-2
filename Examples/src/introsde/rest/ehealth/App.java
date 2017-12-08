package introsde.rest.ehealth;

import introsde.rest.ehealth.dao.LifeCoachDao;
import introsde.rest.ehealth.model.*;
import introsde.rest.ehealth.resources.DataBaseInit;

import java.io.IOException;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;

import org.glassfish.jersey.jdkhttp.JdkHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

public class App
{    public static void main(String[] args) throws IllegalArgumentException, IOException, URISyntaxException
{
    String protocol = "http://";
    String port_value = "5700";
    if (String.valueOf(System.getenv("PORT")) != "null"){
        port_value=String.valueOf(System.getenv("PORT"));
    }
    String port = ":"+port_value+"/";
    String hostname = InetAddress.getLocalHost().getHostAddress();
    
    if (hostname.equals("127.0.0.1"))
    {
        hostname = "localhost";
    }
    
    URI BASE_URI = new URI(protocol + hostname + port+"sdelab/");

    System.out.println("Starting sdelab standalone HTTP server...");
    JdkHttpServerFactory.createHttpServer(BASE_URI, createApp());
    
    System.out.println("Server started on " + BASE_URI + "\n[kill the process to exit]");
    //DataBaseInit.fillDataBase();
    //Person person = Person.getPersonById(1);
  //  Activity  md = Activity.getActivityByActivtyType("sport") ;
    //HealthMeasureHistory.getHistoryByPersonAndMeasureType(person, md)
   //System.out.println( Activity.getActivityByActivtyType("sport"));
   // App ap=new App();
  //System.out.println(ap.putActivity());
   //System.out.println(HealthMeasureHistory.getHistoryByPersonAndMeasureType(person, md));
}

/*public Activity_Type putActivity() {

		int n= Activity_Type.getAll().size();
		Activity_Type h = new Activity_Type();
	    Activity a =	Activity.getActivityByActivtyType("sport");
	    

	    Person p= Person.getPersonById(1);
		Activity_Type h1=Activity_Type.getHistoryByPersonAndTypeAndactivity_id(p, a, 1);
	   

		if (h1== null) {
	
		  System.out.println("can not find the history");
		  return null;
			
		} else {

		    h.setActivity(h1.getActivity());
		    h.setDescription("walking");
		    h.setIdMeasureHistory(h1.getIdMeasureHistory());
		    h.setPerson(h1.getPerson());
		    h.setPlace("Gardolo");
		    h.setStartdate("12-12-2018");
		                           
			h.setIdMeasureHistory(n);
		    Activity_Type pq =Activity_Type.updateActivity_Type(h);
			return pq;
		}
    }*/
    
 

public static ResourceConfig createApp() {
    System.out.println("Starting sdelab REST services...");
    return new MyApplicationConfig();
}
}
