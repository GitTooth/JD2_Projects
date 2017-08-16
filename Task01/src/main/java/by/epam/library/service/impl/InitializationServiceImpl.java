package by.epam.library.service.impl;

import by.epam.library.dao.InitializationDAO;
import by.epam.library.dao.exception.DAOException;
import by.epam.library.service.InitializationService;
import by.epam.library.service.exception.ServiceException;

import static by.epam.library.Statics.context;

public class InitializationServiceImpl implements InitializationService {

	@Override
	public void initialization() throws ServiceException {
		InitializationDAO initializationDAO = context.getBean("initializationDAO", InitializationDAO.class);

		try {
			initializationDAO.initialization();
		} catch (DAOException e) {
			throw new ServiceException("Error initialization",e);
		}
	}

	@Override
	public void destroy() throws ServiceException {
		InitializationDAO initializationDAO = context.getBean("initializationDAO", InitializationDAO.class);
		
		try {
			initializationDAO.destroy();
		} catch (DAOException e) {
			throw new ServiceException("Error destroy",e);
		}
	}

}
