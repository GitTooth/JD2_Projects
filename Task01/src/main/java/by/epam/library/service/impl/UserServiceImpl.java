package by.epam.library.service.impl;

import by.epam.library.bean.User;
import by.epam.library.dao.UserDAO;
import by.epam.library.dao.exception.DAOException;
import by.epam.library.service.UserService;
import by.epam.library.service.exception.ServiceException;
import by.epam.library.service.validation.ValidationData;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static by.epam.library.Statics.context;

public class UserServiceImpl implements UserService {
	@Override
	public void signIn(String login, String password) throws ServiceException {
		if(!ValidationData.validUser(login, password)){
			throw new ServiceException("Incorrect user's login or password");
		}

		UserDAO userDAO = context.getBean("userDAO", UserDAO.class);

		try {
			User user = userDAO.signIn(login, Integer.valueOf(password));
			if(user == null){
				throw new ServiceException("User is not found");
			}
		} catch (DAOException e) {
			throw new ServiceException("Error sign in", e);
		}
	}

	@Override
	public void signUp(String login, String password) throws ServiceException {
		if(!ValidationData.validUser(login, password)){
			throw new ServiceException("Incorrect user's login or password");
		}

		UserDAO userDAO = context.getBean("userDAO", UserDAO.class);

		try {
			userDAO.signUp(login, Integer.valueOf(password));
		} catch (DAOException e) {
			throw new ServiceException("Error sign up", e);
		}
	}

}
