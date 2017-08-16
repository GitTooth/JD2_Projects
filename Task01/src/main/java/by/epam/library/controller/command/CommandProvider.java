package by.epam.library.controller.command;

import java.util.HashMap;
import java.util.Map;

import by.epam.library.controller.command.impl.AddEditBook;
import by.epam.library.controller.command.impl.AddNewBook;
import by.epam.library.controller.command.impl.DestroySource;
import by.epam.library.controller.command.impl.GetBookList;
import by.epam.library.controller.command.impl.SignIn;
import by.epam.library.controller.command.impl.SignUp;
import by.epam.library.controller.command.impl.InitializationSource;
import by.epam.library.controller.command.impl.WrongRequest;

public final class CommandProvider {
	private static final Map<CommandName, Command> repository = new HashMap<>();
	
	public CommandProvider() {
		repository.put(CommandName.INITIALIZATION_SOURCE, new InitializationSource());
		repository.put(CommandName.DESTROY_SOURCE, new DestroySource());
		repository.put(CommandName.ADD_NEW_BOOK, new AddNewBook());
		repository.put(CommandName.SIGN_IN, new SignIn());
		repository.put(CommandName.SIGN_UP, new SignUp());
		repository.put(CommandName.ADD_EDIT_BOOK, new AddEditBook());
		repository.put(CommandName.GET_BOOKLIST, new GetBookList());
		repository.put(CommandName.WRONG_REQUEST, new WrongRequest());
	}

	public Command getCommand(String key){
		Command command;
		CommandName commandName;
		
		try{
			commandName = CommandName.valueOf(key.toUpperCase());
			command = repository.get(commandName);			
		}catch (IllegalArgumentException | NullPointerException e) {
		    
			//LOGGER.error(e);
			command = repository.get(CommandName.WRONG_REQUEST);
		}
		
		return command;
	}
	
}
