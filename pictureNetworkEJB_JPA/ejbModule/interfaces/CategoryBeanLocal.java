package interfaces;

import java.util.List;

import javax.ejb.Local;

import entities.Category;
import entities.Comment;
import entities.SubCategory;

@Local
public interface CategoryBeanLocal {
	public boolean addCategory(Category category);
	 public Category findCategory(int id);
	 public boolean updateCategory(Category category);
	 public boolean removeCategory(Category category);
	 public boolean removeCategory(int id);
	 public List<Category> findAllCategories();
}
