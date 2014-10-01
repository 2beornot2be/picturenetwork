package entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-09-30T00:17:03.046+0100")
@StaticMetamodel(SubCategory.class)
public class SubCategory_ {
	public static volatile SingularAttribute<SubCategory, Integer> id;
	public static volatile SingularAttribute<SubCategory, String> name;
	public static volatile SingularAttribute<SubCategory, Category> parentCategory;
	public static volatile ListAttribute<SubCategory, Picture> pictures;
}
