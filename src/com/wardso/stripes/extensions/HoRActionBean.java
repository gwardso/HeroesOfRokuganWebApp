package com.wardso.stripes.extensions;

import net.sourceforge.stripes.action.ActionBean;
import net.sourceforge.stripes.action.ActionBeanContext;

public class HoRActionBean implements ActionBean {
	private HoRActionBeanContext context;

	public HoRActionBeanContext getContext() {
		return context;
	}

	public void setContext(ActionBeanContext context) {
		this.context = (HoRActionBeanContext) context;
	}
}