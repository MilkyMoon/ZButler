package com.linestore.inteceptor;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.linestore.vo.Customer;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class LoginInteceptor extends MethodFilterInterceptor {

	@Override
	protected String doIntercept(ActionInvocation arg0) throws Exception {
		
		HttpServletRequest req = ServletActionContext.getRequest();

		Customer cus = (Customer) ActionContext.getContext().getSession().get("user");
		if (cus != null) {
			return arg0.invoke();
		}
		
		ActionContext.getContext().getSession().put("Iwant", "http://" + req.getServerName() +":" + req.getServerPort() + req.getRequestURI());
		
		return "Login";
	}

}
