package implementation;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import entities.Comment;
import entities.ModelState_Activation;
import entities.Picture;
import entities.SubCategory;
import entities.User;
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
	public void addPicture(Picture picture) {
		// TODO Auto-generated method stub
		begin();
		picture.setDateAdded(new Date());
		em.merge(picture);
		
	}

	@Override
	public void updatePicture(Picture picture) {
		// TODO Auto-generated method stub
		begin();
		picture.setDateAdded(new Date());
		em.merge(picture);
		
	}

	@Override
	public void removePicture(int id) {
		begin();
			if(em != null)
			{
				Picture mp= findPicture(id);
				if(mp != null)
				{
					em.remove(em.contains(mp) ? mp : em.merge(mp));
				}
				
			}
			
		
	
	
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
	
		List<Picture> pictures = null;
		if(em != null)
		{
			String query = String.format("select  u from Picture u where u.Section = '%s'", section);
			pictures =  (List<Picture>) em.createQuery(query).getResultList();
			
		}
		
		return pictures;
		
	}
		
	

	@Override
	public List<Picture> findByName(String name) {
		begin();
		List<Picture> pictures = null;
		if(em != null)
		{
			String query = String.format("select  u from Picture u where u.name = '%s'", name);
			pictures =  (List<Picture>) em.createQuery(query).getResultList();
			
		}
		
		return pictures;
		
	}
	
	@Override
	public List<Picture> findBySubcategory(String pictureSubCategory) {
		begin();
		List<Picture> pictures = null;
		if(em != null)
		{
			String query = String.format("select  u from Picture u where u.pictureSubCategory.name = '%s'", pictureSubCategory );
			pictures =  (List<Picture>) em.createQuery(query).getResultList();
			
		}
		
		return pictures;
		
		
	}


	@Override
	public List<Picture> findDesactivated() {
		// TODO Auto-generated method stub
		begin();
		List<Picture> pictures = null;
		if(em != null)
		{
			String query = String.format("select  u from Picture u where u.activation = '%s'", ModelState_Activation.DESACTIVATED.toString() );
			pictures =  (List<Picture>) em.createQuery(query).getResultList();
			
		}
		
		return pictures;
	}


	@Override
	public List<Picture> findDesactivated(int pictureId) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Picture> findByUser(int pictureOwner) {
		begin();
		List<Picture> pictures = null;
		if(em != null)
		{
			String query = String.format("select  u from Picture u where u.pictureOwner.id = %d", pictureOwner );
			pictures =  (List<Picture>) em.createQuery(query).getResultList();
			
		}
		
		return pictures;
	}


	@Override
	public List<Picture> findAllPictures() {
		// TODO Auto-generated method stub
		begin();
		List<Picture> pictures = null;
		if(em != null)
		{
			String query = String.format("select  u from Picture u" );
			pictures =  (List<Picture>) em.createQuery(query).getResultList();
			
		}
		
		return pictures;
	}


	
	
	

}
