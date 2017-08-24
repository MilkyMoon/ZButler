package com.linestore.action;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.github.binarywang.wxpay.bean.request.WxEntPayRequest;
import com.github.binarywang.wxpay.bean.request.WxPayBaseRequest;
import com.github.binarywang.wxpay.bean.request.WxPayUnifiedOrderRequest;
import com.github.binarywang.wxpay.bean.result.WxEntPayQueryResult;
import com.github.binarywang.wxpay.bean.result.WxEntPayResult;
import com.github.binarywang.wxpay.exception.WxPayException;
import com.github.binarywang.wxpay.service.WxPayService;
import com.github.binarywang.wxpay.util.SignUtils;
import com.linestore.WxUtils.TemplateMessage;
import com.linestore.WxUtils.XMLUtil;
import com.linestore.service.AreaService;
import com.linestore.service.BillService;
import com.linestore.service.BusMemberService;
import com.linestore.service.BusTradingService;
import com.linestore.service.BusinessService;
import com.linestore.service.CtaTradingService;
import com.linestore.service.CusAccountService;
import com.linestore.service.CustomerService;
import com.linestore.service.FriendsService;
import com.linestore.service.SettingService;
import com.linestore.service.ThinkUserService;
import com.linestore.service.ThuTradingService;
import com.linestore.util.ReturnUpdateHql;
import com.linestore.vo.Area;
import com.linestore.vo.Bill;
import com.linestore.vo.BusTrading;
import com.linestore.vo.Business;
import com.linestore.vo.CtaTrading;
import com.linestore.vo.CusAccount;
import com.linestore.vo.Customer;
import com.linestore.vo.Friends;
import com.linestore.vo.Template;
import com.linestore.vo.ThuTrading;
import com.opensymphony.xwork2.ActionContext;

import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import net.sf.json.JSONObject;

public class WxPayAction extends WeiXinPayConfigAction implements ServletRequestAware, ServletResponseAware {
	private HttpServletRequest request;
	private HttpServletResponse response;
	protected WxMpService wxService;
	protected WxMpInMemoryConfigStorage config;
	private String result;

	private CtaTradingService ctaTradingService;
	private CusAccountService cusAccountService;
	private BusTradingService busTradingService;
	private BusinessService businessService;
	private BusMemberService busMemberService;
	private SettingService settingService;
	private FriendsService friendsService;
	private Map<String, Object> req;
	private BusTrading busTrading = new BusTrading();
	private ThinkUserService thinkUserService;
	private BillService billService;
	public AreaService areaService;
	private ThuTrading thuTrading = new ThuTrading();
	private ThuTradingService thuTradingService;

	public FriendsService getFriendsService() {
		return friendsService;
	}

	public void setFriendsService(FriendsService friendsService) {
		this.friendsService = friendsService;
	}

	public SettingService getSettingService() {
		return settingService;
	}

	public void setSettingService(SettingService settingService) {
		this.settingService = settingService;
	}

	public BusMemberService getBusMemberService() {
		return busMemberService;
	}

	public void setBusMemberService(BusMemberService busMemberService) {
		this.busMemberService = busMemberService;
	}

	public BusinessService getBusinessService() {
		return businessService;
	}

	public void setBusinessService(BusinessService businessService) {
		this.businessService = businessService;
	}

	public BusTradingService getBusTradingService() {
		return busTradingService;
	}

	public void setBusTradingService(BusTradingService busTradingService) {
		this.busTradingService = busTradingService;
	}

	public CusAccountService getCusAccountService() {
		return cusAccountService;
	}

	public void setCusAccountService(CusAccountService cusAccountService) {
		this.cusAccountService = cusAccountService;
	}

	public CtaTradingService getCtaTradingService() {
		return ctaTradingService;
	}

	public void setCtaTradingService(CtaTradingService ctaTradingService) {
		this.ctaTradingService = ctaTradingService;
	}

	public CustomerService getCustomerService() {
		return customerService;
	}

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	private CustomerService customerService;

	public WxPayAction() {
		super();
		// TODO Auto-generated constructor stub
		config = new WxMpInMemoryConfigStorage();
		config.setAppId("wx5b69c56ac01ed858"); // 设置微信公众号的appid
		config.setSecret("4ad3ebbd02e8f82aede3a22d1a3335a6"); // 设置微信公众号的
																// appsecret
		config.setToken("wxdev"); // 设置微信公众号的token
		config.setOauth2redirectUri(BASE_PATH + "WxOauthRedirect!oauth.action");
		this.wxService = new WxMpServiceImpl();
		wxService.setWxMpConfigStorage(config);
	}

	@Override
	public void setServletResponse(HttpServletResponse response) {
		// TODO Auto-generated method stub
		this.response = response;

	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request = request;

	}

	// 统一下单
	public String getPayInfo() throws WxPayException {
		// 产生订单号（订单号重复）
		// 获取业务类型 R-充值/P-支付商品
		String service = request.getParameter("service").toUpperCase();
		String out_trade_no = null;
		// 获取金额
		String payNum = request.getParameter("payNum");

		// 构建订单标题
		String orderTitle;
		if (service.equals("R")) {
			orderTitle = "众邦管家-零钱充值";
			out_trade_no = new java.util.Date().getTime() + service + this.RandomStr();
		} else if (service.equals("P")) {
			orderTitle = "众邦管家-商品支付";
			out_trade_no = new java.util.Date().getTime() + service + this.RandomStr() + "D"
					+ request.getParameter("busId");

		} else {
			orderTitle = "其他业务";
			out_trade_no = new java.util.Date().getTime() + this.RandomStr();
		}

		Map<String, String> payInfo = this.wxPayService.getPayInfo(
				WxPayUnifiedOrderRequest.newBuilder().body(orderTitle).totalFee(WxPayBaseRequest.yuanToFee(payNum))
						.spbillCreateIp(ServletActionContext.getRequest().getRemoteAddr())
						.notifyURL(BASE_PATH + "WxPay!payNotify.action").tradeType("JSAPI") // 交易类型
						.outTradeNo(out_trade_no) // 唯一订单
						.openid((String) ActionContext.getContext().getSession().get("SCOPE_BASE_OPENID")).build());
		this.result = JSONObject.fromObject(payInfo).toString();
		return SUCCESS;
	}

	// 回调处理

	public void payNotify() {
		String returnString = null;
		try {
			synchronized (this) {
				Map<String, String> kvm = XMLUtil.parseRequestXmlToMap(request);
				if (SignUtils.checkSign(kvm, this.payConfig.getMchKey())) {
					if (kvm.get("result_code").equals("SUCCESS")) {
						// 应答微信
						response.setContentType(" text/xml");
						response.setCharacterEncoding("utf-8");
						response.getWriter().write(
								"<xml><return_code><![CDATA[SUCCESS]]></return_code><return_msg><![CDATA[OK]]></return_msg></xml>");

						// 区分业务逻辑
						String out_trade_no = kvm.get("out_trade_no");
						char service = out_trade_no.charAt(13);

						switch (service) {
						// 获取业务类型 R-充值/P-支付商品
						case 'P':
							// 转账
							Date Pdate = new Date();
							String openIdbus = kvm.get("openid");
							Business bus = businessService.select(subString(kvm.get("out_trade_no"))); // 通过商家ID获取商家
							// 付款订单
							BusTrading bta = new BusTrading();
							bta.setBtaId(kvm.get("out_trade_no"));
							bta.setBtaAddress(bus.getBaCity());
							bta.setBtaMoney(Float.valueOf(kvm.get("total_fee")) / 100);
							bta.setBtaStatus(1);
							bta.setBtaTime(new Timestamp(Pdate.getTime()));
							bta.setBtaType(1);
							bta.setBusiness(bus);
							busTradingService.addBusTrading(bta);

							List<Customer> Pcus = customerService.findByOpenId(openIdbus);

							Bill bill = new Bill();
							if (Pcus != null && Pcus.size() > 0) {
								bill.setCustomer(Pcus.get(0));
							}
							BigDecimal bigMoney = new BigDecimal(kvm.get("total_fee"));
							bigMoney = bigMoney.multiply(new BigDecimal("10000000000"));
							bill.setBilCusMoney(bigMoney);
							// 商家收款
							BigDecimal city = new BigDecimal(Float.toString(bus.getBusScale()));
							System.out.println("!!!!!!!!!" + bus.getBusScale());
							System.out.println("!!!!!!!!!" + city);
							city = bigMoney.subtract(bigMoney.multiply(city));
							bill.setBusiness(bus);
							bill.setBilBusMoney(bigMoney.subtract(city));
							bill.setBilDate(new Timestamp(Pdate.getTime()));

							String TPhone = (String) ActionContext.getContext().getSession().get("payByCashTel");

							if (TPhone == null) {

								if (Pcus != null && Pcus.size() > 0) {
									System.out.println("-----phone--->" + Pcus.get(0).getCusPhone());
									if (Pcus.get(0).getCusPhone() != null && !"".equals(Pcus.get(0).getCusPhone())) {
										Friends fri = friendsService.queryByPhone(Pcus.get(0).getCusPhone());
										if (fri != null) {
											System.out.println("------>friend find;type->" + fri.getFriType());
											if (fri.getFriType() != 1) {
												CusAccount addChangeCac = cusAccountService
														.findByCusId(fri.getCustomer().getCusId());
												float addChange = Float.valueOf(kvm.get("total_fee")) / 100
														* Float.valueOf(settingService.queryById(3).getSetValue());
												city = city.subtract(new BigDecimal(Float.toString(addChange))
														.multiply(new BigDecimal("1000000000000")));
												Float addPoints = addChangeCac.getCacPoints() + addChange;
												CtaTrading addChangeCta = new CtaTrading();
												addChangeCta.setCtaMoney(addChange);
												addChangeCta.setCtaTime(new Timestamp(Pdate.getTime()));
												addChangeCta.setCtaType(13);
												addChangeCta.setCtaStatus(1);
												addChangeCta.setCustomer(fri.getCustomer());
												addChangeCta.setCtaId(Pdate.getTime() + "F" + this.RandomStr()); // 付款返积分
												ctaTradingService.addCtaTrading(addChangeCta);
												cusAccountService.updateField("cacPoints", String.valueOf(addPoints),
														addChangeCac.getCacId());
											}
										}
									}
									
									CusAccount CAC = (CusAccount) cusAccountService.findByCusId(Pcus.get(0).getCusId());
									System.out.println("%%%%%%%%%%%" + CAC.getCacPoints());
									if (CAC != null) {
										Float Addpiont = Float.valueOf(kvm.get("total_fee")) / 100
												* bus.getBusScalePoints();
										CtaTrading addChangeCta = new CtaTrading();
										BigDecimal zhuanghuan = new BigDecimal(Addpiont).setScale(6,
												BigDecimal.ROUND_DOWN);
										city = city.subtract(zhuanghuan.multiply(new BigDecimal("1000000000000")));
										addChangeCta.setCtaMoney(Addpiont);
										addChangeCta.setCtaTime(new Timestamp(Pdate.getTime()));
										addChangeCta.setCtaType(14);
										addChangeCta.setCustomer(Pcus.get(0));
										addChangeCta.setCtaStatus(1);
										addChangeCta.setCtaId(Pdate.getTime() + "Z" + this.RandomStr()); // 付款返用户积分
										ctaTradingService.addCtaTrading(addChangeCta);
										Addpiont += CAC.getCacPoints();
										System.out.println("&&&&&&&&&&" + Addpiont);
										cusAccountService.updateField("cacPoints", String.valueOf(Addpiont),
												CAC.getCacId());
									}

								}
							} else {
								Friends fri = friendsService.queryByPhone(TPhone);
								if (fri != null) {
									System.out.println("------>friend find;type->" + fri.getFriType());
									if (fri.getFriType() != 1) {
										CusAccount addChangeCac = cusAccountService
												.findByCusId(fri.getCustomer().getCusId());
										float addChange = Float.valueOf(kvm.get("total_fee")) / 100
												* Float.valueOf(settingService.queryById(3).getSetValue());
										city = city.subtract(new BigDecimal(Float.toString(addChange))
												.multiply(new BigDecimal("1000000000000")));
										Float addPoints = addChangeCac.getCacPoints() + addChange;
										CtaTrading addChangeCta = new CtaTrading();
										addChangeCta.setCtaMoney(addChange);
										addChangeCta.setCtaTime(new Timestamp(Pdate.getTime()));
										addChangeCta.setCtaType(13);
										addChangeCta.setCtaStatus(1);
										addChangeCta.setCustomer(fri.getCustomer());
										addChangeCta.setCtaId(Pdate.getTime() + "F" + this.RandomStr()); // 付款返积分
										ctaTradingService.addCtaTrading(addChangeCta);
										cusAccountService.updateField("cacPoints", String.valueOf(addPoints),
												addChangeCac.getCacId());
									}
								}
								List<Customer> cusPhone = customerService.findByPhone(TPhone);
								CusAccount CAC = null;
								if (cusPhone.size() > 0) {
									CAC = (CusAccount) cusAccountService.findByCusId(cusPhone.get(0).getCusId());
								}
								System.out.println("%%%%%%%%%%%" + CAC.getCacPoints());
								if (CAC != null) {
									Float Addpiont = Float.valueOf(kvm.get("total_fee")) / 100
											* bus.getBusScalePoints();
									CtaTrading addChangeCta = new CtaTrading();
									BigDecimal zhuanghuan = new BigDecimal(Addpiont).setScale(6,
											BigDecimal.ROUND_DOWN);
									city = city.subtract(zhuanghuan.multiply(new BigDecimal("1000000000000")));
									addChangeCta.setCtaMoney(Addpiont);
									addChangeCta.setCtaTime(new Timestamp(Pdate.getTime()));
									addChangeCta.setCtaType(14);
									addChangeCta.setCustomer(Pcus.get(0));
									addChangeCta.setCtaStatus(1);
									addChangeCta.setCtaId(Pdate.getTime() + "Z" + this.RandomStr()); // 付款返用户积分
									ctaTradingService.addCtaTrading(addChangeCta);
									Addpiont += CAC.getCacPoints();
									System.out.println("&&&&&&&&&&" + Addpiont);
									cusAccountService.updateField("cacPoints", String.valueOf(Addpiont),
											CAC.getCacId());
								}
							}
							System.out.println(">>>>>>>>>>>" + city);
							bigMoney = city;
							System.out.println("1: " + bigMoney.toString());
							// 物业收款
							// System.out.println("----thuId: " + bus.getBus());
							Area area = bus.getArea();
							if (area.getAreaWay() == 1) {
								BigDecimal dailishang = new BigDecimal(area.getAreaScale());
								dailishang = bigMoney.subtract(bigMoney.multiply(dailishang));
								bill.setAreaByThuPropertyId(area);
								bill.setBilPropertyMoney(dailishang);
								bigMoney = bigMoney.subtract(dailishang);
								System.out.println("2: " + bigMoney.toString());
								areaService.updateMoney(dailishang.add(area.getAreaTotalMoney()).toString(),
										area.getAreId());
								// 县收款
								area = areaService.queryById(area.getPid());
								dailishang = new BigDecimal(area.getAreaScale());
								dailishang = bigMoney.subtract(bigMoney.multiply(dailishang));
								bill.setAreaByThuCountyId(area);
								bill.setBilCountyMoney(dailishang);
								bigMoney = bigMoney.subtract(dailishang);
								System.out.println("3: " + bigMoney.toString());
								areaService.updateMoney(dailishang.add(area.getAreaTotalMoney()).toString(),
										area.getAreId());
								// 市收款
								area = areaService.queryById(area.getPid());
								dailishang = new BigDecimal(area.getAreaScale());
								dailishang = bigMoney.subtract(bigMoney.multiply(dailishang));
								bill.setAreaByThuCityId(area);
								bill.setBilCityMoney(dailishang);
								bigMoney = bigMoney.subtract(dailishang);
								System.out.println("4: " + bigMoney.toString());
								areaService.updateMoney(dailishang.add(area.getAreaTotalMoney()).toString(),
										area.getAreId());
								// 省收款
								area = areaService.queryById(area.getPid());
								dailishang = new BigDecimal(area.getAreaScale());
								dailishang = bigMoney.subtract(bigMoney.multiply(dailishang));
								bill.setBilProvinceMoney(dailishang);
								bill.setAreaByThuProvinceId(area);
								bigMoney = bigMoney.subtract(dailishang);
								System.out.println("5: " + bigMoney.toString());
								areaService.updateMoney(dailishang.add(area.getAreaTotalMoney()).toString(),
										area.getAreId());
								// 众邦收款
								area = areaService.queryById(area.getPid());
								bill.setBilZongMoney(bigMoney);
								System.out.println("old: " + area.getAreaTotalMoney().toString());
								System.out.println("new: " + dailishang.toString());
								areaService.updateMoney(bigMoney.add(area.getAreaTotalMoney()).toString(),
										area.getAreId());
							} else {
								float tRatio = 1;
								// 县
								Area ThuCounty = areaService.queryById(area.getPid());
								// 市
								Area ThuCity = areaService.queryById(ThuCounty.getPid());
								// 省
								Area ThuProvince = areaService.queryById(ThuCity.getPid());
								// 众邦
								Area zong = areaService.queryById(ThuProvince.getPid());

								tRatio = tRatio - area.getAreaScaleTwo() - ThuCounty.getAreaScaleTwo()
										- ThuCity.getAreaScaleTwo() - ThuProvince.getAreaScaleTwo();

								bill.setAreaByThuPropertyId(area);
								bill.setBilPropertyMoney(
										bigMoney.multiply(new BigDecimal(tRatio).setScale(2, BigDecimal.ROUND_DOWN)));
								areaService.updateMoney(
										bigMoney.multiply(new BigDecimal(tRatio).setScale(2, BigDecimal.ROUND_DOWN))
												.add(area.getAreaTotalMoney()).toString(),
										area.getAreId());
								// // 县收款
								bill.setAreaByThuCountyId(ThuCounty);
								bill.setBilCountyMoney(bigMoney.multiply(
										new BigDecimal(area.getAreaScaleTwo()).setScale(5, BigDecimal.ROUND_DOWN)));
								areaService.updateMoney(
										bigMoney.multiply(new BigDecimal(area.getAreaScaleTwo()).setScale(5,
												BigDecimal.ROUND_DOWN)).add(ThuCounty.getAreaTotalMoney()).toString(),
										ThuCounty.getAreId());
								// // 市收款
								bill.setAreaByThuCityId(ThuCity);
								bill.setBilCityMoney(bigMoney.multiply(new BigDecimal(ThuCounty.getAreaScaleTwo())
										.setScale(5, BigDecimal.ROUND_DOWN)));
								areaService.updateMoney(
										bigMoney.multiply(new BigDecimal(ThuCounty.getAreaScaleTwo()).setScale(5,
												BigDecimal.ROUND_DOWN)).add(ThuCity.getAreaTotalMoney()).toString(),
										ThuCity.getAreId());
								// // 省收款
								bill.setAreaByThuProvinceId(ThuProvince);
								bill.setBilProvinceMoney(bigMoney.multiply(
										new BigDecimal(ThuCity.getAreaScaleTwo()).setScale(5, BigDecimal.ROUND_DOWN)));
								areaService.updateMoney(
										bigMoney.multiply(new BigDecimal(ThuCity.getAreaScaleTwo()).setScale(5,
												BigDecimal.ROUND_DOWN)).add(ThuProvince.getAreaTotalMoney()).toString(),
										ThuProvince.getAreId());
								// // 众邦收款
								bill.setBilZongMoney(bigMoney.multiply(new BigDecimal(ThuProvince.getAreaScaleTwo())
										.setScale(5, BigDecimal.ROUND_DOWN)));
								areaService
										.updateMoney(bigMoney
												.multiply(new BigDecimal(ThuProvince.getAreaScaleTwo()).setScale(5,
														BigDecimal.ROUND_DOWN))
												.add(zong.getAreaTotalMoney()).toString(), 1);
							}
							billService.addBill(bill);

							// 存数据库+转账
							// WxEntPayRequest wxEntPayRequest = new
							// WxEntPayRequest();
							// wxEntPayRequest.setAmount(Integer.parseInt(kvm.get("total_fee")));
							// wxEntPayRequest.setDescription("");
							// wxEntPayRequest.setOpenid("");
							// this.payToIndividual(wxEntPayRequest,
							// wxPayService);
							break;
						case 'R':
							System.out.println("123123123");
							CtaTrading cta = new CtaTrading();
							String openId = kvm.get("openid");
							Customer cus = (Customer) customerService.findByOpenId(openId).get(0);
							CusAccount cusAccount = cusAccountService.findByCusId(cus.getCusId());
							Float money = cusAccount.getCacChange() + Float.valueOf(kvm.get("total_fee")) / 100;

							cta.setCustomer(cus);
							cta.setCtaMoney(Float.valueOf(kvm.get("total_fee")) / 100);
							cta.setCtaId(kvm.get("out_trade_no"));
							cta.setCtaType(1);
							cta.setCtaStatus(1);
							Date Rdate = new Date();
							cta.setCtaTime(new Timestamp(Rdate.getTime()));
							ctaTradingService.addCtaTrading(cta);
							cusAccountService.updateField("cacChange", String.valueOf(money), cusAccount.getCacId());

							System.out.println(cus.getCusPhone());
							if (cus.getCusPhone() != null && !"".equals(cus.getCusPhone())) {
								// 充值零钱返积分
								Friends fris = friendsService.queryByPhone(cus.getCusPhone());
								if (fris != null) {
									CusAccount addPointAcc = cusAccountService
											.findByCusId(fris.getCustomer().getCusId());
									CtaTrading addPointCta = new CtaTrading();
									Float moneyOne = addPointAcc.getCacPoints() + Float.valueOf(kvm.get("total_fee"))
											/ 100 * Float.valueOf(settingService.queryById(1).getSetValue());
									cusAccountService.updateField("cacPoints", String.valueOf(moneyOne),
											addPointAcc.getCacId());
									addPointCta.setCtaMoney(Float.valueOf(kvm.get("total_fee")) / 100
											* Float.valueOf(settingService.queryById(1).getSetValue()));
									System.out.println("money: " + kvm.get("total_fee"));
									System.out.println("prop: " + settingService.queryById(1).getSetValue());
									System.out.println("total: " + Float.valueOf(kvm.get("total_fee"))
											* Float.valueOf(settingService.queryById(1).getSetValue()));
									addPointCta.setCtaTime(new Timestamp(Rdate.getTime()));
									addPointCta.setCtaType(12);
									addPointCta.setCtaStatus(1);
									addPointCta.setCustomer(fris.getCustomer());
									addPointCta.setCtaId(Rdate.getTime() + "Z" + this.RandomStr());
									ctaTradingService.addCtaTrading(addPointCta);
								}
							}

							Template template = new Template();
							template.setFirst("众邦管家---零钱充值");
							Map<String, String> map = new HashMap<String, String>();
							map.put("keyword1", cus.getCusNickname());
							map.put("keyword2", kvm.get("out_trade_no"));
							map.put("keyword3", (Float.toString(Float.valueOf(kvm.get("total_fee")) / 100)));
							map.put("keyword4", "零钱充值");
							template.setKeyword(map);
							template.setOpenId(kvm.get("openid"));
							template.setRemark("零钱已经到账，请注意查收");
							TemplateMessage.RechargeMoneyNotify(template, this.wxService);
							break;
						default:
							break;
						}

						System.out.println("out_trade_no: " + kvm.get("out_trade_no") + " pay SUCCESS!");

					} else {
						response.setContentType(" text/xml");
						response.setCharacterEncoding("utf-8");
						System.out.println("out_trade_no: " + kvm.get("out_trade_no") + " result_code is FAIL");
						response.getWriter().write(
								"<xml><return_code><![CDATA[FAIL]]></return_code><return_msg><![CDATA[result_code is FAIL]]></return_msg></xml>");
					}
				} else {
					response.setContentType(" text/xml");
					response.setCharacterEncoding("utf-8");
					response.getWriter().write(
							"<xml><return_code><![CDATA[FAIL]]></return_code><return_msg><![CDATA[check signature FAIL]]></return_msg></xml>");
					System.out.println("out_trade_no: " + kvm.get("out_trade_no") + " check signature FAIL");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void paymentToMerchant(WxEntPayRequest wxEntPayRequest, WxPayService wxPayService) {
		String resutl = payToIndividual(wxEntPayRequest, wxPayService);
		if (resutl.equals("SUCCESS")) {
			System.out.println("SUCCESS");
		} else {
			System.out.println(resutl);
		}

	}

	public String postal() {
		// 构建提现 WxEntPayRequest
		req = (Map<String, Object>) ActionContext.getContext().get("request");
		String resutl = payToIndividual((WxEntPayRequest) req.get("wxEntPayRequest"), this.wxPayService);

		if (resutl.equals("SUCCESS")) {
			busTrading = (BusTrading) req.get("busTrading");
			String hql;
			try {
				hql = ReturnUpdateHql.ReturnHql(busTrading.getClass(), busTrading, busTrading.getBtaId());
				System.out.println("hql:" + hql);
				busTradingService.update(hql);
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return "paySuccess";
		} else {
			return "paySuccess";
		}
	}

	public String postalThu() {
		// 构建提现 WxEntPayRequest
		req = (Map<String, Object>) ActionContext.getContext().get("request");
		String resutl = payToIndividual((WxEntPayRequest) req.get("wxEntPayRequest"), this.wxPayService);

		if (resutl.equals("SUCCESS")) {
			thuTrading = (ThuTrading) req.get("thuTrading");
			String hql;
			try {
				hql = ReturnUpdateHql.ReturnHql(thuTrading.getClass(), thuTrading, thuTrading.getThtId());
				System.out.println("hql:" + hql);
				thuTradingService.update(hql);
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return "paySuccess";
		} else {
			return "paySuccess";
		}
	}

	public String payToIndividual(WxEntPayRequest wxEntPayRequest, WxPayService wxPayService) {
		wxEntPayRequest.setCheckName("NO_CHECK");
		wxEntPayRequest.setSpbillCreateIp(this.request.getRemoteAddr());
		WxEntPayResult wxEntPayResult = null;
		try {
			wxEntPayResult = wxPayService.entPay(wxEntPayRequest);
			if ("SUCCESS".equals(wxEntPayResult.getResultCode().toUpperCase())
					&& "SUCCESS".equals(wxEntPayResult.getReturnCode().toUpperCase())) {
				return "SUCCESS";
			}
		} catch (WxPayException e) {
			// TODO Auto-generated catch block
			System.out.println("错误异常代码" + e);
		}
		return "err_code: " + wxEntPayResult.getErrCode() + "err_code_des: " + wxEntPayResult.getErrCodeDes();
	}

	public void queryResult() throws WxPayException {
		// 构建查询体
		String partner_trade_no = "";
		WxEntPayQueryResult wxEntPayQueryResult = this.wxPayService.queryEntPay(partner_trade_no);
		if ("SUCCESS".equals(wxEntPayQueryResult.getResultCode().toUpperCase())
				&& "SUCCESS".equals(wxEntPayQueryResult.getReturnCode().toUpperCase())) {
			// 构建返回结果
		}
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	private String RandomStr() {
		Random random = new Random();
		String radnString = "";
		for (int i = 0; i < 4; i++) {
			radnString += (int) (Math.random() * 10);
		}

		return radnString;
	}

	public int subString(String a) {
		int index = a.length();
		for (int i = 0; i < index; i++) {
			if (a.charAt(i) == 'D') {
				index = i;
			}
		}
		return Integer.parseInt(a.substring(index + 1));
	}

	public BusTrading getBusTrading() {
		return busTrading;
	}

	public void setBusTrading(BusTrading busTrading) {
		this.busTrading = busTrading;
	}

	public ThinkUserService getThinkUserService() {
		return thinkUserService;
	}

	public void setThinkUserService(ThinkUserService thinkUserService) {
		this.thinkUserService = thinkUserService;
	}

	public WxMpService getWxService() {
		return wxService;
	}

	public void setWxService(WxMpService wxService) {
		this.wxService = wxService;
	}

	public BillService getBillService() {
		return billService;
	}

	public void setBillService(BillService billService) {
		this.billService = billService;
	}

	public AreaService getAreaService() {
		return areaService;
	}

	public void setAreaService(AreaService areaService) {
		this.areaService = areaService;
	}

	public ThuTradingService getThuTradingService() {
		return thuTradingService;
	}

	public void setThuTradingService(ThuTradingService thuTradingService) {
		this.thuTradingService = thuTradingService;
	}

}
