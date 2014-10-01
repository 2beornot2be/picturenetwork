package entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-09-30T22:39:23.259+0100")
@StaticMetamodel(User.class)
public class User_ {
	public static volatile SingularAttribute<User, Integer> id;
	public static volatile SingularAttribute<User, String> firstName;
	public static volatile SingularAttribute<User, String> address;
	public static volatile SingularAttribute<User, String> tel;
	public static volatile SingularAttribute<User, String> password;
	public static volatile SingularAttribute<User, String> state;
	public static volatile SingularAttribute<User, String> credit;
	public static volatile ListAttribute<User, Profile> followedProfiles;
	public static volatile ListAttribute<User, Profile> friendsProfiles;
	public static volatile SingularAttribute<User, String> lastName;
}
