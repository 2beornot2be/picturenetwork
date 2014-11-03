package implementation;

import java.util.Date;
import java.util.List;
















import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NamedQuery;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.FetchProfile.FetchOverride;
import org.hibernate.annotations.NamedQueries;

import entities.Comment;
import entities.Picture;
import interfaces.CommentBeanLocal;
import interfaces.CommentBeanRemote;
// update akram





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
	
	//testee
	@Override
	public void addComment(Comment comment) {
		
		begin();
		comment.setDateCreated(new Date());
		comment.setDateModified(new Date());
		em.merge(comment);
		
	}
	
	//testee
	@Override
	public void updateComment(Comment comment) {
	begin();
		comment.setDateModified(new Date());
		em.merge(comment);
		
	}


	//testee
	@Override
	public void removeComment(Comment comment) {
		// TODO Auto-generated method stub
		begin();
			removeComment(comment.getId());
			
			
	}
	
	//testee
	@Override
	public void removeComment( int id) {
		begin();
		
			Comment m = findComment(id);
			
			em.remove(em.contains(m) ?m : em.merge(m));
			
		
			
	}
	
	//testee
	@Override
	public Comment findComment( int id) {
	
		begin();
		
			return em.find(Comment.class, id);
		
		
	}
	
	//testee
	@Override
	@javax.ejb.TransactionAttribute(TransactionAttributeType.REQUIRED)
	public List<Comment> findAllComment( int pictureId) {
		
	
		begin();
		return em.createNamedQuery("commentsOfPicture", Comment.class).setParameter("pictureId", pictureId).getResultList();
		
	}

}
