package com.linestore.inteceptor;

import com.linestore.vo.Customer;
import com.linestore.vo.ThinkUser;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class LoginInteceptor extends MethodFilterInterceptor {

	@Override
	protected String doIntercept(ActionInvocation arg0) throws Exception {
		Customer cus = (Customer) ActionContext.getContext().getSession().get("user");
		if (cus != null) {
			return arg0.invoke();
		}
		ThinkUser thu = (ThinkUser) ActionContext.getContext().getSession().get("admin");
		if (thu != null) {
			return arg0.invoke();
		}
		return "Login";
	}

}
