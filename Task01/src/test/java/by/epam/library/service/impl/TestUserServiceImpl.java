package by.epam.library.service.impl;

import org.junit.Test;

import by.epam.library.service.UserService;
import by.epam.library.service.exception.ServiceException;

import static by.epam.library.Statics.context;

public class TestUserServiceImpl {
/*	Зарегистрировать пользователя не получиться, т.к. мы не инициализировали ConnectionPool
 	Соответственно когда берем Connection получаем NullPointerException.
*/
	@Test (expected = ServiceException.class)
	public void signUp() throws ServiceException{
		UserService userService = context.getBean("userService", UserService.class);
		userService.signUp("Dylan O'Brien", "12345678");
	}
}
