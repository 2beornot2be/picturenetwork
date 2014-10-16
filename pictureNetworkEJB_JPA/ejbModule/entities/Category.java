package entities;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.Cascade;
import javax.persistence.CascadeType;
/**
 * Entity implementation class for Entity: Category
 *
 */
@Entity
public class Category implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private static final long serialVersionUID = 1L;
	@OneToMany(mappedBy="parentCategory",cascade=CascadeType.REMOVE)
	private List<SubCategory> subCategories = null;
	
	
	@Override
	public String toString()
	{
		return name;
	}
	public Category() {
		super();
	}   
	
	
	
	public Category(String name) {
		super();
		this.name = name;
	}



	public int getId() {
		return this.id;
	}
	public Category(int id, String name) {
		
		this.id = id;
		this.name = name;
	}

	

	public Category(String name, List<SubCategory> subCategories) {
		super();
		this.name = name;
		this.subCategories = subCategories;
	}



	public Category(int id, String name, List<SubCategory> subCategories) {
		super();
		this.id = id;
		this.name = name;
		this.subCategories = subCategories;
	}



	public List<SubCategory> getSubCategories() {
		return subCategories;
	}



	public void setSubCategories(List<SubCategory> subCategories) {
		this.subCategories = subCategories;
	}



	public void setId(int id) {
		this.id = id;
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
   
}
