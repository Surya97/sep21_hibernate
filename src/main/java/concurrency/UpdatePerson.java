package concurrency;

import java.util.Date;
import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdatePerson {

    public static void main(String[] args) {

        Configuration c = new Configuration().configure();
        c.addResource( "concurrency/person.hbm.xml");
        SessionFactory sf = c.buildSessionFactory();
        Session session = sf.openSession();
        session.beginTransaction();
        Person  p = (Person)session.load( Person.class,63);
        p.setName( new Date().toString());
        
//        Scanner s = new Scanner(System.in);
//        System.out.println("Press enter to continue...");
//        s.nextLine();
//        
        // session.save(p);
        session.getTransaction().commit();
        session.close();
        sf.close();
    }
}
