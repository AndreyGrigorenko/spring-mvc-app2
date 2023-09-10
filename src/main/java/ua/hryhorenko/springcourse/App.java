package ua.hryhorenko.springcourse;

import ua.hryhorenko.springcourse.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 */
public class App {
  public static void main(String[] args) {
    Configuration configuration = new Configuration().addAnnotatedClass(Person.class);
    SessionFactory sessionFactory = configuration.buildSessionFactory();
    Session session = sessionFactory.getCurrentSession();

    try {
      session.beginTransaction();

      Person person1 = new Person("Tom", 30);
      Person person2 = new Person("Bob", 20);
      Person person3 = new Person("Katy", 35);

      session.save(person1);
      session.save(person2);
      session.save(person3);

      session.getTransaction().commit();
    } finally {
      sessionFactory.close();
    }
  }
}
