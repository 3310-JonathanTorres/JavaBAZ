import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.logging.Logger;

import com.sun.net.httpserver.HttpServer;
import com.wizeline.BO.UserBO;
import com.wizeline.BO.UserBOImpl;

/**
 * @author Wizeline
 *
 */
public class LearningJava {
    
	private static final Logger LOGGER = Logger.getLogger(LearningJava.class.getName());
	
	/**
	 * Descripcion: Metodo principal de del proyecto LearningJava
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		LOGGER.info("LearningJava - Iniciado servicio REST ...");
		/** This class implements a simple HTTP server  */
		HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        server.createContext("/api/restTest", (exchange -> {
        	LOGGER.info("LearningJava - Inicia procesamiento de peticion ...");
        	 OutputStream output = exchange.getResponseBody();
        	 String responseText = "";
        	/** Validates the type of http request  */
            if ("GET".equals(exchange.getRequestMethod())) {
            	LOGGER.info("LearningJava - Procesando peticion HTTP de tipo GET");
            	UserBO userBo = new UserBOImpl();
                responseText = userBo.createUser("user@wizeline.com", "pass12345");
                exchange.sendResponseHeaders(200, responseText.getBytes().length);
            } else if ("POST".equals(exchange.getRequestMethod())){
            	LOGGER.info("LearningJava - Procesando peticion HTTP de tipo POST");
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
            LOGGER.info("LearningJava - Cerrando recursos ...");
            output.write(responseText.getBytes());
            output.flush();
            output.close();
            exchange.close();
        }));
        /** creates a default executor */
        server.setExecutor(null); 
        server.start();
        LOGGER.info("LearningJava - Servicio Rest Online");
    }
}
