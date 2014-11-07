package interfaces;

import java.util.List;

import javax.ejb.Local;


import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.xml.bind.annotation.XmlRootElement;

import entities.Picture;
import entities.User;

@Path("/pictureManagement")
@XmlRootElement
@Local
public interface PictureBeanLocal {
 
	@Path("/AddPicture")
	@POST
	@Consumes("application/json")
	public void addPicture(Picture picture);
	
	@Path("/UpdatePicture")
	@POST
	@Consumes("application/json")
	public void updatePicture(Picture picture);
	
	@Path("/remove/{id}")
	@GET
	@Produces("application/json")
	public void removePicture(@PathParam("id") int id);
	
	@GET
	@Produces("application/json")
	@Path("/findPicture/{pictureId}")
	public Picture findPicture(@PathParam("pictureId") int id);
	
	
	
	@GET
	@Produces("application/json")
	@Path("/findAllPictureDesactivated/{pictureId}")
	public List<Picture> findDesactivated(@PathParam("pictureId") int pictureId);
	
	@GET
	@Produces("application/json")
	@Path("/findAllPictures")
	public List<Picture> findAllPictures();
	
	
	@GET
	@Produces("application/json")
	@Path("/findAllPictureBySection/{sectionId}")
    public List<Picture> findBySection(@PathParam("sectionId") String section);
	
	@GET
	@Produces("application/json")
	@Path("/findAllPictureByName/{pictureId}")
    public List<Picture> findByName(@PathParam("pictureId") String name);
	
	@GET
	@Produces("application/json")
	@Path("/findAllPictureBySybCategory/{pictureId}")
    public List<Picture> findBySubcategory(@PathParam("pictureId") String pictureSubCategory);

	@GET
	@Produces("application/json")
	@Path("/findByUser/{pictureOwner}")
	public List<Picture> findByUser(@PathParam("pictureOwner") int pictureOwner);

}
