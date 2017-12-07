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
   //System.out.println(App.History(1, "sport"));
   //System.out.println(HealthMeasureHistory.getHistoryByPersonAndMeasureType(person, md));
}

/*public static List<HealthMeasureHistory> History(int id,String activity_type) {

    Person person = Person.getPersonById(id);
    System.out.println("success 3");
    Activity  md = Activity.getActivityByActivtyType(activity_type) ;
    System.out.println("success 1");
    if (person == null||md == null) {
        	System.out.println("[Error] Get: Person with id " + id + " not found");
            throw new RuntimeException("Get: Person with " + id + " and measure Name "+activity_type+"not found");
        }
    System.out.println("success 2");
    System.out.println("Returning person with id :="+"" + person.getIdPerson()+""+ "and measuretype  := "+"" + md.getName() +""+""+md.getIdActivity() );
    return HealthMeasureHistory.getHistoryByPersonAndMeasureType(person, md);
    
 }*/

public static ResourceConfig createApp() {
    System.out.println("Starting sdelab REST services...");
    return new MyApplicationConfig();
}
}
