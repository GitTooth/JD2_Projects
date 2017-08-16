package by.epam.library.dao.impl;

import java.io.IOException;

import by.epam.library.dao.InitializationDAO;
import by.epam.library.dao.connection.ConnectionPool;
import by.epam.library.dao.exception.ConnectionPoolException;
import by.epam.library.dao.exception.DAOException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class InitializationDAOImpl implements InitializationDAO {

	@Override
	public void initialization() throws DAOException {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		ConnectionPool connectionPool  = context.getBean("connectionPool", ConnectionPool.class);
		
		try {
			connectionPool.init();
		} catch (ConnectionPoolException e) {
			throw new DAOException("There was a problem initialization database", e);
		}
	}

	@Override
	public void destroy() throws DAOException {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		ConnectionPool connectionPool  = context.getBean("connectionPool", ConnectionPool.class);
		
		try {
			connectionPool.close();
		} catch (IOException e) {
			throw new DAOException("Failure to close all connections", e);
		}
	}

}
