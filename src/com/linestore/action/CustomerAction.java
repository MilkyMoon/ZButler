package com.linestore.action;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.eclipse.jdt.internal.compiler.batch.Main;

import com.linestore.service.CustomerService;
import com.linestore.util.SendMessage;
import com.linestore.vo.CusAccount;
import com.linestore.vo.Customer;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import net.sf.json.JSONObject;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {

	private Customer customer = new Customer();

	private String valid;

	private Map<String, Object> request;

	private String result;

	private String field;

	private CustomerService customerService;

	private String sendCode(String phone) {
		int min = 1000;
		int max = 9999;
		Random random = new Random();
		int code = random.nextInt(max) % (max - min + 1) + min;
		System.out.println(code);
		// SendMessage.send(String.valueOf(code), phone);
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
		if (customer.getCusPassword() != null && customer.getCusPhone() != null) {
			customer.setCusNickname("ZB_" + customer.getCusPhone());
			customer.setCusStatus(1);
			CusAccount cusAccount = new CusAccount();
			cusAccount.setCacPoints((float) 0);
			cusAccount.setCacChange((float) 0);
			
			Set<CusAccount> set = new HashSet(0);
			set.add(cusAccount);
			customer.setCusAccounts(set);
			customerService.addCustomer(customer);
			// System.out.println(customerService.findByPhone(customer.getCusPhone()).get(0));
			ActionContext.getContext().getSession().put("user", customer);
		}
		return "gotoCustomer";
	}

	public String login() {
		if (customerService.checkCustomer(customer)) {
			ActionContext.getContext().getSession().put("user",
					customerService.findByPhone(customer.getCusPhone()).get(0));
			return "gotoCustomer";
		}
		request = (Map<String, Object>) ActionContext.getContext().get("request");
		String js = "YDUI.dialog.alert('用户名或密码错误！');";
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
		map.put("code", sendCode(customer.getCusPhone()));
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
}
