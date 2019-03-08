package application.model;

import java.util.HashMap;

import groovy.lang.Singleton;

@Singleton
public class UserCatalog {
	
	private static HashMap<Integer, User> userCatalog = null;

	private UserCatalog() {
		// TODO Auto-generated constructor stub
	}
	
	public static HashMap<Integer, User> getInstance() {
		if (userCatalog == null) {
			userCatalog = new HashMap<Integer, User>();
		}
		return userCatalog;
	}

}
