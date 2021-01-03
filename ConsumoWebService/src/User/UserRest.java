package User;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.IOException;
import java.io.InputStream;

import javax.net.ssl.HttpsURLConnection;

public class UserRest {

	public static void sendGet(String url) throws Exception {

		URL getUser = new URL(url);

		HttpURLConnection con = (HttpURLConnection) getUser.openConnection();

		con.setRequestMethod("GET");
		con.setRequestProperty("User-Agent", "Meu browser");
		int responseCode = con.getResponseCode();

		System.out.println("Enviar Get Request para a url " + url);
		System.out.println("Código de retorno " + responseCode);

		InputStreamReader isr = new InputStreamReader(con.getInputStream());
		BufferedReader buff = new BufferedReader(isr);

		String inputLine;

		while ((inputLine = buff.readLine()) != null) {
			System.out.println(inputLine);
		}
		buff.close();
	}

	public static String sendPost(String url) throws Exception {

		String responseStr = null;

		// make POST request
		String jsonContent = "{'username: 'aa', 'nome': 'aa', 'sobrenome': 'aa', 'email': 'aaa', 'password': '123'}";

		URL getUser = new URL(url);

		HttpURLConnection con = (HttpURLConnection) getUser.openConnection();

		con.setDoOutput(true);
		con.setDoInput(true);
		con.setInstanceFollowRedirects(false);
		con.setRequestMethod("POST");
		con.setRequestProperty("Content-Type", "application/json");
		con.setRequestProperty("charset", "utf-8");
		con.setRequestProperty("Content-Length", "" + Integer.toString(jsonContent.getBytes().length));
		con.setUseCaches(false);
		
		OutputStreamWriter writer = new OutputStreamWriter(con.getOutputStream(), "UTF-8");
		con.disconnect();
		writer.write(jsonContent);
		writer.close();
		
		 responseStr = "Response code: " + con.getResponseCode() + " and mesg:" +
		 con.getResponseMessage();
		 

		System.out.println(con.getResponseMessage());
		
		
		 DataOutputStream dos = new DataOutputStream(con.getOutputStream());
		 

		InputStream response;

		// Check for error , if none store response
		if (con.getResponseCode() == 200) {
			response = con.getInputStream();
		} else

		{
			response = con.getErrorStream();
		}
		InputStreamReader isr = new InputStreamReader(response);
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(isr);
		String read = br.readLine();
		while (read != null) {
			sb.append(read);
			read = br.readLine();
		} // Print the String System.out.println(sb.toString());

		con.disconnect();

		return responseStr;
	}



	public static void main(String[] args) throws Exception {

		
		 String url_usr3 = "http://localhost:8080/api/user/buscaPorId/3";
		 sendGet(url_usr3);
		 

		/*
		 * String url_createUser = "http://localhost:8080/api/user/create";
		 * sendPost(url_createUser);
		 */

	}

}
