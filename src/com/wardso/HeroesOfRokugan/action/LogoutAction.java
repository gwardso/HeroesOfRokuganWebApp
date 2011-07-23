package com.wardso.HeroesOfRokugan.action;

import com.wardso.stripes.extensions.HoRActionBean;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.Resolution;

public class LogoutAction extends HoRActionBean {

	@DefaultHandler
	public Resolution logout(){
		getContext().logout();
		return new HomeAction().index();
	}
}
