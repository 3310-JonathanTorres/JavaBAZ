package com.wizeline.DAO;

import java.util.logging.Logger;

public class UserDAOImpl implements UserDAO {

	private static final Logger LOGGER = Logger.getLogger(UserDAOImpl.class.getName());
	
	@Override
	public String createUser(String user, String password) {
		LOGGER.info("Inicia procesamiento en capa de acceso de datos");
		LOGGER.info("Inicia proceso de alta de usuaro en BD...");
		LOGGER.info("Alta exitosa");
		return "success";
	}

	@Override
	public String login(String user, String password) {
		LOGGER.info("Inicia procesamiento en capa de acceso de datos");
		LOGGER.info("Inicia proceso de login...");
		LOGGER.info("Login exitoso");
		return "success";
	}

}
