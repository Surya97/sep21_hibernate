

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteJob {

	public static void main(String[] args) throws Exception {
		Configuration c = new Configuration();
		c.configure(); // loads hibernate.cfg.xml

		SessionFactory sf = c.buildSessionFactory();
		Session s = sf.openSession();
		
	    Job job = (Job) s.get(Job.class, "j1");
		
		s.beginTransaction();

	    s.delete(job);
	    
		s.getTransaction().commit();
		
		
		s.close();
		sf.close();
	}

}
