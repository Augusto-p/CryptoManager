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
import java.util.ArrayList;
import java.util.Base64;

import javax.swing.JSlider;

import org.apache.commons.io.FileUtils;
import org.json.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import entidades.MonedaEntidad;

public class Scraping {
	public static MonedaEntidad getdataScraping(String NIK) throws IOException {
		MonedaEntidad crypto = null;
		String name = getNameScraping(NIK);
		String img = "NOIMG";
		if (name != "ERROR") {
			img = getImagenScraping(name.toLowerCase());
		}
		crypto = new MonedaEntidad(NIK, name, img);
		return crypto;
	}
	
	public static String getImagenScraping(String name) throws IOException {
		String base64 = "NOIMG";
		String url = "https://crypto.com/price/"+ name.toLowerCase();
		String page;
		try {
			page = returnHttpGet(url);
			String page0 = page.split("<div class=\"css-42e2b4\">")[1];
			String page1 = page0.split("</noscript>")[0];
			String page2 = page1.split("<noscript>")[1];
			String page3 = page2.split(" src=\"")[1];
			String page4 = page3.split("\" decoding=")[0];
			String page5 = page4.replaceAll("&amp;", "&");
			String img = "https://crypto.com"+page5;
			if (FuncionesVarias.downimage(img, "logo")) {
				base64 = FuncionesVarias.getbase64img();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
        return base64;
		
	}

	
	public static String getNameScraping(String NIK) {
		String url = "https://api.exchange.cryptomkt.com/api/3/public/currency/"+ NIK;
		String name = "ERROR";
		try {
			String a = returnHttpGet(url);
			String b = a.split(",")[0];
			String c = b.split(":")[1];
			name = c.replace("\"", "");
		} catch (Exception e) {
			;
		}
		
		return name;
		
		
	}
	
	public static String returnHttpGet(String urlParaVisitar) throws Exception {
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
