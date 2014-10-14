package interfaces;

import java.util.List;

import javax.ejb.Local;

import entities.Workshop;


@Local
public interface WorkShopBeanLocal {
	public boolean addWorkShop(Workshop workshop);
	public boolean updateWorkShop(Workshop workshop);
	public boolean removeWorkShop(Workshop workshop);
	public boolean removeWorkShop(int id);
	public Workshop findWorkShop(int id);
	public List<Workshop> findAllWorkShop();
}
