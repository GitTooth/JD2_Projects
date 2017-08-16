package by.epam.library.dao.connection;

import java.io.Closeable;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import by.epam.library.Statics;
import by.epam.library.dao.connection.manager.DBParameter;
import by.epam.library.dao.exception.ConnectionPoolException;
import by.epam.library.dao.exception.DAOException;

public final class ConnectionPool implements Closeable{
	private static BlockingQueue<Connection> freeConnection;
	private static BlockingQueue<Connection> busyConnection;

	private int poolsize;
	private String driver;
	private String user;
	private String password;
	private String url;
 	
	private ConnectionPool() {
		ResourceBundle resourceManager = Statics.bundle;
		this.driver = resourceManager.getString(DBParameter.DB_DRIVER);
		this.user = resourceManager.getString(DBParameter.DB_USER);
		this.password = resourceManager.getString(DBParameter.DB_PASSWORD);
		this.url = resourceManager.getString(DBParameter.DB_URL);
		
		try{
			this.poolsize = Integer.parseInt(resourceManager.getString(DBParameter.DB_POOLSIZE));
		}catch (NumberFormatException e) {
			this.poolsize = 6;
		}	
	}

	public void init() throws ConnectionPoolException{
		freeConnection = new ArrayBlockingQueue<Connection>(poolsize);
		busyConnection = new ArrayBlockingQueue<Connection>(poolsize);
		
		try{
			Class.forName(driver);
			for(int i = 0; i < poolsize; i++){
				freeConnection.add(DriverManager.getConnection(url, user, password));
			}
		}catch (ClassNotFoundException e) {
			throw new ConnectionPoolException("Can't find database driver class", e);
		} catch (SQLException e) {
			throw new ConnectionPoolException("SQLException in ConnectionPool", e);
		}
		
	}
	
	public Connection take() throws ConnectionPoolException{
		Connection connection = null;
		try {
			connection = freeConnection.take();
			busyConnection.put(connection);
		} catch (InterruptedException e) {
			throw new ConnectionPoolException("Error connecting to the data source", e);
		}
		return connection;
	}
	
	public void free(Connection connection) throws InterruptedException, DAOException{
		if(connection == null){
			throw new DAOException("Connection is null");
		}
		
		Connection tempConnection = connection;
		connection = null;
		busyConnection.remove(tempConnection);
		freeConnection.put(tempConnection);
	}
	
	//public static ConnectionPool getInstance(){
	//	return instance;
	//}
	
	@Override
	public void close() throws IOException {
		List<Connection> listConnection = new ArrayList<Connection>();
		listConnection.addAll(this.busyConnection);
		listConnection.addAll(this.freeConnection);
		
		for(Connection connection: listConnection){
			try {
				if(connection != null){
					connection.close();
				}
			} catch (SQLException e) {
//				LOGGER.error(e);
			}
		}
	}

	public void closeConnection(Connection con, Statement st, PreparedStatement preSt, ResultSet rs){
		if(con != null){
			try {
				free(con);
			} catch (InterruptedException | DAOException e) {
//				LOGGER.log(Level.ERROR, "Connection isn't return to the pool", e);
			}
		}
		
		if(st != null){
			try {
				st.close();
			} catch (SQLException e) {
//				LOGGER.log(Level.ERROR, "Statement isn't closed", e);
			}
		}
		
		if(preSt != null){
			try {
				preSt.close();
			} catch (SQLException e) {
//				LOGGER.log(Level.ERROR, "PrepareStatement ins't closed", e);
			}
		}
		
		if(rs != null){
			try {
				rs.close();
			} catch (SQLException e) {
//				LOGGER.log(Level.ERROR, "ResultSet ins't closed", e);
			}
		}
	}

	public void closeConnection(Connection con, Statement st){
		if(con != null){
			try {
				free(con);
			} catch (InterruptedException | DAOException e) {
//				LOGGER.log(Level.ERROR, "Connection isn't return to the pool", e);
			}
		}
		
		if(st != null){
			try {
				st.close();
			} catch (SQLException e) {
//				LOGGER.log(Level.ERROR, "Statement isn't closed", e);
			}
		}
	}

	public void closeConnection(Connection con, PreparedStatement preSt){
		if(con != null){
			try {
				free(con);
			} catch (InterruptedException | DAOException e) {
//				LOGGER.log(Level.ERROR, "Connection isn't return to the pool", e);
			}
		}
		
		if(preSt != null){
			try {
				preSt.close();
			} catch (SQLException e) {
//				LOGGER.log(Level.ERROR, "PrepareStatement ins't closed", e);
			}
		}
	}
	
	public void closeConnection(Connection con, ResultSet rs){
		if(con != null){
			try {
				free(con);
			} catch (InterruptedException | DAOException e) {
//				LOGGER.log(Level.ERROR, "Connection isn't return to the pool", e);
			}
		}
		
		if(rs != null){
			try {
				rs.close();
			} catch (SQLException e) {
//				LOGGER.log(Level.ERROR, "ResultSet ins't closed", e);
			}
		}
	}
	
	public void closeConnection(Connection con, Statement st, PreparedStatement preSt){
		if(con != null){
			try {
				free(con);
			} catch (InterruptedException | DAOException e) {
//				LOGGER.log(Level.ERROR, "Connection isn't return to the pool", e);
			}
		}
		
		if(st != null){
			try {
				st.close();
			} catch (SQLException e) {
//				LOGGER.log(Level.ERROR, "Statement isn't closed", e);
			}
		}
		
		if(preSt != null){
			try {
				preSt.close();
			} catch (SQLException e) {
//				LOGGER.log(Level.ERROR, "PrepareStatement ins't closed", e);
			}
		}
		
	}

	public void closeConnection(Connection con, PreparedStatement preSt, ResultSet rs){
		if(con != null){
			try {
				free(con);
			} catch (InterruptedException | DAOException e) {
//				LOGGER.log(Level.ERROR, "Connection isn't return to the pool", e);
			}
		}
		
		if(preSt != null){
			try {
				preSt.close();
			} catch (SQLException e) {
//				LOGGER.log(Level.ERROR, "PrepareStatement ins't closed", e);
			}
		}
		
		if(rs != null){
			try {
				rs.close();
			} catch (SQLException e) {
//				LOGGER.log(Level.ERROR, "ResultSet ins't closed", e);
			}
		}
	}

	public void closeConnection(Connection con, Statement st, ResultSet rs){
		if(con != null){
			try {
				free(con);
			} catch (InterruptedException | DAOException e) {
//				LOGGER.log(Level.ERROR, "Connection isn't return to the pool", e);
			}
		}
		
		if(st != null){
			try {
				st.close();
			} catch (SQLException e) {
//				LOGGER.log(Level.ERROR, "Statement isn't closed", e);
			}
		}
		
		if(rs != null){
			try {
				rs.close();
			} catch (SQLException e) {
//				LOGGER.log(Level.ERROR, "ResultSet ins't closed", e);
			}
		}
	}
	
}
