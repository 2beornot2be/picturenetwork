package interfaces;

import java.util.List;

import javax.ejb.Remote;

import entities.Comment;
import entities.SubCategory;

@Remote
public interface SubCategoryBeanRemote {

	public boolean addSubCategory(SubCategory subcategory);
	public boolean updateSubCategory(SubCategory subcategory);
	public boolean removeSubCategory(SubCategory subcategory);
	public boolean removeIdSubCategory(int id);
	
    public SubCategory findSubCategoryA(int id);
	
	public List<SubCategory> findAllSubCategory();
}
