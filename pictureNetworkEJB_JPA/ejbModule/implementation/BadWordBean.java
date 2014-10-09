package implementation;

import interfaces.BadWordBeanLocal;
import interfaces.BadWordBeanRemote;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
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
		em.remove(badword);
		return true;
	}

	@Override
	public Boolean updateBadWord(BadWorld badword) {
		if (emf != null) {
			em = emf.createEntityManager();
		}
		if (em != null) {
			em.merge(badword);
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
