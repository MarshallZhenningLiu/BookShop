package myApp;

import java.util.logging.Logger;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;



@XmlRootElement(name = "User")
// Optional
@XmlType(propOrder = { "userId","userSecret"})
public class User {
  
	private final static Logger LOG = Logger.getLogger(User.class.getName());
  
	private String userId;
    private String userSecret;
         
	public String getUserId() {
		LOG.info("------------getUserId line 19 : " + userId);
		return userId;
	}
	public void setUserId(String userId) {
		LOG.info("------------setUserId line 23 : " + userId);
		this.userId = userId;
	}
	public String getUserSecret() {
		return userSecret;
	}
	public void setUserSecret(String userSecret) {
		this.userSecret = userSecret;
	}
 
}
