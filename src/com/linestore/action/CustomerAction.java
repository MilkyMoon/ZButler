package com.linestore.action;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import com.linestore.service.CatetoryService;

//import org.eclipse.jdt.internal.compiler.batch.Main;

import com.linestore.service.CusAccountService;
import com.linestore.service.CustomerService;
import com.linestore.service.FriendsService;
import com.linestore.util.SendMessage;
import com.linestore.vo.CusAccount;
import com.linestore.vo.Customer;
import com.linestore.vo.Friends;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.thoughtworks.xstream.mapper.Mapper.Null;

import net.sf.json.JSONObject;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {

	private Customer customer = new Customer();
	
	private Customer customerResult;

	private String valid;
	
	private String ReType;

	private Map<String, Object> request;

	private String result;

	private String field;

	private CustomerService customerService;
	
	private FriendsService friendsService;
	
	private CusAccountService cusAccountService;
	
	private CatetoryService catetoryService;
	
	private void init(Customer cus) {
		CusAccount cusAccount = new CusAccount();
		cusAccount.setCacPoints((float) 0);
		cusAccount.setCacChange((float) 0);
		cusAccount.setCacBonus((float) 0);
		cusAccount.setCustomer(cus);
		cusAccountService.addCusAccount(cusAccount);
		customerService.select(cus);
	}

	private String sendCode(String phone) {
		int min = 1000;
		int max = 9999;
		Random random = new Random();
		int code = random.nextInt(max) % (max - min + 1) + min;
		System.out.println(code);
		SendMessage.send(String.valueOf(code), phone);
		return String.valueOf(code);
	}

	public String sendMessage() {
		Map<String, Object> map = new HashMap<String, Object>();
		if (customerService.findByPhone(customer.getCusPhone()).size() >= 1) {
			map.put("isError", "true");
			map.put("ErrorMessage", "手机号已注册！");
			this.result = JSONObject.fromObject(map).toString();
			return SUCCESS;
		}
		// int min = 1000;
		// int max = 9999;
		// Random random = new Random();
		// int code = random.nextInt(max)%(max-min+1) + min;
		// System.out.println(code);
		// SendMessage.send(String.valueOf(code), customer.getCusPhone());
		String code = sendCode(customer.getCusPhone());
		map.put("isError", "false");
		map.put("code", code);
		this.result = JSONObject.fromObject(map).toString();
		return SUCCESS;
	}

	public String register() {
		
		customer.setCusNickname("ZB_" + customer.getCusPhone());
		customer.setCusImgUrl("home/dist/wx_image/111.jpg");
		customer.setCusStatus(1);
		
		if (ReType != null) {
			customer.setCusPassword("123456");
			customerService.addCustomer(customer);
			init(customer);
			Friends friends = new Friends();
			Customer cus = (Customer) ActionContext.getContext().getSession().get("user");
			friends.setCustomer(cus);
			friends.setFriDate(new Timestamp(new Date().getTime()));
			friends.setFriPhone(customer.getCusPhone());
			friends.setFriType(Integer.valueOf(ReType));
			friendsService.save(friends);
			request = (Map<String, Object>) ActionContext.getContext().get("request");
			String js = "<script>YDUI.dialog.alert('注册成功！');</script>";
			request.put("js", js);
			return "askRegister";
		}
		
		if (customer.getCusPassword() != null && customer.getCusPhone() != null) {
			
			customerService.addCustomer(customer);
			init(customer);
			
			customer = customerService.findByPhone(customer.getCusPhone()).get(0);
			// System.out.println(customerService.findByPhone(customer.getCusPhone()).get(0));
			ActionContext.getContext().getSession().put("cac", cusAccountService.findByCusId(customer.getCusId()));
			ActionContext.getContext().getSession().put("user", customer);
		}
		return "gotoCustomer";
	}

	public String login() {
		if (customerService.checkCustomer(customer)) {
			Customer cus = customerService.findByPhone(customer.getCusPhone()).get(0);
			ActionContext.getContext().getSession().put("user", cus);
			ActionContext.getContext().getSession().put("cac", cusAccountService.findByCusId(cus.getCusId()));
			return "gotoCustomer";
		}
		request = (Map<String, Object>) ActionContext.getContext().get("request");
		String js = "<script>YDUI.dialog.alert('用户名或密码错误！');</script>";
		request.put("js", js);
		return "gotoLogin";
	}

	public String update() {
		String value = null;
		if ("cusNickname".equals(field)) {
			value = customer.getCusNickname();
		} else if ("cusHobby".equals(field)) {
			value = customer.getCusHobby();
		} else if ("cusSex".equals(field)) {
			value = String.valueOf(customer.getCusSex());
		} else if ("cusBirth".equals(field)) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			value = sdf.format(customer.getCusBirth());
		} else if ("cusPhone".equals(field)) {
			value = customer.getCusPhone();
		} else if ("cusPassword".equals(field)) {
			value = customer.getCusPassword();
		} else if ("cusPayPassword".equals(field)) {
			value = customer.getCusPayPassword();
		} else if ("cusTagId".equals(field)) {
			value = customer.getCusTagId();
			System.out.println("-----------------------");
		}
		customer = (Customer) ActionContext.getContext().getSession().get("user");
		customerService.updateField(field, value, customer.getCusId());
		ActionContext.getContext().getSession().put("user", customerService.findById(customer.getCusId()));
		return "gotoCusMessage";
	}

	public String forgetPass() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("isError", "false");
		String code = sendCode(customer.getCusPhone());
		map.put("code", code);
		this.result = JSONObject.fromObject(map).toString();
		return SUCCESS;
	}

	public String BindPhone() {
		Map<String, Object> map = new HashMap<String, Object>();
		if (customerService.findByPhone(customer.getCusPhone()).size() >= 1) {
			map.put("isError", "true");
			map.put("ErrorMessage", "手机号已绑定！");
			this.result = JSONObject.fromObject(map).toString();
			return SUCCESS;
		}
		String code = sendCode(customer.getCusPhone());
		map.put("isError", "false");
		map.put("code", code);
		this.result = JSONObject.fromObject(map).toString();
		return SUCCESS;
	}
	

	public String logout() {
		ActionContext.getContext().getSession().put("user", null);
		return "logout";
	}
	
	
	// 邀请注册用户
		public String askRegister() {
			System.out.println("Action中的askRegister方法！");
			// 邀请人的cusId
//			customer.getCusId();
//			Customer customer = (Customer) ActionContext.getContext().getSession().get("user");
//			//补全邀请人的信息，传递到页面;注册者完成注册时还需要用到邀请人的信息
//			customer=customerService.select(customer);

			return "askRegister";
		}

		// 获取当前用户的资料
		public String myQRCode() {
			System.out.println("Action中的myQRCode方法！");
			// 通过action上下文获取session
			// 直接将session中存的用户信息通过数据库获取完整，返回页面
			// 由于登录功能尚未完成，因此先写固定值cusId=1
			// HttpSession session = ServletActionContext.getRequest().getSession();
			// Customer customerResult = (Customer)
			// session.getAttribute("customer");
//			customer.setCusId(1);
//			Customer customer = (Customer) ActionContext.getContext().getSession().get("user");
//			customerResult = customerService.select(customer);
//			System.out.println(customerResult);
			return "myQRCode";
		}
	
	
	

	public String toForgetTwo() {
		return "gotoForgetTwo";
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getValid() {
		return valid;
	}

	public void setValid(String valid) {
		this.valid = valid;
	}

	@Override
	public Customer getModel() {
		return customer;
	}

	public CustomerService getCustomerService() {
		return customerService;
	}

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	public CusAccountService getCusAccountService() {
		return cusAccountService;
	}

	public void setCusAccountService(CusAccountService cusAccountService) {
		this.cusAccountService = cusAccountService;
	}

	public Customer getCustomerResult() {
		return customerResult;
	}

	public FriendsService getFriendsService() {
		return friendsService;
	}

	public void setFriendsService(FriendsService friendsService) {
		this.friendsService = friendsService;
	}

	public void setCustomerResult(Customer customerResult) {
		this.customerResult = customerResult;
	}

	public String getReType() {
		return ReType;
	}

	public void setReType(String reType) {
		ReType = reType;
	}

	public CatetoryService getCatetoryService() {
		return catetoryService;
	}

	public void setCatetoryService(CatetoryService catetoryService) {
		this.catetoryService = catetoryService;
	}
	
	
}
