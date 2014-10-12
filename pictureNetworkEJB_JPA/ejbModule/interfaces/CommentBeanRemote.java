package interfaces;

import java.util.List;

import javax.ejb.Remote;

import entities.Comment;

@Remote
public interface CommentBeanRemote {

    public boolean addComment(Comment comment);
	public boolean updateComment(Comment comment);
	public boolean removeComment(Comment comment);
	public boolean removeComment(int id);
	public Comment findComment(int id);
	
	public List<Comment> findAllComment();
}
