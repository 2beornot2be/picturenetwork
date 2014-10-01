package interfaces;

import java.util.List;

import javax.ejb.Local;

import entities.Admin;

@Local
public interface AdminBeanLocal {
	public boolean addAdmin(Admin Admin);
	public Admin authenticateAdmin(String first, String last, String Password);
	public boolean updateAdmin(Admin Admin);
	public boolean removeAdmin(Admin Admin);
	public boolean removeAdmin(int id);
	public Admin findAdmin(int id);
	public List<Admin> findAllAdmins();

}
