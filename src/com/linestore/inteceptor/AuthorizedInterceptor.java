package com.linestore.inteceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.linestore.dao.RuleDao;
import com.linestore.dao.UserDao;
import com.linestore.service.UserService;
import com.linestore.vo.Rule;
import com.linestore.vo.UserModel;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * 判断用户权限的Struts2的拦截器
 */
public class AuthorizedInterceptor extends AbstractInterceptor {
	/** 定义不需要拦截的请求，主要是后端登录、登出 */
	private static final String[] IGNORE_URI = { "/user_login", "/user_logout" };
	// 注入值栈的变量
	private String msg;
	// Struts和Spring整合过程中按名称来自动注入业务层的类
	private UserDao userDao;
	private RuleDao ruleDao;

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public RuleDao getRuleDao() {
		return ruleDao;
	}

	public void setRuleDao(RuleDao ruleDao) {
		this.ruleDao = ruleDao;
	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		/** 默认用户没有登录 */
		System.out.println("进入inteceptor");
		boolean flag = false;
		String result;
		/** 获得请求的ServletPath */
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		// 拦截到的方法
		String servletPath = request.getServletPath();
		System.out.println("servletPath:" + servletPath);
		/** 判断请求是否需要拦截 */
		for (String s : IGNORE_URI) {
			if (servletPath.contains(s)) {
				System.out.println("免拦截，执行下一步。");
				flag = true;
				return invocation.invoke();
			}
		}
		/** 拦截请求 */
		if (!flag) {
			/** 1.获取session中的用户 */
			UserModel user = (UserModel) request.getSession().getAttribute("user");
			/** 2.判断用户是否已经登录 */
			if (user == null) {
				/** 如果用户没有登录，跳转到登录页面 */
				msg = "请先登录再访问网站!";
				// return "LoginFail";
				user = new UserModel();
				// 因为没有登录用户，所以在空用户里伪造用户，继续判断权限过程
				user.setId(1);
				UserModel userResult = userDao.selectUserGroup(user);
				// 判断用户权限
				// 如果用户所属组具有用户所请求的action_method，则执行下一步，否则返回
				System.out.println(userResult.getRules());
				// 因为拦截到的方法是前台方法，不是管理后端的方法，所以伪造方法为后端方法，测试权限管理
				servletPath = "admin/user/grouplist";
				// 继续获取方法在数据库中对应的权限ID
				Rule rule = new Rule();
				rule.setRules(servletPath);
				Rule ruleResult = ruleDao.select(rule);
				if (ruleResult != null) {
					Integer id = ruleResult.getId();
					System.out.println("id:"+id);
					String rules = userResult.getRules();
					String[] ruleArr = rules.split(",");
					for (int i = 0; i < ruleArr.length; i++) {
						System.out.println(ruleArr[i]);
						if (id.toString().equals(ruleArr[i])) {
							System.out.println("相通");
							return invocation.invoke();
						}
					}
					// 经过循环没有检测到对应权限，则返回
					return "GoFail";
				} else {
					// 路径不存在于权限路径
				}
			} else {
				// 判断用户权限
				// 如果用户所属组具有用户所请求的action_method，则执行下一步，否则返回
				// 将user==null中的代码剪切过来即可,user=null，直接返回登录页面
			}
		}
		return "LoginFail";
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
