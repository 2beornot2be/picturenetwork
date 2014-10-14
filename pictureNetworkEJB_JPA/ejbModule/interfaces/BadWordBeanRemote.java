package interfaces;

import java.util.List;

import javax.ejb.Remote;

import entities.BadWorld;

@Remote
public interface BadWordBeanRemote {
	public Boolean addBadWord(BadWorld badword);
	public Boolean removeBadWord(BadWorld badword);
	public Boolean updateBadWord(BadWorld badword);
	public boolean removeBadWord(int id);
	public BadWorld findBadWord(int id);
	public boolean valider(String message);
	public List<BadWorld> findAllBadWorld();
}
