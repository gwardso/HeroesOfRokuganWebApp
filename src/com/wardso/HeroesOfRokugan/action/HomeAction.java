package com.wardso.HeroesOfRokugan.action;

import com.wardso.HeroesOfRokugan.model.Person;
import net.sourceforge.stripes.action.*;
import net.sourceforge.stripes.validation.Validate;
import net.sourceforge.stripes.validation.ValidateNestedProperties;

/**
 * Created by IntelliJ IDEA.
 * User: wardso
 * Date: 3/29/11
 * Time: 6:55 PM
 * To change this template use File | Settings | File Templates.
 */
public class HomeAction implements ActionBean {
  @ValidateNestedProperties({
    @Validate(field = "firstName", required = true,
              on = {"hello"}),
    @Validate(field = "lastName", required = true,
              on = {"hello"})
  })
  private Person person;
  private ActionBeanContext context;

  @DefaultHandler 
  public Resolution index() {
    return new ForwardResolution("index.jsp");
  }

  public Resolution hello() {
    return new ForwardResolution("Echo.jsp");
  }

  public void setPerson(Person person) {this.person = person;}
  public Person getPerson() { return person;}
  public void setContext(ActionBeanContext c) {this.context = c; }
  public ActionBeanContext getContext() {return context; }
}
