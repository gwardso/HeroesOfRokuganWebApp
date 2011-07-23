package com.wardso.HeroesOfRokugan.action;

import com.wardso.stripes.extensions.HoRActionBean;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.validation.Validate;
import net.sourceforge.stripes.validation.ValidateNestedProperties;

/**
 * Created by IntelliJ IDEA.
 * User: wardso
 * Date: 3/29/11
 * Time: 6:55 PM
 * To change this template use File | Settings | File Templates.
 */
public class HomeAction extends HoRActionBean {
  @ValidateNestedProperties({
    @Validate(field = "firstName", required = true,
              on = {"hello"}),
    @Validate(field = "lastName", required = true,
              on = {"hello"})
  })

  @DefaultHandler 
  public Resolution index() {
    return new ForwardResolution("/WEB-INF/jsp/index.jsp");
  }
}
