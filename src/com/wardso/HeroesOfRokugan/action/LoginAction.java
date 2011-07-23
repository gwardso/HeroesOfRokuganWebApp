package com.wardso.HeroesOfRokugan.action;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.wardso.persistence.PMF;
import com.wardso.persistence.PersistenceManager;
import com.wardso.persistence.Query;
import com.wardso.persistence.entities.User;
import com.wardso.stripes.extensions.HoRActionBean;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.Resolution;

import java.util.List;

public class LoginAction extends HoRActionBean {
	@DefaultHandler 
	public Resolution login() throws Exception {
		com.google.appengine.api.users.User googleUser = getContext().getGoogleUser();
		if(googleUser != null){
            User user = FetchUser(googleUser);
            if(user == null){
			    getContext().setUser(new User(googleUser));
                return new RegisterAction().preRegister();
            } else if (user.getPerson() == null){
                getContext().setUser(user);
		        return new RegisterAction().preRegister();
            } else {
                getContext().setUser(user);
		        return new HomeAction().index();
            }
		} else {
            return null;
        }
	}

    private User FetchUser(com.google.appengine.api.users.User googleUser) throws Exception {
    	
        PersistenceManager<User> pm = PMF.get(User.class);
        Query<User> userQuery = pm.newQuery();
        userQuery.setFilter("key == keyParam");
        userQuery.declareParameters(Key.class.getName() + " keyParam");

        Key key = KeyFactory.createKey(User.class.getSimpleName(), googleUser.getUserId());
        
        List<User> users = userQuery.execute(key);
        int matchCount = users.size();
        if(matchCount < 1){
            return null;
        } else if (matchCount > 1){
            throw new Exception("Found multiple users with same Id");
        }

        User user = pm.getObjectById(key);
        userQuery.closeAll();
        pm.close();
        return user;
    }
}
