package com.wardso.HeroesOfRokugan.action;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.wardso.persistence.PMF;
import com.wardso.persistence.PersistenceManager;
import com.wardso.persistence.entities.Person;
import com.wardso.persistence.entities.User;
import com.wardso.stripes.extensions.HoRActionBean;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.validation.Validate;
import net.sourceforge.stripes.validation.ValidateNestedProperties;

public class RegisterAction extends HoRActionBean{
    @ValidateNestedProperties({
        @Validate(field = "firstName", required = true, on = {"register"}),
        @Validate(field = "lastName", required = true, on = {"register"})
    })

    private Person person;

    public Resolution preRegister(){
        return new ForwardResolution("/WEB-INF/jsp/registerNew.jsp");
    }

    public Resolution register(){
    	
        PersistenceManager<User> pm = PMF.get(User.class);
        User user = getContext().getUser();
        Key key = KeyFactory.createKey(User.class.getSimpleName(), user.getGoogleUser().getUserId());
        user.setId(key);
        user.setPerson(getPerson());
        pm.makePersistent(user);
        return new ForwardResolution("/WEB-INF/jsp/Echo.jsp");
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
