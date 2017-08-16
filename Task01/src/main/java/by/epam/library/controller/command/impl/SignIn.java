package by.epam.library.controller.command.impl;

import by.epam.library.Statics;
import by.epam.library.controller.command.Command;
import by.epam.library.service.UserService;
import by.epam.library.service.exception.ServiceException;

import static by.epam.library.Statics.context;

public class SignIn implements Command {

	@Override
	public String executeCommand(String request) {
		String [] parameter = request.split(Statics.REGEX);
		String login = parameter[Statics.LOGIN_ID];
		String password = parameter[Statics.PASSWORD_ID];

		UserService userService = context.getBean("userService", UserService.class);
		String response = null;
		
		try {
			userService.signIn(login, password);
			response = "Welcome " + login;
		} catch (ServiceException e) { 
			response = "Sign in error";
			//logger.log(Level.ERROR, e);
		}
		
		return response;
	}

}
