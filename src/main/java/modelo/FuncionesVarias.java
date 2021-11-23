package modelo;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
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
	public static void pathS() {
		//String a = System.getProperty("user.dir");
		
		
	}
	public static boolean downimage(String imageUrl, String namefile){
		boolean r = false;
		try (BufferedInputStream inputStream = new BufferedInputStream(new URL(imageUrl).openStream());
		    FileOutputStream fileOS = new FileOutputStream(namefile+".png")) {
		    byte data[] = new byte[1024];
			int byteContent;
			while ((byteContent = inputStream.read(data, 0, 1024)) != -1) {
				fileOS.write(data, 0, byteContent);
		    }
			r = true;
		} catch (Exception e) {
			System.out.println(e.getMessage());;
		}
		
		return r;
 
	}

}
