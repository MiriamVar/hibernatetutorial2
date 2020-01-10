package hibernate.demo;

import demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;


public class QueryStudentDemo {

    public static void main(String[] args) {
        // Session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        //create session
        Session session = factory.getCurrentSession();

        try{
           //start a transaction
            session.beginTransaction();

            //query students
            List<Student> theStudents = session.createQuery("from Student").list();

            //display students
            displayStudents(theStudents);

            //query students
            theStudents = session.createQuery("from Student s where s.lastName='Kriva'").list();
            System.out.println("students with lastname Kriva");
            displayStudents(theStudents);

            theStudents = session.createQuery("from Student s where s.lastName='Kriva' OR s.firstName='Tomi'").list();
            System.out.println("students with lastname Kriva and firstname tomi");
            displayStudents(theStudents);

            theStudents = session.createQuery("from Student s where s.email LIKE 'paul@walker.com'").list();
            System.out.println("students with email paul@walker.com");
            displayStudents(theStudents);

            //commit transaction
            session.getTransaction().commit();

            System.out.println("DONE!");
        }
        finally {
            factory.close();
        }
    }

    private static void displayStudents(List<Student> theStudents) {
        for (Student student:theStudents) {
            System.out.println(student);
        }
    }
}
