package interfaces;

import java.util.List;

import javax.ejb.Remote;

import entities.Workshop;

@Remote
public interface WorkShopBeanRemote {
	public boolean addWorkShop(Workshop workshop);
	public boolean updateWorkShop(Workshop workshop);
	public boolean removeWorkShop(Workshop workshop);
	public boolean removeWorkShop(int id);
	public Workshop findWorkShop(int id);
	public List<Workshop> findAllWorkShop();
}
