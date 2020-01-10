package hibernate.demo;

import demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyDemo {

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
            System.out.println("creating 3 students");
            Student swapStudent = new Student("Paul", "Walker", "paul@walker.com");
            Student swapStudent1 = new Student("Tomas", "Varga", "tomi@varga.com");
            Student swapStudent2 = new Student("Klaud", "Kriva", "klaud@kriva.com");

            //start a transaction
            session.beginTransaction();

            //saving student
            System.out.println("saving student");
            session.save(swapStudent);
            session.save(swapStudent1);
            session.save(swapStudent2);

            //commit transaction
            session.getTransaction().commit();

            System.out.println("DONE!");
        }
        finally {
            factory.close();
        }
    }
}
