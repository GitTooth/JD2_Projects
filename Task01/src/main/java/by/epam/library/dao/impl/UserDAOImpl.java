package by.epam.library.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import by.epam.library.Statics;
import by.epam.library.bean.User;
import by.epam.library.dao.ColumnLabel;
import by.epam.library.dao.SQLCommand;
import by.epam.library.dao.UserDAO;
import by.epam.library.dao.connection.ConnectionPool;
import by.epam.library.dao.exception.ConnectionPoolException;
import by.epam.library.dao.exception.DAOException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserDAOImpl implements UserDAO {

	@Override
	public User signIn(String login, int password) throws DAOException {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		ConnectionPool pool  = context.getBean("connectionPool", ConnectionPool.class);
		PreparedStatement preparedStatement = null;
		Connection connection = null;
		ResultSet resultSet = null;
		User user = null;
		
		try {
			connection = pool.take();
			preparedStatement = connection.prepareStatement(SQLCommand.SELECT_USER_BY_LOGIN_PASSWORD);
			preparedStatement.setString(Statics.LOGIN_ID, login);
			preparedStatement.setInt(Statics.PASSWORD_ID, password);
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				user = new User();
				user.setId(resultSet.getInt(ColumnLabel.USER_ID));
				user.setLogin(resultSet.getString(ColumnLabel.USER_LOGIN));
				user.setPassword(resultSet.getInt(ColumnLabel.USER_PASSWORD));
			}
		} catch (ConnectionPoolException e) {
			throw new DAOException("There was a problem connecting to the database", e);
		} catch (SQLException e) {
			throw new DAOException("Error executing the query 'select_user_id_by_login_password'", e);
		}finally {
			pool.closeConnection(connection, preparedStatement, resultSet);
		}
		
		return user;
	
	}

	@Override
	public void signUp(String login, int password) throws DAOException {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		ConnectionPool pool  = context.getBean("connectionPool", ConnectionPool.class);
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = pool.take();
			preparedStatement = connection.prepareStatement(SQLCommand.INSERT_USER);
			preparedStatement.setString(Statics.LOGIN_ID, login);
			preparedStatement.setInt(Statics.PASSWORD_ID, password);
			preparedStatement.executeUpdate();
		} catch (ConnectionPoolException e) {
			throw new DAOException("There was a problem connecting to the database", e);
		} catch (SQLException e) {
			throw new DAOException("Error executing the query 'insert_user'", e);
		}finally {
			pool.closeConnection(connection, preparedStatement);
		}
	}

}
