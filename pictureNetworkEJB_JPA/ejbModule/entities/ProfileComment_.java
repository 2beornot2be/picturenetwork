package entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-09-30T22:01:07.713+0100")
@StaticMetamodel(ProfileComment.class)
public class ProfileComment_ extends Comment_ {
	public static volatile SingularAttribute<ProfileComment, User> reciever;
	public static volatile SingularAttribute<ProfileComment, Profile> userProfile;
}
