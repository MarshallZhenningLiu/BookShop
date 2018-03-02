package myApp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;


public enum UserDao {
  instance;

  private final static Logger LOG = Logger.getLogger(UserDao.class.getName());
  private Map<String, User> usersMap = new HashMap<String, User>();

  private UserDao() {
	  User user1 = new User();
	  user1.setUserId("user1");
	  user1.setUserSecret("secret1");
	  usersMap.put("user1", user1);
	  
	  User user2 = new User();
	  user2.setUserId("user2");
	  user2.setUserSecret("secret2");
	  usersMap.put("user2", user2);  
 }

  public List<User> getUsers() {
	LOG.info("--------getUsers line29: ");
    List<User> users = new ArrayList<User>();    
    return users;
  }

  public User getUser(String userId) {
	  LOG.info("--------getuser line35: "+ userId);
    return usersMap.get(userId);
  }

  public void create(User user) {
	  LOG.info("--------create line40: " + user.getUserId());
    usersMap.put(user.getUserId(), user);
  }

  public void delete(String userId) {
	  LOG.info("--------delete line45: " + userId);
    if (usersMap.remove(userId) != null) {
      System.out.println("Removed");
    } else {
      System.out.println("Not Removed");
    }
  }

}
