package com.linestore.action;

import com.linestore.service.UserService;
import com.linestore.vo.UserModel;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction extends ActionSupport implements ModelDriven<UserModel>{
	//模型驱动使用的类
	private UserModel user = new UserModel();
	
	@Override
	public UserModel getModel() {
		// TODO Auto-generated method stub
		return user;
	}
	
	//Struts和Spring整合过程中按名称来自动注入业务层的类
	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String save(){
		System.out.println("Action中的save方法！");
		userService.save(user);

		return SUCCESS;
	}
	
	public String login(){
		//调用业务层的类
		UserModel objUser = userService.login(user);
		
		if (objUser == null){
			//登录失败
			this.addActionError("用户名或密码错误！");
			return ERROR;
		}else{
			//登录成功
			ActionContext.getContext().getSession().put("user", objUser);
			return SUCCESS;
		}
	}
	
	
}