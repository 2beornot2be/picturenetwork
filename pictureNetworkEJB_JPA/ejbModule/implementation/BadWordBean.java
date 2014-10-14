package implementation;

import interfaces.BadWordBeanLocal;
import interfaces.BadWordBeanRemote;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import entities.BadWorld;

@Stateless
@LocalBean
public class BadWordBean implements BadWordBeanLocal, BadWordBeanRemote {
	@PersistenceUnit(name = "pictureNetwork")
	private EntityManagerFactory emf;
	private EntityManager em;

	private void begin() {
		if (emf != null) {
			em = emf.createEntityManager();
		}
	}
	@Override
	public boolean valider(String message) {
		String temp[] = message.split(" ");
		boolean ok = true;
		
		try {
			
			List<BadWorld>bads = findAllBadWorld();
			for (BadWorld bad : bads) {

				for (String word : temp) {

					if (word.equalsIgnoreCase( bad.getDescription()) ) {
						ok = false;
						System.out.println("bad word detected");
						return ok;
					}
					
				}

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // c un proxy , link to the object

		return ok;
	}
	@Override
	public Boolean addBadWord(BadWorld badword) {

		begin();
		if (em == null) {
			System.err.println("\n\n\nEM == NULL\n\n\n");
		}
		if (em != null) {

			em.persist(badword);

			return true;
		}

		return false;

	}

	@Override
	public Boolean removeBadWord(BadWorld badword) {
		if (emf != null) {
			em = emf.createEntityManager();
		}
		if (em != null) {
			em.remove(em.contains(badword) ? badword : em.merge(badword));
			return true;
		}
		return false;
	}

	@Override
	public Boolean updateBadWord(BadWorld badword) {
		if (emf != null) {
			em = emf.createEntityManager();
		}
		if (em != null) {
			em.merge(badword);
			System.out.println("updated badword " + badword.getDescription());
			return true;
		}

		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BadWorld> findAllBadWorld() {
		return em.createQuery("select u from BadWorld u").getResultList();
	}

	@Override
	public boolean removeBadWord(int id) {
		if (emf != null) {
			em = emf.createEntityManager();
		}
		if (em != null) {
			BadWorld a = findBadWord(id);
			if (a != null) {
				em.remove(a);
				return true;
			}
		}
		return false;
	}

	@Override
	public BadWorld findBadWord(int id) {
		if (emf != null) {
			em = emf.createEntityManager();
		}
		// TODO Auto-generated method stub
		BadWorld badword = null;
		if (em != null) {
			return em.find(BadWorld.class, id);

		}

		return badword;
	}
}
