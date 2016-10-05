import java.util.HashSet;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Address;
import entity.Customer;

public class ListCustomers {

	public static void main(String[] args) throws Exception {
     	Configuration cfg  = new Configuration();
		cfg.configure(); // loads hibernate.cfg.xml
		
		SessionFactory sf = cfg.buildSessionFactory();
		Session s = sf.openSession();
		
	    Customer c = (Customer) s.get(Customer.class, 121);
	    System.out.println(c.getName());
	    
	
	    for (String phone :  c.getPhones()) 
	    {
	    	System.out.println(phone);
	    }
	
		
		s.close();
		sf.close();
	}

}
