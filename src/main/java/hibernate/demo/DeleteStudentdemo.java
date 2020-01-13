package hibernate.demo;

import demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class DeleteStudentdemo {

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

            //deleting cez delete
//            System.out.println("deleting student");
//            session.delete(student);

            //deleting cez query
            System.out.println("deleting with id 2");
            session.createQuery("delete from Student where id=2").executeUpdate();

            session.getTransaction().commit();


        }
        finally {
            factory.close();
        }
    }
}
