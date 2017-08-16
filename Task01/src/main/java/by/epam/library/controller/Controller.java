package by.epam.library.controller;

import by.epam.library.Statics;
import by.epam.library.controller.command.CommandProvider;
import by.epam.library.controller.command.Command;

import static by.epam.library.Statics.context;

public final class Controller {

	public String executeAction(String request){
		String commandName;
		Command command;
		
		commandName = request.substring(0, request.indexOf(Statics.REGEX));
		CommandProvider provider = context.getBean("commandProvider", CommandProvider.class);
		command = provider.getCommand(commandName);
		String response = command.executeCommand(request);
		
		return response;
	}
}
