package interfaces;

import java.util.List;

import javax.ejb.Remote;

import entities.Picture;
import entities.User;

@Remote
public interface PictureBeanRemote {

	
	public void addPicture(Picture picture);
	public void updatePicture(Picture picture);
	public void removePicture(int id);
	
	public Picture findPicture(int id);
	public List<Picture> findAllPicture();
	public List<Picture> findDesactivated();
    public List<Picture> findBySection(String section);
    public List<Picture> findByName(String name);
    public List<Picture> findBySubcategory(String pictureSubCategory);
	


}
