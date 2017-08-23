package com.linestore.action;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.linestore.service.BusinessService;
import com.linestore.service.CatetoryService;
import com.linestore.service.CtaTradingService;

//import org.eclipse.jdt.internal.compiler.batch.Main;

import com.linestore.service.CusAccountService;
import com.linestore.service.CustomerService;
import com.linestore.service.FriendsService;
import com.linestore.service.SettingService;
import com.linestore.service.SiteConfigService;
import com.linestore.util.SendMessage;
import com.linestore.vo.Business;
import com.linestore.vo.CtaTrading;
import com.linestore.vo.CusAccount;
import com.linestore.vo.Customer;
import com.linestore.vo.Friends;
import com.linestore.vo.SiteConfig;
import com.linestore.vo.Template;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import net.sf.json.JSONObject;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {

	private Customer customer = new Customer();

	private Customer customerResult;

	private String valid;

	private String ReType;

	private Map<String, Object> request;

	private String result;

	private String field;

	public SiteConfigService getSiteConfigService() {
		return siteConfigService;
	}

	public void setSiteConfigService(SiteConfigService siteConfigService) {
		this.siteConfigService = siteConfigService;
	}

	private CustomerService customerService;

	private FriendsService friendsService;

	private CusAccountService cusAccountService;

	private CatetoryService catetoryService;

	private SettingService settingService;

	private BusinessService businessService;

	private CtaTradingService ctaTradingService;

	private SiteConfigService siteConfigService;

	public String protocol() {
		request = (Map<String, Object>) ActionContext.getContext().get("request");
		SiteConfig siteConfig = siteConfigService.selectById(4);
		request.put("sc", siteConfig);
		return "gotoProtocol";
	}

	public String weChat() throws IOException {
		Customer cus = (Customer) ActionContext.getContext().getSession().get("weChat");
//		System.out.println(cus.getCusOpenId());
//		System.out.println(customerService.findByOpenId(cus.getCusOpenId()).size());
		SiteConfig siteConfig = siteConfigService.selectById(30);
		ActionContext.getContext().getSession().put("lq", siteConfig);
		if (customerService.findByOpenId(cus.getCusOpenId()).size() < 1) {
			cus.setCusPassword("111");
			cus.setCusStatus(1);
			customerService.addCustomer(cus);
			cus = customerService.findByOpenId(cus.getCusOpenId()).get(0);
			init(cus);
		} else {
			System.out.println("--------------");
			cus = customerService.findByOpenId(cus.getCusOpenId()).get(0);
		}
		ActionContext.getContext().getSession().put("cac", cusAccountService.findByCusId(cus.getCusId()));
		ActionContext.getContext().getSession().put("user", cus);
		String Iwant = (String) ActionContext.getContext().getSession().get("Iwant");
		if (Iwant != null) {
			HttpServletResponse response = ServletActionContext.getResponse();
			ActionContext.getContext().getSession().put("Iwant", null);
			response.sendRedirect(Iwant);
		}
		return "gotoCustomer";
	}

	private void init(Customer cus) {
		CusAccount cusAccount = new CusAccount();
		cusAccount.setCacPoints((float) 0);
		cusAccount.setCacChange((float) 0);
		cusAccount.setCacBonus((float) 0);
		cusAccount.setCustomer(cus);
		cusAccountService.addCusAccount(cusAccount);
		customerService.select(cus);
	}

	private String sendCode(String phone) throws ServerException, ClientException {
		int min = 1000;
		int max = 9999;
		Random random = new Random();
		int code = random.nextInt(max) % (max - min + 1) + min;
		System.out.println(code);
		SendMessage.send(String.valueOf(code), phone);
		return String.valueOf(code);
	}

	public String sendMessage() throws ServerException, ClientException {
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
		customer.setCusPassword("111");
		if (ReType != null) {
			customerService.addCustomer(customer);
			init(customer);
			Friends friends = new Friends();
			Customer cus = customerService.findByPhone(valid).get(0);
			friends.setCustomer(cus);
			friends.setFriDate(new Timestamp(new Date().getTime()));
			friends.setFriPhone(customer.getCusPhone());
			List<Business> bus = businessService.queryByCusId(cus.getCusId());
			System.out.println("bus: " + bus);
			if (bus == null || bus.size() < 1) {
				friends.setFriType(Integer.valueOf(1));
			} else {
				if (bus.get(0).getBusLevel() == 0) {
					friends.setFriType(Integer.valueOf(2));
				} else if (bus.get(0).getBusLevel() == 2) {
					friends.setFriType(Integer.valueOf(3));
				}
				if (bus.get(0).getBusLevel() == 0 || bus.get(0).getBusLevel() == 2) {
					CusAccount cac = cusAccountService.findByCusId(cus.getCusId());
					System.out.println(cus.getCusId());
					if (cac != null) {
						System.out.println("111111111111111");
						Date date = new Date();
						CtaTrading cta = new CtaTrading();
						cta.setCtaMoney(Float.valueOf(settingService.queryById(7).getSetValue()));
						cta.setCtaTime(new Timestamp(date.getTime()));
						cta.setCtaType(3);
						cta.setCustomer(cus);
						cta.setCtaId(date.getTime() + "Y" + RandomStr());
						ctaTradingService.addCtaTrading(cta);
						cac.setCacChange(cac.getCacChange() + Float.valueOf(settingService.queryById(7).getSetValue()));
						cusAccountService.updateCusAccount(cac);
					}
				}
			}
			friendsService.save(friends);
			ActionContext.getContext().getSession().put("cac", cusAccountService.findByCusId(cus.getCusId()));
			request = (Map<String, Object>) ActionContext.getContext().get("request");
			String js = "<script>YDUI.dialog.alert('注册成功！');</script>";
			request.put("js", js);
			return "gotoCustomer";
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

	public String login() throws IOException {
		SiteConfig siteConfig = siteConfigService.selectById(30);
		ActionContext.getContext().getSession().put("lq", siteConfig);
		System.out.println(siteConfig.getConfigValue());
		if (customerService.checkCustomer(customer)) {
			Customer cus = customerService.findByPhone(customer.getCusPhone()).get(0);
			ActionContext.getContext().getSession().put("user", cus);
			ActionContext.getContext().getSession().put("cac", cusAccountService.findByCusId(cus.getCusId()));
			System.out.println(cus.getCusId());

			return "gotoCustomer";
		}

		String js = "<script>YDUI.dialog.alert('用户名或密码错误！');</script>";
		request = (Map<String, Object>) ActionContext.getContext().get("request");
		request.put("js", js);
		String Iwant = (String) ActionContext.getContext().getSession().get("Iwant");
		if (Iwant != null) {
			HttpServletResponse response = ServletActionContext.getResponse();
			ActionContext.getContext().getSession().put("Iwant", null);
			response.sendRedirect(Iwant);
		}
		return "gotoLogin";
	}

	public String update() {
		String value = null;

		if (ActionContext.getContext().getSession().get("Bind") != null) {
			field = (String) ActionContext.getContext().getSession().get("Bind");
			value = (String) ActionContext.getContext().getSession().get("openId");
			List<Customer> check = (List<Customer>) customerService.findByOpenId(value);
			if (check.size() > 0) {
				Customer cusOpenId = check.get(0);
				if (cusOpenId.getCusPhone() == null || "".equals(cusOpenId.getCusPhone())) {
					customerService.delCustomer(check.get(0).getCusId());
				} else {
					Map<String, Object> request = (Map<String, Object>) ActionContext.getContext().get("request");
					request.put("doubleError", "<script>YDUI.dialog.alert('此微信你已绑定过其他手机号！');</script>");
					return "gotoCusMessage";
				}
			}
			ActionContext.getContext().getSession().put("Bind", null);
		}
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
		} else if ("cusImgUrl".equals(field)) {
			value = customer.getCusImgUrl();
		}
		customer = (Customer) ActionContext.getContext().getSession().get("user");
		customerService.updateField(field, value, customer.getCusId());
		customer = customerService.findById(customer.getCusId());
		ActionContext.getContext().getSession().put("user", customer);
		if ("111".equals(customer.getCusPassword())) {
			Template template = new Template();
			template.setFirst("手机账号绑定成功,但账号存在风险，请及时修改密码");
			Map<String, String> keywordMap = new HashMap<String, String>();
			keywordMap.put("keyword1", customer.getCusPhone());
			keywordMap.put("keyword2", "初始密码为111，请及时修改");

			template.setKeyword(keywordMap);
			template.setOpenId(customer.getCusOpenId());
			template.setRemark("请登录账号，修改密码");
			template.setUrl(ServletActionContext.getRequest().getRequestURL());

			ActionContext.getContext().getSession().put("template", template);
			return "gotoNotify";
		}
		if ("cusPassword".equals(field))
			return "gotoLogin";
		return "gotoCusMessage";
	}

	public String forgetPass() throws ServerException, ClientException {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("isError", "false");
		String code = sendCode(customer.getCusPhone());
		map.put("code", code);
		this.result = JSONObject.fromObject(map).toString();
		return SUCCESS;
	}

	public String BindPhone() throws ServerException, ClientException {
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
		ActionContext.getContext().getSession().clear();
		;
		return "logout";
	}

	// 邀请注册用户
	public String askRegister() {
		System.out.println("Action中的askRegister方法！");
		// 邀请人的cusId
		// customer.getCusId();
		request = (Map<String, Object>) ActionContext.getContext().get("request");
		SiteConfig siteConfig = siteConfigService.selectById(1);
		if (customer.getCusId() != null) {
			Customer cus = customerService.findById(customer.getCusId());
			request.put("id", cus);

		}
		request.put("sc", siteConfig);
		// //补全邀请人的信息，传递到页面;注册者完成注册时还需要用到邀请人的信息
		// customer=customerService.select(customer);

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
		// customer.setCusId(1);
		// Customer customer = (Customer)
		// ActionContext.getContext().getSession().get("user");
		// customerResult = customerService.select(customer);
		// System.out.println(customerResult);
		return "myQRCode";
	}

	private String RandomStr() {
		Random random = new Random();
		String radnString = "";
		for (int i = 0; i < 4; i++) {
			radnString += (int) (Math.random() * 10);
		}

		return radnString;
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

	public BusinessService getBusinessService() {
		return businessService;
	}

	public void setBusinessService(BusinessService businessService) {
		this.businessService = businessService;
	}

	public SettingService getSettingService() {
		return settingService;
	}

	public void setSettingService(SettingService settingService) {
		this.settingService = settingService;
	}

	public CtaTradingService getCtaTradingService() {
		return ctaTradingService;
	}

	public void setCtaTradingService(CtaTradingService ctaTradingService) {
		this.ctaTradingService = ctaTradingService;
	}

}
