package annotations.onetoone;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test {
    public static void main(String[] args) {
        Employee e = new Employee();
        e.setId(1);
        e.setName("Ellison");
      
        Passport p = new Passport();
        p.setEmpid(1);
        p.setCode("349343434");
        
        e.setPassport(p);
        
        
        

        Configuration c = new Configuration().configure();
        c.addAnnotatedClass(Employee.class);
        c.addAnnotatedClass(Passport.class);
        
        SessionFactory sf = c.buildSessionFactory();
        
        Session session = sf.openSession();
        session.beginTransaction();
        session.save(e);
        session.getTransaction().commit();
        session.close();
        sf.close();
        
    }
}
