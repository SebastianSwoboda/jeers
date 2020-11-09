package ch.bbc.uek223.openair.entitytest;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;

import ch.bbc.uek223.jeers.entities.Person;
import ch.bbc.uek223.jeers.entities.PersonRolle;
import ch.bbc.uek223.jeers.entities.Rolle;

public class EntityManagerTest {

	protected static EntityManagerFactory emf = Persistence.createEntityManagerFactory("jeersTest");
	protected EntityManager em;

	@Before
	public void before() throws Exception {
		em = emf.createEntityManager();

		Person p = createPerson();
		Rolle r = createRolle();
		PersonRolle pr = createPersonRolle(p, r);
		
		

	}

	private PersonRolle createPersonRolle(Person p, Rolle r) {
		PersonRolle pr = new PersonRolle();
		pr.setPerson(p);
		pr.setRolle(r);
		return pr;
	}

	private Rolle createRolle() {
		Rolle r = new Rolle();
		r.setName("admin");

		return r;
	}

	private Person createPerson() {
		Person p = new Person();
		p.setName("Nachname");
		p.setVorname("Vorname");
		p.setAdresse("Teststrasse 12");
		p.setOrt("3000 Bern");
		p.setPasswort("gasdf");

		return p;
	}

	@After
	public void after() throws Exception {
		em.close();
	}

}
