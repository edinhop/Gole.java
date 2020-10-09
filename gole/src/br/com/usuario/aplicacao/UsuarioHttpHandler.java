package br.com.usuario.aplicacao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.text.ParseException;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import br.com.usuario.controller.UsuarioController;

public class UsuarioHttpHandler implements HttpHandler {
	
	@Override
	public void handle (HttpExchange httpExchange) throws IOException {
		
		if (null == httpExchange.getRequestMethod()) {
			
		} else 
				httpExchange.getRequestHeaders().add("Access-Control-Allow-Origin", "http://localhost:3000");
		
		if (httpExchange.getRequestMethod().equalsIgnoreCase("OPTIONS")) {
            httpExchange.getResponseHeaders().add("Access-Control-Allow-Methods", "GET, POST, DELETE, OPTIONS");
            httpExchange.getResponseHeaders().add("Access-Control-Allow-Headers", "Content-Type,Authorization");
            httpExchange.sendResponseHeaders(204, -1);
            return;
        }
		switch (httpExchange.getRequestMethod()) {
		case "GET":
			try {
				handleGetRequest(httpExchange);
			} catch (IOException | JSONException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		case "POST":
			try {
				handlePostRequest(httpExchange);
			} catch (IOException e) {
				
				e.printStackTrace();
			} catch (ParseException e) {
				
				e.printStackTrace();
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		case "PUT":
			handlePutRequest(httpExchange);
		case "DELETE":
			try {
				handleDeleteRequest(httpExchange);
			} catch (JSONException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		default:
	}
}
	
	private void handleGetRequest (HttpExchange httpExchange) throws IOException, JSONException {
		UsuarioController controller = new UsuarioController();
		
		String requestUri = httpExchange.getRequestURI().toString();
		OutputStream outStream = httpExchange.getResponseBody();
		
		JSONObject json;
		int id = 0;
		
		if (requestUri.split("/").length <= 2) {
				JSONArray jsonArray = new JSONArray();
				jsonArray = null;
				
				try {
					jsonArray = controller.Index();
					httpExchange.sendResponseHeaders(200, jsonArray.toString().getBytes().length);
					outStream.write(jsonArray.toString().getBytes("UTF-8"));
					
				} catch (IOException e) {
					
						json = new JSONObject();
						json.put("status", "not found");
						outStream.write(json.toString().getBytes());
				}
				
				outStream.flush();
				outStream.close();
				
		} else {
			
				try {
						
					id = Integer.valueOf(requestUri.split("/")[2]);
					json = controller.Show(id);
					httpExchange.sendResponseHeaders(200, json.toString().getBytes().length);
					
				} catch (IOException e) {
					
					json = new JSONObject();
					json.put("status", "server error");
					httpExchange.sendResponseHeaders(500, json.toString().length());
				}
				
				outStream.write(json.toString().getBytes());
				outStream.flush();
				outStream.close();
			}
	}

	private void handlePostRequest(HttpExchange httpExchange) throws IOException, ParseException, JSONException  {
		OutputStream outStream = httpExchange.getResponseBody();
		httpExchange.sendResponseHeaders(200, "teste".length());
		outStream.write("teste".getBytes());
		
		InputStreamReader isr = new InputStreamReader(httpExchange.getRequestBody(), "utf-8");
		BufferedReader br = new BufferedReader(isr);
		StringBuilder buf = new StringBuilder();
		
		int b;
		while ((b = br.read()) != -1) {
				buf.append((char)b);
		}
		
		br.close();
		isr.close();

		String end = buf.toString();
		
		JSONObject json = new JSONObject(end);
		System.out.println(json);
		
		UsuarioController controller = new UsuarioController();
		controller.Create(json);
		
		outStream.flush();
		outStream.close();
		
	}

	private void handlePutRequest(HttpExchange httpExchange) {
		
		
	}

	private void handleDeleteRequest(HttpExchange httpExchange) throws JSONException, IOException {
		String requestUri = httpExchange.getRequestURI().toString();
		OutputStream outStream = httpExchange.getResponseBody();
		
		JSONObject json;
		int id = 0;
		
		if (requestUri.split("/").length >= 2) {
			
			try {
					UsuarioController controller = new UsuarioController();
					id = Integer.valueOf(requestUri.split("/")[2]);
					controller.Delete(id);
					
					json = new JSONObject();
					json.put("status", "removido");
					httpExchange.sendResponseHeaders(200, json.toString().length());
					outStream.write(json.toString().getBytes());
					
			} catch (Exception e) {
				
				json = new JSONObject();
				json.put("status", "not found");
				outStream.write(json.toString().getBytes());
				httpExchange.sendResponseHeaders(404, json.toString().length());
				outStream.write(json.toString().getBytes());
				
			}
			
		} else {
			json = new JSONObject();
			json.put("status", "erro no servidor");
			outStream.write(json.toString().getBytes());
			httpExchange.sendResponseHeaders(500, json.toString().length());
			outStream.write(json.toString().getBytes());
		}
		
		outStream.flush();
		outStream.close();
	}
}