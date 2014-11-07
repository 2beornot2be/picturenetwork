package entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-10-13T11:09:08.778+0100")
@StaticMetamodel(Picture.class)
public class Picture_ {
	public static volatile SingularAttribute<Picture, Integer> id;
	public static volatile SingularAttribute<Picture, String> name;
	public static volatile SingularAttribute<Picture, String> Description;
	public static volatile SingularAttribute<Picture, SubCategory> pictureSubCategory;
	public static volatile SingularAttribute<Picture, String> Section;
	public static volatile SingularAttribute<Picture, User> pictureOwner;
	public static volatile SingularAttribute<Picture, Date> dateAdded;
	public static volatile ListAttribute<Picture, Comment> PictureComments;
	public static volatile SingularAttribute<Picture, String> url;
	public static volatile SingularAttribute<Picture, byte[]> content;
	public static volatile SingularAttribute<Picture, String> activation;
}
