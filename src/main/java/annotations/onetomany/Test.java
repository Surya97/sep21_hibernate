package annotations.onetomany;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test {
    public static void main(String[] args) {
        Employee e1 = new Employee();
        e1.setId(1);
        e1.setName("Ellison");
        
        Employee e2 = new Employee();
        e2.setId(2);
        e2.setName("Larry");
      
       
        Department d = new Department();
        d.setDeptno(100);
        d.setName("IT");
        
        d.getEmployees().add(e1);
        d.getEmployees().add(e2);
        
        e1.setDepartment(d);
        e2.setDepartment(d);
        
        
        Configuration c = new Configuration().configure();
        c.addAnnotatedClass(Employee.class);
        c.addAnnotatedClass(Department.class);
     
        
        SessionFactory sf = c.buildSessionFactory();
        
        Session session = sf.openSession();
        session.beginTransaction();
        session.save(e1);
        session.save(e2);
        session.getTransaction().commit();
        session.close();
        sf.close();
        
    }
}
