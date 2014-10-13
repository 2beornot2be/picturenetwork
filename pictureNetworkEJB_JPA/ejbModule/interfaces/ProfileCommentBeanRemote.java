package interfaces;

import java.util.List;

import javax.ejb.Remote;

import entities.Comment;

@Remote
public interface ProfileCommentBeanRemote {
	public boolean addProfileComment(Comment comment);
	
	public boolean updateProfileComment(Comment comment);
	public boolean removeProfileComment(Comment comment);
	public boolean removeProfileComment(int id);
	public Comment findProfileComment(int id);
	
	public List<Comment> findAllProfileComment();

}
