package interfaces;

import java.util.List;

import javax.ejb.Local;

import entities.BadWorld;

@Local
public interface BadWordBeanLocal {
	public Boolean addBadWord(BadWorld badword);
	public Boolean removeBadWord(BadWorld badword);
	public Boolean updateBadWord(BadWorld badword);
	public boolean removeBadWord(int id);
	public BadWorld findBadWord(int id);
	
	public List<BadWorld> findAllBadWorld();
	public boolean valider(String message);
	
	

}
