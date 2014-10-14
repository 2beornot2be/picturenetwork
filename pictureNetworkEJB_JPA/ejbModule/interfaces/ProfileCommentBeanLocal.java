package interfaces;

import java.util.List;

import javax.ejb.Local;

import entities.Comment;

@Local
public interface ProfileCommentBeanLocal  {
    
	public boolean addProfileComment(Comment comment);
	
	public boolean updateProfileComment(Comment comment);
	public boolean removeProfileComment(Comment comment);
	public boolean removeProfileComment(int id);
	public Comment findProfileComment(int id);
	
	public List<Comment> findAllProfileComment();


}
