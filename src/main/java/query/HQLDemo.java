package query;

import java.util.List;
import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;


public class HQLDemo {
    public static void main(String[] args) {
      Configuration c = new Configuration();
      c.configure("query/hibernate.cfg.xml");
      c.addResource("query/catalog.hbm.xml");
      Session session = c.buildSessionFactory().openSession();
      Scanner s = new Scanner(System.in);
      String query;
      while ( true){
          System.out.println("Enter Query : ");
          query = s.nextLine();
          if ( query.length() == 0 ) break;
          try {
           List result = session.createQuery(query).list();
           System.out.println("Query Result");
           System.out.println("==================================================");
           for( Object obj : result) {
             if ( obj instanceof Object[]) {
                 for ( Object o : (Object[]) obj) {
                      System.out.print(o.toString() + "  ");
                 }
                 System.out.println();
             }
             else
              System.out.println( obj.toString());            
           }
          }
          catch(Exception ex){
              System.out.println("Error-->" + ex.getMessage());
          }
      }
    }
}
