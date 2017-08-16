package by.epam.library.controller.command.impl;

import by.epam.library.Statics;
import by.epam.library.controller.command.Command;
import by.epam.library.service.BookService;
import by.epam.library.service.exception.ServiceException;
import by.epam.library.service.impl.BookServiceImpl;

import static by.epam.library.Statics.context;

public class AddNewBook implements Command {

	@Override
	public String executeCommand(String request) {
		String [] parameter = request.split(Statics.REGEX);
		String title = parameter[Statics.TITLE_ID];
		String author = parameter[Statics.AUTHOR_ID];
		String genre = parameter[Statics.GENRE_ID];
		String year = parameter[Statics.YEAR_ID];
		String quantity = parameter[Statics.QUANTITY_ID];

		BookService bookService = context.getBean("bookService", BookServiceImpl.class);
		String response = null;
		
		try {
			bookService.addNewBook(title, genre, author, year, quantity);
			response = "Book successfully added";
		} catch (ServiceException e) {
			response = "Error adding book";
			//logger.log(Level.ERROR, e);
		}
		
		return response;
	}

}
