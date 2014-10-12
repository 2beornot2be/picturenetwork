package interfaces;

import java.util.List;

import javax.ejb.Local;

import entities.Comment;


@Local
public interface CommentBeanLocal {

	public boolean addComment(Comment comment);
	
	public boolean updateComment(Comment comment);
	public boolean removeComment(Comment comment);
	public boolean removeComment(int id);
	public Comment findComment(int id);
	
	public List<Comment> findAllComment();

}
