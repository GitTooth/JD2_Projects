package by.epam.library.controller.command.impl;

import by.epam.library.controller.command.Command;
import by.epam.library.service.InitializationService;
import by.epam.library.service.exception.ServiceException;

import static by.epam.library.Statics.context;

public class InitializationSource implements Command {

	@Override
	public String executeCommand(String request) {
		InitializationService initializationService = context.getBean("initializationService", InitializationService.class);
		String response = null;
		
		try {
			initializationService.initialization();
			response = "Database has been initialized";
		} catch (ServiceException e) {
			response = "Database has not been initialized";
//			LOGGER.error(e);	
		}
		
		return response;
	}

}
