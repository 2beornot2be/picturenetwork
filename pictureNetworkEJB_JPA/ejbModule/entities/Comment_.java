package entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-10-11T14:10:46.477+0100")
@StaticMetamodel(Comment.class)
public class Comment_ {
	public static volatile SingularAttribute<Comment, Integer> id;
	public static volatile SingularAttribute<Comment, String> content;
	public static volatile SingularAttribute<Comment, Date> dateCreated;
	public static volatile SingularAttribute<Comment, Date> dateModified;
	public static volatile SingularAttribute<Comment, User> sender;
	public static volatile SingularAttribute<Comment, String> credit;
}
