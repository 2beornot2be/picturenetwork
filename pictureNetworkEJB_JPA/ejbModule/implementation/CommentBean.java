package implementation;

import java.util.Date;
import java.util.List;











import javax.ejb.Stateless;
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

import entities.Comment;
import entities.Picture;
import interfaces.CommentBeanLocal;
import interfaces.CommentBeanRemote;
// update akram
@NamedQuery(name="commentsOfPicture", query="select u from Comment u where u.picture.id := pictureId")



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
		em.merge(comment);
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
			em.remove(em.contains(comment) ?comment : em.merge(comment));
			
		return true;
	}
	
	
	@Override
	public boolean removeComment( int id) {
		begin();
		
			Comment m = findComment(id);
			
			em.remove(em.contains(m) ?m : em.merge(m));
			
		
		return false;
	}
	
	
	@Override
	public Comment findComment( int id) {
	
		begin();
		
			return em.find(Comment.class, id);
		
		
	}
	
	
	@Override
	public List<Comment> findAllComment( int pictureId) {
		
	
		begin();
		return em.createNamedQuery("commentsOfPicture").setParameter("pictureId", pictureId).getResultList();
		
	}

}
