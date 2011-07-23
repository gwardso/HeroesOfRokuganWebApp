package com.wardso.persistence.entities;

import com.google.appengine.api.datastore.Key;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import java.io.Serializable;

@PersistenceCapable
public class User implements Serializable{
    @Persistent(defaultFetchGroup = "true")
	private Person person;
    @Persistent(serialized = "true")
	private com.google.appengine.api.users.User googleUser;
    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private Key key;
	
	public User(com.google.appengine.api.users.User currentUser) {
		this.googleUser = currentUser;
	}
	
	public void setGoogleUser(com.google.appengine.api.users.User googleUser) {
		this.googleUser = googleUser;
	}
	
	public com.google.appengine.api.users.User getGoogleUser() {
		return googleUser;
	}
	
	public void setPerson(Person person) {
		this.person = person;
	}
	public Person getPerson() {
		return person;
	}

    public Key getKey() {
        return key;
    }

    public void setId(Key key) {
        this.key = key;
    }
}
