import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

/**
 * @author Wizeline
 *
 */
public class LearningJava {
    
	/**
	 * Descripcion: Metodo principal de del proyecto LearningJava
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
        
		/** This class implements a simple HTTP server  */
		HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        server.createContext("/api/restTest", (exchange -> {
        	 OutputStream output = exchange.getResponseBody();
        	 String responseText = "";
        	/** Validates the type of http request  */
            if ("GET".equals(exchange.getRequestMethod())) {
                responseText = "Rest service succes... HTTP request of type GET";
                exchange.sendResponseHeaders(200, responseText.getBytes().length);
            } else if ("POST".equals(exchange.getRequestMethod())){
                responseText = "Rest service succes... HTTP request of type POST";
                exchange.sendResponseHeaders(200, responseText.getBytes().length);
            } else {
            	/** 405 Method Not Allowed */
            	exchange.sendResponseHeaders(405, -1);
            }
            /** 
             * Always remember to close the resources you open. 
             * Avoid memory leaks 
             */
            output.write(responseText.getBytes());
            output.flush();
            output.close();
            exchange.close();
        }));
        /** creates a default executor */
        server.setExecutor(null); 
        server.start();
    }
}
