package com.linestore.action;

import java.util.List;

import com.linestore.service.CusAddressService;
import com.linestore.service.UserService;
import com.linestore.vo.CusAddress;
import com.linestore.vo.Customer;
import com.linestore.vo.UserModel;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class CusAddressAction extends ActionSupport implements ModelDriven<CusAddress> {
	// 模型驱动使用的类
	private CusAddress cusAddress = new CusAddress();
	// implements ModelDriven<CusAddress>
	// 封装返回结果
	private List<CusAddress> cusAddressList;
	private CusAddress cusAddressResult;

	// cusAddress已在上方实例化
	@Override
	public CusAddress getModel() {
		if (cusAddress == null) {
			cusAddress = new CusAddress();
		}
		return cusAddress;
	}

	// Struts和Spring整合过程中按名称来自动注入业务层的类
	private CusAddressService cusAddressService;

	public void setCusAddressService(CusAddressService cusAddressService) {
		this.cusAddressService = cusAddressService;
	}

	// 增加收货地址（模拟已登录用户）
	public String add() {
		System.out.println("CusAddressAction中的add方法！");
		cusAddress.setCaCountry("中国");
//		cusAddress.setCaCusId(1);
		Customer customer=new Customer();
		customer.setCusId(1);
		cusAddress.setCustomer(customer);
		cusAddressService.add(cusAddress);

		return "success";
	}

	// 获取已登录用户的全部收货地址
	public String selectAll() {
		System.out.println("CusAddressAction中的selectAll方法！");

//		cusAddress.setCaCusId(1);
		Customer customer=new Customer();
		customer.setCusId(1);
		cusAddress.setCustomer(customer);
		System.out.println(cusAddress + " : " + cusAddressService);
		cusAddressList = cusAddressService.selectAll(cusAddress);

		return "cusAddressList";
	}

	// 获取已登录用户的指定收货地址
	public String select() {
		System.out.println("CusAddressAction中的select方法！");
		System.out.println("caId:" + cusAddress.getCaId());
		// cusAddressList = cusAddressService.selectAll(cusAddress);
		cusAddressResult = cusAddressService.select(cusAddress);
		System.out.println("cusAddressResult:" + cusAddressResult.getCaName() + " : " + cusAddressResult.getCaAddress()
				+ " : " + cusAddressResult.getCaPhone());
		return "cusAddressEdit";
	}

	// 编辑已登录用户的指定收货地址
	public String edit() {
		System.out.println("CusAddressAction中的edit方法！");

//		cusAddress.setCaCusId(1);
		Customer customer=new Customer();
		customer.setCusId(1);
		cusAddress.setCustomer(customer);
		cusAddress.setCaCountry("中国");

		cusAddressService.update(cusAddress);

		cusAddressList = cusAddressService.selectAll(cusAddress);

		return "cusAddressList";
	}

	// 删除已登录用户的指定收货地址
	public String del() {
		System.out.println("CusAddressAction中的del方法！");

		cusAddressService.del(cusAddress);
//		cusAddress.setCaCusId(1);
		Customer customer=new Customer();
		customer.setCusId(1);
		cusAddress.setCustomer(customer);
		cusAddressList = cusAddressService.selectAll(cusAddress);

		return "cusAddressList";
	}

	public List<CusAddress> getCusAddressList() {
		return cusAddressList;
	}

	public void setCusAddressList(List<CusAddress> cusAddressList) {
		this.cusAddressList = cusAddressList;
	}

	public CusAddress getCusAddressResult() {
		return cusAddressResult;
	}

	public void setCusAddressResult(CusAddress cusAddressResult) {
		this.cusAddressResult = cusAddressResult;
	}

}