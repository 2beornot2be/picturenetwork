package entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-09-30T00:17:03.046+0100")
@StaticMetamodel(Profile.class)
public class Profile_ {
	public static volatile SingularAttribute<Profile, Integer> id;
	public static volatile SingularAttribute<Profile, User> profileOwner;
	public static volatile ListAttribute<Profile, User> friends;
	public static volatile ListAttribute<Profile, User> followers;
	public static volatile ListAttribute<Profile, ProfileComment> profileComments;
}
