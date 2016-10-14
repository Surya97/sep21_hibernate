package query;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class ListSubjects {
	public static void main(String[] args) {
		Configuration c = new Configuration();
		c.configure("query/hibernate.cfg.xml");
		c.addResource("query/catalog.hbm.xml");
		Session session = c.buildSessionFactory().openSession();

		List<Subject> result = (List<Subject>) session.createQuery("from Subject").list();
		
		for (Subject s : result) {
			System.out.printf("%-20s   %4d\n", s.getSubname(), s.getTitles().size());
		}

	}
}
