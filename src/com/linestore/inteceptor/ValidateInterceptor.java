package com.linestore.inteceptor;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.linestore.service.LogService;
import com.linestore.vo.Log;
import com.linestore.vo.RuleGroup;
import com.linestore.vo.ThinkUser;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class ValidateInterceptor extends MethodFilterInterceptor {

	@Override
	protected String doIntercept(ActionInvocation arg0) throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		ServletContext application = ServletActionContext.getServletContext();
		WebApplicationContext ctx = 
				WebApplicationContextUtils.getWebApplicationContext(application);
		LogService logService = (LogService) ctx.getBean("logService");
		System.out.println("===========>" + arg0.getInvocationContext().getName());
		
		System.out.println("--------->" + request.getSession().getServletContext().getRealPath(""));
		
		Date date = new Date();
		ThinkUser thu = (ThinkUser) ActionContext.getContext().getSession().get("admin");

		if (thu != null) {

			if (thu.getGroup() != null) {
				System.out.println(thu.getGroup().getRuleGroups());
				
				 Set<RuleGroup> rgs = thu.getGroup().getRuleGroups();
				 Iterator it = rgs.iterator();
				while (it.hasNext()) {
					RuleGroup rg = (RuleGroup) it.next();
					if (rg.getRule().getRules().equals(arg0.getInvocationContext().getName())) {
						Log log = new Log();
						log.setLogAreaId(thu.getArea().getAreId());
						log.setLogAreaName(thu.getArea().getArea());
						log.setLogThuId(thu.getThuId());
						log.setLogThuName(thu.getThuName());
						log.setLogContent(rg.getRule().getTitle());
						log.setLogStatus(1);
						log.setLogDate(new Timestamp(date.getTime()));
						logService.addLog(log);
						return arg0.invoke();
					}
				}
			}
			return "Error";
		}
		return "Login";
	}

}
