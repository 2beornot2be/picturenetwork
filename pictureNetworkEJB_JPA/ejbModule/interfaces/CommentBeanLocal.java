package interfaces;

import java.util.List;

import javax.ejb.Local;

import entities.Comment;
import entities.Picture;


@Local
public interface CommentBeanLocal {

	public boolean addComment(Comment comment);
	
	public boolean updateComment(Comment comment);
	public boolean removeComment(Comment comment);
	public boolean removeComment(int id);
	public Comment findComment(int id);
	
	//public List<Comment> findAllComment();

	//List<Comment> findAllComment(Picture p);

	List<Comment> findAllComment(int pictureId);

}
