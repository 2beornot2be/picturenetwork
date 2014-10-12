package interfaces;

import java.util.List;

import javax.ejb.Local;



import javax.persistence.Id;

import entities.Comment;
import entities.SubCategory;

@Local
public interface SubCategoryBeanLocal {
	
	public boolean addSubCategory(SubCategory subcategory);
	public boolean updateSubCategory(SubCategory subcategory);
	public boolean removeSubCategory(SubCategory subcategory);
	public boolean removeIdSubCategory(int id);
	
    public SubCategory findSubCategoryA(int id);
	
	public List<SubCategory> findAllSubCategory();
	
}
