package interfaces;

import java.util.List;

import javax.ejb.Remote;

import entities.Category;
import entities.SubCategory;


@Remote
public interface CategoryBeanRemote {
	public boolean addCategory(Category category);
	 public Category findCategory(int id);
	 public boolean updateCategory(Category category);
	 public boolean removeCategory(Category category);
	 public boolean removeCategory(int id);
	 public List<Category> findAllCategories();
}
