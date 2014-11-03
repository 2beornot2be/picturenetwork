package interfaces;

import java.util.List;

import javax.ejb.Remote;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.xml.bind.annotation.XmlRootElement;

import entities.Comment;
import entities.Picture;
@Path("/pictureComments")
@XmlRootElement
@Remote
public interface CommentBeanRemote {
	
	@PUT
	@Consumes("application/xml")
    public boolean addComment(Comment comment);
	
	@POST
	@Consumes("application/xml")
	public boolean updateComment(Comment comment);
	
	@DELETE
	@Consumes("application/xml")
	public boolean removeComment(Comment comment);
	
	@Path("{id}")
	@DELETE
	@Produces("application/xml")
	public boolean removeComment(@PathParam("id") int id);

	@GET
	@Produces("application/xml")
	@Path("findCommentOfPicture/{commentId}")
	public Comment findComment(@PathParam("commentId") int id);
	
//	public List<Comment> findAllComment();
	//List<Comment> findAllComment(Picture p);
	@GET
	@Produces("application/xml")
	@Path("findCommentsOfPicture/{pictureId}")
	List<Comment> findAllComment(@PathParam("pictureId") int pictureId);
}
