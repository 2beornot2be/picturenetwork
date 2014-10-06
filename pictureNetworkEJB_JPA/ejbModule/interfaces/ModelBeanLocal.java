package interfaces;

import java.util.List;

import javax.ejb.Local;

import entities.Model;


@Local
public interface ModelBeanLocal {
	public boolean addModel(Model Model);
	public Model authenticateModel(String first, String last, String Password);
	public boolean updateModel(Model Model);
	public boolean removeModel(Model Model);
	public boolean removeModel(int id);
	public Model findModel(int id);
	public boolean desactivateReactivateModel(Model model, boolean desactivate);
	public List<Model> findAllModels();
	public List<Model> findAllDesactivatedModels();
	
}
