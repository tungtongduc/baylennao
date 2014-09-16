package de.txa.usermanagerservice.service;

import org.springframework.jdbc.datasource.DriverManagerDataSource;



public class UserServiceFactory {

	private static final String DATASOURCE_DRIVER_CLASS = "com.mysql.jdbc.Driver";
	private static final String DATASOURCE_URL = "jdbc:mysql://127.0.0.1:3306/test";
	private static final String DATASOURCE_USERNAME = "root";
	private static final String DATASOURCE_PASSWORD = "";
	private final DriverManagerDataSource dataSource = new DriverManagerDataSource();
	
	private UserServiceFactory() {
		setDataSource();
	}
	
	public static UserServiceFactory getInstance() {
		return new UserServiceFactory();
	}
	
	public UserService getUserService() {
		final UserService userService = new UserService();
		userService.setDataSource(dataSource);
		return userService;
	}
	
	private void setDataSource() {
		dataSource.setDriverClassName(DATASOURCE_DRIVER_CLASS);
        dataSource.setUrl(DATASOURCE_URL);
        dataSource.setUsername(DATASOURCE_USERNAME);
        dataSource.setPassword(DATASOURCE_PASSWORD);
	}
}
