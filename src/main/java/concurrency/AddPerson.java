package concurrency;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AddPerson {

    public static void main(String[] args) {

        Person p = new Person();
        p.setName("Testing");
        Configuration c = new Configuration().configure();
        c.addResource( "concurrency/person.hbm.xml");
        SessionFactory sf = c.buildSessionFactory();
        Session session = sf.openSession();
        session.beginTransaction();
        session.save(p);
        session.getTransaction().commit();
        session.close();
        sf.close();
    }
}
