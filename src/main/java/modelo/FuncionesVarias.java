package modelo;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Base64;

import org.apache.commons.io.FileUtils;

public class FuncionesVarias {
	public static String getDateTime() {
		String date = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss").format(LocalDateTime.now());
		date = date.replace('/', '-');
		date = date.replace(':', '-');
		return date;
	}
	
	public static String getbase64img(String ruta)throws IOException {
		File image = new File(ruta);
        String base64 = new String(Base64.getEncoder().encode(FileUtils.readFileToByteArray(image)), "UTF-8");
		return base64;
	}

}
