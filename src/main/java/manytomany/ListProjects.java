package manytomany;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ListProjects {

    public static void main(String[] args) {
        Configuration c = new Configuration().configure();
        c.addResource("manytomany/manytomany.hbm.xml");
        SessionFactory sf = c.buildSessionFactory();
        Session session = sf.openSession();
     

        // list all employees with project titles
        List plist = session.createQuery("from Project").list();

        for(Object o : plist) {
             Project p = (Project) o;
             System.out.println(p.getTitle());
             for ( Employee e : p.getEmployees()) {
                  System.out.println("\t" + e.getName());
             }
        }
        
        // list all employees with project titles
        List elist = session.createQuery("from Employee").list();

        for(Object o : elist) {
             Employee e = (Employee) o;
             System.out.println(e.getName());
             for ( Project p : e.getProjects()) {
                  System.out.println("\t" + p.getTitle());
             }
        }

        session.close();
        sf.close();
    }

}
