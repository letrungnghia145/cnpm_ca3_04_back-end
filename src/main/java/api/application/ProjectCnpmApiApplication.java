package api.application;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjectCnpmApiApplication implements CommandLineRunner {
	@Autowired
	private SessionFactory sessionFactory;

	@Autowired

	public static void main(String[] args) {
		SpringApplication.run(ProjectCnpmApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		useSessionFactory();

	}

	private void useSessionFactory() {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();

			session.getTransaction().commit();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		session.close();
	}
}
