package implementation;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import entities.Comment;
import interfaces.ProfileCommentBeanLocal;
import interfaces.ProfileCommentBeanRemote;

@Stateless
public class ProfileCommentBean implements ProfileCommentBeanLocal,ProfileCommentBeanRemote{
	
	
	@PersistenceUnit(name="pictureNetwork")
	private EntityManagerFactory emf;
	private EntityManager em;
	 private void begin()
	    {
	    	if(emf != null)
			{
				em = emf.createEntityManager();
			}
	    }
	@Override
	public boolean addProfileComment(Comment comment) {
		begin();
		em.persist(comment);
		return false;
	}

	@Override
	public boolean updateProfileComment(Comment comment) {
		begin();
		em.merge(comment);
		return false;
	}

	@Override
	public boolean removeProfileComment(Comment comment) {
		begin();
		em.remove(comment);
		return false;
	}

	@Override
	public boolean removeProfileComment(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Comment findProfileComment(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Comment> findAllProfileComment() {
		begin();
		return em.createQuery("select u from Comment u").getResultList();
		
	}

}
