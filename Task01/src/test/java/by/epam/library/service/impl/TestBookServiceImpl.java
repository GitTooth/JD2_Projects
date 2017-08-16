package by.epam.library.service.impl;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import by.epam.library.dao.connection.ConnectionPool;
import by.epam.library.dao.exception.ConnectionPoolException;
import by.epam.library.service.BookService;
import by.epam.library.service.exception.ServiceException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static by.epam.library.Statics.context;

public class TestBookServiceImpl {
	private final BookService bookService = context.getBean("bookService", BookServiceImpl.class);
	
	@BeforeClass
	public static void initSource() throws ConnectionPoolException{
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		ConnectionPool connectionPool  = context.getBean("connectionPool", ConnectionPool.class);
		connectionPool.init();
	}

	@AfterClass
	public static void destroySource() throws ConnectionPoolException, IOException{
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		ConnectionPool connectionPool  = context.getBean("connectionPool", ConnectionPool.class);
		connectionPool.close();
	}
	
	
	@Test  (expected = ServiceException.class)
	public void testAddNewBook() throws ServiceException{ 
		bookService.addNewBook(null, null, null, null, null);
	}

	@Test
	public void testAddEditBook(){
		try {
			bookService.addEditBook(null, "MyAuthor", "MyGenre", "2017", "10", "1");
		} catch (ServiceException e) {
			Assert.assertEquals("Incorrect data about book", e.getMessage());
		}
	}
	
}
