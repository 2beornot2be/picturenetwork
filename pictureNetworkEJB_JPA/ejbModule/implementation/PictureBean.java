package implementation;

import java.util.List;

import javax.ejb.Stateless;
import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import entities.Comment;
import entities.Picture;
import entities.SubCategory;
import interfaces.PictureBeanLocal;
import interfaces.PictureBeanRemote;

@Stateless
public class PictureBean implements PictureBeanLocal,PictureBeanRemote{

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
	public boolean addPicture(Picture picture) {
		// TODO Auto-generated method stub
		begin();
		em.persist(picture);
		return true;
	}

	@Override
	public boolean updatePicture(Picture picture) {
		// TODO Auto-generated method stub
		begin();
		em.merge(picture);
		return false;
	}

	@Override
	public boolean removePicture(int id) {
begin();
		
		Picture mp= findPicture(id);
		
			em.remove(mp);
		
	
	return false;
	}

	@Override
	public Picture findPicture(int id) {
		begin();
		
		return em.find(Picture.class, id);
	
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Picture> findAllPicture() {
		begin();
		return em.createQuery("select u from Picture u").getResultList();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Picture> findBySection(String section) {
		begin();
		List<Picture>pictures=null;
		Query query=(Query) em.createQuery("select t from Picture t where t.section",Picture.class);
		((javax.persistence.Query) query).setParameter("n", section);
		pictures=(List<Picture>) ((javax.persistence.Query) query).getResultList();
		return(pictures);
	}
		
	

	@Override
	public List<Picture> findByName(String name) {
		begin();
		List<Picture>pictures=null;
		Query query=(Query) em.createQuery("select t from Picture t where t.name",Picture.class);
		((javax.persistence.Query) query).setParameter("n", name);
		pictures=(List<Picture>) ((javax.persistence.Query) query).getResultList();
		return(pictures);
	}

}
