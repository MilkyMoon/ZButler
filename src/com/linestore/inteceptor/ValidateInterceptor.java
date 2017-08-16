package com.linestore.inteceptor;

import java.util.Iterator;
import java.util.Set;

import com.linestore.vo.RuleGroup;
import com.linestore.vo.ThinkUser;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class ValidateInterceptor extends MethodFilterInterceptor {

	@Override
	protected String doIntercept(ActionInvocation arg0) throws Exception {
		System.out.println("===========>" + arg0.getInvocationContext().getName());
		// if
		// (!arg0.getInvocationContext().getName().equals("cateLine_selectAll"))
		// {
		//
		// Map<String, Object> map =
		// arg0.getInvocationContext().getContext().getSession();
		// HttpServletRequest request = ServletActionContext.getRequest();
		// HttpServletResponse response = ServletActionContext.getResponse();
		// String path = request.getContextPath();
		// String indexPath =
		// request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/admin/cateLine_selectAll";
		// System.out.println(indexPath);
		// response.sendRedirect(indexPath);
		// }
		ThinkUser thu = (ThinkUser) ActionContext.getContext().getSession().get("admin");

		if (thu != null) {

			if (thu.getGroup() != null) {
				System.out.println(thu.getGroup().getRuleGroups());
				
				 Set<RuleGroup> rgs = thu.getGroup().getRuleGroups();
				 Iterator it = rgs.iterator();
				while (it.hasNext()) {
					RuleGroup rg = (RuleGroup) it.next();
					if (rg.getRule().getRules().equals(arg0.getInvocationContext().getName())) {
						
						return arg0.invoke();
					}
				}
			}
			return "Error";
		}
		return "Login";
	}

	// @Override
	// public String intercept(ActionInvocation arg0) throws Exception {
	// ServletContext application = ServletActionContext.getServletContext();
	//
	// WebApplicationContext ctx =
	// WebApplicationContextUtils.getWebApplicationContext(application);
	//
	// System.out.println("=+================>" + );
	//
	// ThinkUser thu = (ThinkUser)
	// ActionContext.getContext().getSession().get("admin");
	//
	// if(thu!=null)
	// {
	// return arg0.invoke();
	// }else
	// {
	// return "Login";
	// }
	//
	// }

}
