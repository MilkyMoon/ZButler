package com.linestore.action;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.linestore.service.BusTradingService;
import com.linestore.service.BusinessService;
import com.linestore.service.CusAccountService;
import com.linestore.service.CustomerService;
import com.linestore.vo.BusTrading;
import com.linestore.vo.Business;
import com.linestore.vo.CusAccount;
import com.linestore.vo.Customer;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class BusTradingAction extends ActionSupport implements ModelDriven<BusTrading> {

	private BusTrading busTrading = new BusTrading();

	private BusTradingService busTradingService;

	private BusinessService businessService;

	private CustomerService customerService;
	
	private CusAccountService cusAccountService;

	private float money;

	private int busId;

	private String tel;

	Map<String, Object> request;

	@Override
	public BusTrading getModel() {
		return busTrading;
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

	public String add() {
		busTrading.setBtaTime(new Timestamp(new Date().getTime()));
		busTrading.setBtaType(11);
		Business bus = (Business) ActionContext.getContext().getSession().get("store");

		String btaId = new java.util.Date().getTime() + "T" + this.RandomStr();
		busTrading.setBtaId(btaId);
		busTrading.setBusiness(bus);
		busTrading.setBtaAddress(bus.getBaCity());
		busTrading.setBtaStatus(0);
		busTradingService.addBusTrading(busTrading);
		bus.setBusChange(bus.getBusChange() - busTrading.getBtaMoney());
		businessService.update(bus);
		ActionContext.getContext().getSession().put("store", bus);
		request = (Map<String, Object>) ActionContext.getContext().get("request");
		request.put("js", "<script>YDUI.dialog.alert('申请成功！');</script>");
		return "gotoSamllMoney";
	}

	public String queryIncome() {
		Business bus = (Business) ActionContext.getContext().getSession().get("store");
		busTradingService.queryWithdraw(bus.getBusId());
		request = (Map<String, Object>) ActionContext.getContext().get("request");
		request.put("Income", busTradingService.queryIncome(bus.getBusId()));
		return "gotoIncom";
	}

	public String queryWithdraw() {
		Business bus = (Business) ActionContext.getContext().getSession().get("store");
		busTradingService.queryWithdraw(bus.getBusId());
		request = (Map<String, Object>) ActionContext.getContext().get("request");
		request.put("Withdraw", busTradingService.queryWithdraw(bus.getBusId()));
		return "gotoWithdraw";
	}

	public String payByCash() {
		if (customerService.findByPhone(tel).size() < 1) {
			Customer customer = new Customer();
			customer.setCusPhone(tel);
			customer.setCusNickname("ZB_" + tel);
			customer.setCusImgUrl("home/dist/wx_image/111.jpg");
			customer.setCusStatus(1);
			customer.setCusPassword("888888");
			customerService.addCustomer(customer);
			init(customer);
		}
		ActionContext.getContext().getSession().put("payByCashMoney", money);
		ActionContext.getContext().getSession().put("payByCashCusID", busId);
		ActionContext.getContext().getSession().put("payByCashTel", tel);
		return "payBgyCash";
	}

	public BusTradingService getBusTradingService() {
		return busTradingService;
	}

	public void setBusTradingService(BusTradingService busTradingService) {
		this.busTradingService = busTradingService;
	}

	public BusinessService getBusinessService() {
		return businessService;
	}

	public void setBusinessService(BusinessService businessService) {
		this.businessService = businessService;
	}

	private String RandomStr() {
		Random random = new Random();
		String radnString = "";
		for (int i = 0; i < 4; i++) {
			radnString += (int) (Math.random() * 10);
		}

		return radnString;
	}

	public BusTrading getBusTrading() {
		return busTrading;
	}

	public void setBusTrading(BusTrading busTrading) {
		this.busTrading = busTrading;
	}

	public float getMoney() {
		return money;
	}

	public void setMoney(float money) {
		this.money = money;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public CustomerService getCustomerService() {
		return customerService;
	}

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	public int getBusId() {
		return busId;
	}

	public void setBusId(int busId) {
		this.busId = busId;
	}

	public CusAccountService getCusAccountService() {
		return cusAccountService;
	}

	public void setCusAccountService(CusAccountService cusAccountService) {
		this.cusAccountService = cusAccountService;
	}
	
	

}
