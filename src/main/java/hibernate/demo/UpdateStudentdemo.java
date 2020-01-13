package hibernate.demo;

import demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class UpdateStudentdemo {

    public static void main(String[] args) {
        // Session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        //create session
        Session session = factory.getCurrentSession();

        try{
            int id  = 1;

            session = factory.getCurrentSession();
            session.beginTransaction();

            System.out.println("generated user druhy kraaaat"+ id);

            Student student = session.get(Student.class,id);
            System.out.println("Updating student");
            student.setFirstName("Scooby");

            System.out.println(student.getFirstName());
            session.getTransaction().commit();

            // another update
            session = factory.getCurrentSession();
            session.beginTransaction();

            System.out.println("Updating all emails all students");
            session.createQuery("update Student set email='skuska@gmail.com'").executeUpdate();

            session.getTransaction().commit();
        }
        finally {
            factory.close();
        }
    }
}
