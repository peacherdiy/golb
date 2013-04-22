package org.monkeyperson.appserver;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import com.sun.net.httpserver.*;

/**
 * <b>jdk自带的http Server</b>
 * @author hesheng
 * @since  monkeyperson.appserver1.0
 */
public class AppServer implements AppServerInter{
	
	private HttpServer hs = null;
	
	public void start() {
		try {  
			hs = HttpServer.create(new InetSocketAddress("localhost", 8899), 3);//设置HttpServer的端口为
            hs.createContext("/", new HttpHandler(){
            	 public void handle(HttpExchange t) throws IOException {  
            		  //InputStream is = t.getRequestBody();
	        		  String response = "<font color='#ff0000'>come on baby</font>";
	        		  t.sendResponseHeaders(200, response.length());
	        		  OutputStream os = t.getResponseBody();
	        		  os.write(response.getBytes());
	        		  os.close(); 
            	 }
            });
            hs.setExecutor(null); // creates a default executor  
            hs.start();  
        } catch (IOException e) { 
            e.printStackTrace();  
        }  
	}

	public void stop() {
		hs.stop(0);
	}
	
	public static void main(String[] args) {
		AppServerInter asi = new AppServer();
		asi.start();
		
		try {
			Thread.sleep(2*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		asi.stop();
	}
}
