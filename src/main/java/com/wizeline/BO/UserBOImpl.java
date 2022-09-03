/**
 * 
 */
package com.wizeline.BO;

import java.util.logging.Logger;

import com.wizeline.DAO.UserDAO;
import com.wizeline.DAO.UserDAOImpl;
import com.wizeline.utils.Utils;

/**
 * @author jonathan.torres
 *
 */

public class UserBOImpl implements UserBO {

	private static final Logger LOGGER = Logger.getLogger(UserBOImpl.class.getName());
	
	@Override
	public String createUser(String user, String password) {
		LOGGER.info("Inicia procesamiento en capa de negocio");
		String result = "fail"; 
		if (Utils.validateNullValue(user) && Utils.validateNullValue(password)) {
			UserDAO userDao = new UserDAOImpl();
			result = userDao.createUser(user, password);
		}
		return result;
	}

	@Override
	public String login(String user, String password) {
		LOGGER.info("Inicia procesamiento en capa de negocio");
		String result = "fail"; 
		if (Utils.validateNullValue(user) && Utils.validateNullValue(password)) {
			UserDAO userDao = new UserDAOImpl();
			result = userDao.login(user, password);
		}
		return result;
	}

}
