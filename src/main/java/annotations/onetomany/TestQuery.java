package annotations.onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestQuery {
    public static void main(String[] args) {
        Configuration c = new Configuration().configure();
        c.addAnnotatedClass(Employee.class);
        c.addAnnotatedClass(Department.class);
        
        SessionFactory sf = c.buildSessionFactory();
        
        Session session = sf.openSession();
        
        Department d = (Department) session.get(Department.class,100);
        
        System.out.println(d.getName());
        
        for(Employee e : d.getEmployees())
            System.out.println(e.getName());
        
        session.close();
        sf.close();
        
    }
}
