package ch.bbc.uek223.openair.entitytest;

import org.junit.Assert;
import org.junit.Test;

public class StartEntityManagerTest extends EntityManagerTest {

	@Test
	public void startEntityManager() {
		Assert.assertTrue("Entity Manager aktiv?", em.isOpen());
	}
	
	

}
