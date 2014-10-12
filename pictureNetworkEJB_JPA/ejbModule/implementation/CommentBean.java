package implementation;

import java.util.Date;
import java.util.List;



import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import entities.Comment;
import interfaces.CommentBeanLocal;
import interfaces.CommentBeanRemote;


@Stateless
public class CommentBean implements CommentBeanLocal,CommentBeanRemote {

	 /**
     * Default constructor. 
     */
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
	public boolean addComment(Comment comment) {
		
		begin();
		em.persist(comment);
		return false;
	}

	@Override
	public boolean updateComment(Comment comment) {
	begin();
		comment.setDateModified(new Date());
		em.merge(comment);
		return false;
	}

	@Override
	public boolean removeComment(Comment comment) {
		// TODO Auto-generated method stub
		begin();
			em.remove(comment);
			
		return false;
	}

	@Override
	public boolean removeComment(int id) {
		begin();
		
			Comment m = findComment(id);
			
				em.remove(m);
			
		
		return false;
	}

	@Override
	public Comment findComment(int id) {
	
		begin();
		
			return em.find(Comment.class, id);
		
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Comment> findAllComment() {
		
	
		begin();
		return em.createQuery("select u from Comment u").getResultList();
		
	}

}
