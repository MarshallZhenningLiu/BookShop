package myApp;

import myApp.User;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import java.sql.*;

public enum UserDao {
  instance;

	String url = "jdbc:mysql://localhost:3306/";
	String dbName = "BookShop";
	String userName = "root";
	String password = "Change01";
	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;
	
  private final static Logger LOG = Logger.getLogger(UserDao.class.getName());
  //private Map<String, User> usersMap = new HashMap<String, User>();

  /*private UserDao() {
	  User user1 = new User();
	  user1.setUserId("user1");
	  user1.setUserSecret("secret1");
	  usersMap.put("user1", user1);
	  
	  User user2 = new User();
	  user2.setUserId("user2");
	  user2.setUserSecret("secret2");
	  usersMap.put("user2", user2);  
 }*/

  public List<User> getUsers() {
	LOG.info("--------getUsers line40: ");
    List<User> users = new ArrayList<User>();
    
    try {
    	Class.forName("com.mysql.jdbc.Driver");
    	con=DriverManager.getConnection(url+dbName, userName, password);
    	stmt = con.createStatement();
    	rs = stmt.executeQuery("select * from User");
    	while(rs.next()) {
    		User user = new User();
    		user.setUserId(rs.getString("userId"));
    		user.setUserSecret(rs.getString("userSecret"));
    		users.add(user);    		
    	}
    }catch(Exception e) {
    	e.printStackTrace();
    }finally {
    	if(rs!=null) {	try{rs.close();}catch(Exception e) {e.printStackTrace(); }}
    	if(stmt!=null) {	try{stmt.close();}catch(Exception e) {e.printStackTrace(); }}
    	if(con!=null) {	try{con.close();}catch(Exception e) {e.printStackTrace(); }}
    }
    
    return users;
  }

  public User getUser(String userId) {
	  LOG.info("--------getuser 66: "+ userId);
	  
	  try {
	    	Class.forName("com.mysql.jdbc.Driver");
	    	con=DriverManager.getConnection(url+dbName, userName, password);
	    	stmt = con.createStatement();
	    	rs = stmt.executeQuery("select * from User where userId like  \"" + userId +"\""  );
	    	while(rs.next()) {
	    		User user = new User();
	    		user.setUserId(rs.getString("userId"));
	    		user.setUserSecret(rs.getString("userSecret"));
	    		
	    		return user;
	    	}
	    }catch(Exception e) {
	    	e.printStackTrace();
	    }finally {
	    	if(rs!=null) {	try{rs.close();}catch(Exception e) {e.printStackTrace(); }}
	    	if(stmt!=null) {	try{stmt.close();}catch(Exception e) {e.printStackTrace(); }}
	    	if(con!=null) {	try{con.close();}catch(Exception e) {e.printStackTrace(); }}
	    }
	  
	  
    return null;
  }

  public void create(User user) {
	  LOG.info("--------create line92: " + user.getUserId());
	  String userId = user.getUserId();
	  String userSecret = user.getUserSecret();
	  	  
	  try {
	    	Class.forName("com.mysql.jdbc.Driver");
	    	con=DriverManager.getConnection(url+dbName, userName, password);
	    	stmt = con.createStatement();
	    	
	    	int row = stmt.executeUpdate("insert into user  values (\"" + userId + "\" ,\"" + userSecret + "\")");    	
	    	
	    }catch(Exception e) {
	    	e.printStackTrace();
	    }finally {
	    	if(rs!=null) {	try{rs.close();}catch(Exception e) {e.printStackTrace(); }}
	    	if(stmt!=null) {	try{stmt.close();}catch(Exception e) {e.printStackTrace(); }}
	    	if(con!=null) {	try{con.close();}catch(Exception e) {e.printStackTrace(); }}
	    }
	  
  }

/*  public void delete(String userId) {
	  LOG.info("--------delete line45: " + userId);
    if (usersMap.remove(userId) != null) {
      System.out.println("Removed");
    } else {
      System.out.println("Not Removed");
    }
  }*/

}
