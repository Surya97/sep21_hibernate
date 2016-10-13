package annotations.onetoone;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestQuery {
    public static void main(String[] args) {
        Configuration c = new Configuration().configure();
        c.addAnnotatedClass(Employee.class);
        c.addAnnotatedClass(Passport.class);
        
        SessionFactory sf = c.buildSessionFactory();
        
        Session session = sf.openSession();
        
        Employee e = (Employee) session.get(Employee.class,1);
        System.out.println(e.getPassport().getCode());
        
        session.close();
        sf.close();
        
    }
}
