package introsde.rest.ehealth.resources;

import java.io.IOException;
import java.util.List;

import introsde.rest.ehealth.dao.LifeCoachDao;
import introsde.rest.ehealth.model.*;

import javax.persistence.EntityManager;

public class DataBaseInit {
	public DataBaseInit(){};
	
	public Person CreatePerson(String fname,String lname,String bdate) throws IOException {
		Person p = new Person();
		List<Person> people = Person.getAll();
		int count = people.size();
        p.setFirstname(fname);
		p.setLastname(lname);
		p.setBirthdate(bdate);
    	p.setIdPerson(count +1);
		return Person.savePerson(p);
	}
	
	public ActivityPreference CreateActivityPreference( String name,String description,String place,String startdate,int idP) throws IOException {
		ActivityPreference ac = new ActivityPreference();
		Person p= Person.getPersonById(idP);
		Activity a = Activity.getActivityByActivtyType(name);
		List<ActivityPreference> acT = ActivityPreference.getAll();
		int count = acT.size();
		ac.setName(name);
		ac.setDescription(description);
		ac.setPerson(p);
		ac.setPlace(place);
		ac.setStartdate(startdate);
		ac.setActivity(a);
        ac.setIdActivityPreference(count +1);
        
    	 
		return ActivityPreference.saveActivityPreference(ac);
	}
	
	public Activity CreateActivity(String name) throws IOException {
		Activity a= new Activity();
		List<Activity> at = Activity.getAll();
		int count = at.size();
		a.setName(name);
        a.setIdActivity(count +1);
		return Activity.saveActivity(a);
	}
	
	public HealthMeasureHistory CreateHistory(String d,String p,String s,String name,int idP) throws IOException {
		HealthMeasureHistory h= new HealthMeasureHistory();
		Person person= Person.getPersonById(idP);
		Activity a = Activity.getActivityByActivtyType(name);
		List<HealthMeasureHistory> ht = HealthMeasureHistory.getAll();
		int count = ht.size();
		h.setActivity(a);
		h.setDescription(d);
		h.setPlace(p);
		h.setPerson(person);
		h.setStartdate(s);
		
        h.setIdMeasureHistory(count +1);
        return HealthMeasureHistory.saveHealthMeasureHistory(h);
		
	}
	
	
}
