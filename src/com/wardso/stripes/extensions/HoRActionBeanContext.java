package com.wardso.stripes.extensions;


import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import com.wardso.persistence.PMF;
import com.wardso.persistence.PersistenceManager;
import com.wardso.persistence.entities.User;
import net.sourceforge.stripes.action.ActionBeanContext;

public class HoRActionBeanContext extends ActionBeanContext {
	
	private UserService userService;
	
	public HoRActionBeanContext(){
    	this.userService = UserServiceFactory.getUserService();
	}
	
	public User getUser(){
		User user = (User) getRequest().getSession().getAttribute("user");
		if (user == null){
			com.google.appengine.api.users.User googleUser = getGoogleUser();
			PersistenceManager<User> pm = PMF.get(User.class);
			user = pm.getObjectById(googleUser.getUserId());
			pm.close();
		}
		return user;
	}
	
	public void setUser(User user){
		getRequest().getSession().setAttribute("user", user);
	}
	
	public com.google.appengine.api.users.User getGoogleUser(){
		return this.userService.getCurrentUser();
	}
	
	public String getLoginURL(){
		return userService.createLoginURL("/Login.action");
	}
	
	public String getLogoutURL(){
		return userService.createLogoutURL("/Logout.action");
	}

	public void logout() {
		getRequest().getSession().invalidate();
	}
}