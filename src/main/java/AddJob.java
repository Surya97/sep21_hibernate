

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AddJob {

	public static void main(String[] args) throws Exception {
		Configuration c = new Configuration();
		c.configure(); // loads hibernate.cfg.xml

		SessionFactory sf = c.buildSessionFactory();
		Session s = sf.openSession();
		
		Job j = new Job();
		j.setId("j1");
		j.setTitle("Job1");
		
		s.beginTransaction();
		s.save(j);
		s.getTransaction().commit();
		
		
		s.close();
		sf.close();
	}

}
