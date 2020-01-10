package hibernate.demo;

import demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateStudentDemo {

    public static void main(String[] args) {
        // Session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        //create session
        Session session = factory.getCurrentSession();

        try{
            // student object
            System.out.println("creating student");
            Student swapStudent = new Student("Paul", "Walker", "paul@walker.com");

            //start a transaction
            session.beginTransaction();

            //saving student
            System.out.println("saving student");
            session.save(swapStudent);

            //commit transaction
            session.getTransaction().commit();

            System.out.println("DONE!");
        }
        finally {
            factory.close();
        }
    }
}
