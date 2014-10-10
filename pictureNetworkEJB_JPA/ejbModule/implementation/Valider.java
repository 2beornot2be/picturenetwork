package implementation;

import interfaces.BadWordBeanRemote;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import entities.BadWorld;
// 1 minute je verifie => c'est bon
public class Valider {

	public boolean valider(String message) {
		String temp[] = message.split(" ");
		boolean ok = true;
		Context context;
		try {
			context = new InitialContext();
			BadWordBeanRemote cs = (BadWordBeanRemote) context
					.lookup("/pictureNetworkEJB_JPA/BadWordBean!interfaces.BadWordBeanRemote");
			
			java.util.List<BadWorld> bads = cs.findAllBadWorld();
			for (BadWorld bad : bads) {

				for (String word : temp) {

					if (word.equals(bad)) {
						ok = false;
					}
					return ok;
				}

			}

		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // c un proxy , link to the object

		return ok;
	}
}