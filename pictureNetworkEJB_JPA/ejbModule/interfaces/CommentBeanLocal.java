package interfaces;

import java.util.List;

import javax.ejb.Local;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import entities.Comment;
import entities.Picture;

@Path("/pictureCommentsLocal")
@Local
public interface CommentBeanLocal {

	@POST
	@Path("/add")
	@Consumes("application/json")
    public void addComment(Comment comment);
	
	@POST
	@Path("/update")
	@Consumes("application/json")
	public void updateComment(Comment comment);
	
	@POST
	@Path("/remove")
	@Consumes("application/json")
	public void removeComment(Comment comment);
	
	@Path("/remove/{id}")
	@GET
	@Produces("application/json")
	public void removeComment(@PathParam("id") int id);

	@GET
	@Produces("application/json")
	@Path("/findCommentOfPicture/{commentId}")
	public Comment findComment(@PathParam("commentId") int id);
	
//	public List<Comment> findAllComment();
	//List<Comment> findAllComment(Picture p);
	@GET
	@Produces("application/json")
	@Path("/findCommentsOfPicture/{pictureId}")
	
	List<Comment> findAllComment(@PathParam("pictureId") int pictureId);

}
