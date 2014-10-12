package interfaces;

import javax.ejb.Local;

import entities.Category;
import entities.Comment;
import entities.SubCategory;

@Local
public interface CategoryLocal {
	public boolean addCategory(Category category);
	 public Category findCategory(int id);
}
