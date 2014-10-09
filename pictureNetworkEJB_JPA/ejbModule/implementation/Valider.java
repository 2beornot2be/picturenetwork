package implementation;

import javax.enterprise.inject.spi.Bean;

import org.apache.taglibs.standard.lang.jstl.test.Bean1;

public class Valider {

	public boolean valider(String message){
		String temp[]=message.split(" ");
		boolean  ok=true;
		for (String  word : temp) {
			
			//**********************qoisdiqslm
				
			if(ok==false)
					return ok;
		}
		
		return ok;
	}
}
