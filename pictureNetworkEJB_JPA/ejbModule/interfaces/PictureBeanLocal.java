package interfaces;

import java.util.List;

import javax.ejb.Local;


import entities.Picture;

@Local
public interface PictureBeanLocal {
 
	public boolean addPicture(Picture picture);
	public boolean updatePicture(Picture picture);
	public boolean removePicture(int id);
	
	public Picture findPicture(int id);
	public List<Picture> findAllPicture();
    public List<Picture> findBySection(String section);
    public List<Picture> findByName(String name);
    public List<Picture> findBySubcategory(String pictureSubCategory);


}
