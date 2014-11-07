package entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-10-13T05:24:15.825+0100")
@StaticMetamodel(Category.class)
public class Category_ {
	public static volatile SingularAttribute<Category, Integer> id;
	public static volatile SingularAttribute<Category, String> name;
	public static volatile ListAttribute<Category, SubCategory> subCategories;
}
