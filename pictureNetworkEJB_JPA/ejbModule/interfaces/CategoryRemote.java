package interfaces;

import javax.ejb.Remote;

import entities.Category;
import entities.SubCategory;


@Remote
public interface CategoryRemote {
	public boolean addCategory(Category category);
	 public Category findCategory(int id);
}
