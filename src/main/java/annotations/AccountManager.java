package annotations;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AccountManager {
    public static void main(String[] args) {
        Account a = new Account();
        // a.setAcno(1);
        a.setCustomer("Srikanth");
        a.setBalance(10000);

        Configuration c = new Configuration().configure();
        c.addAnnotatedClass(Account.class);
        SessionFactory sf = c.buildSessionFactory();
        
        Session session = sf.openSession();
        session.beginTransaction();
        session.save(a);
        session.getTransaction().commit();
        session.close();
        sf.close();
    }
}
