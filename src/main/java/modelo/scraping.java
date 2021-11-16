package modelo;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;

import org.apache.commons.io.FileUtils;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class scraping {
	public int getdataScraping(String NIK) throws IOException {
		int R = 0; // r = 0 (no se encontro nada) | R = 1 (se enconto solo el nombre) | R = 2 (se encontro todo)
		String Name = getNameScraping(NIK);
		if (Name != "ERROR") {
			String img = getImagenScraping(Name.toLowerCase());
			R = 1;
			if (img != null) {
				R = 2;
			}
		}
		
		
		return R;
		
	}
	
	public String getImagenScraping(String name) throws IOException {
		String url = "https://crypto.com/price/"+ name;
		Document page = Jsoup.connect(url).get();
		Elements div = page.select("div[class='css-42e2b4']");
		String img = (div.select("img[src]").get(1)).absUrl("src");
		try (BufferedInputStream inputStream = new BufferedInputStream(new URL(img).openStream());
			    FileOutputStream fileOS = new FileOutputStream("src/img/logo.png")) {
			    byte data[] = new byte[1024];
				int byteContent;
				while ((byteContent = inputStream.read(data, 0, 1024)) != -1) {
					fileOS.write(data, 0, byteContent);
					    }
		} catch (IOException e) {}
       
        String base64 = FuncionesVarias.getbase64img("src/img/logo.png");
        return base64;
		
	}
	
	
	public String getNameScraping(String NIK) {
		String url = "https://api.exchange.cryptomkt.com/api/3/public/currency/"+ NIK;
		String name = "ERROR";
		try {
			String r = returnHttpGet(url);
			JSONObject j = new JSONObject(r);
			name = j.get("full_name").toString();
		} catch (Exception e) {
		}
		
		return name;
		
		
	}
	
	public String returnHttpGet(String urlParaVisitar) throws Exception {
		StringBuilder resultado = new StringBuilder();
		URL url = new URL(urlParaVisitar);
		HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
		conexion.setRequestMethod("GET");
		BufferedReader rd = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
		String linea;
		while ((linea = rd.readLine()) != null) {
			resultado.append(linea);
		}
		rd.close();
		return resultado.toString();
	}

}
