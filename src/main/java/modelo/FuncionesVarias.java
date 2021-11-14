package modelo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FuncionesVarias {

	
	public String getDateTime() {
		String date = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss").format(LocalDateTime.now());
		date = date.replace('/', '-');
		date = date.replace(':', '-');
		return date;
	}


}
