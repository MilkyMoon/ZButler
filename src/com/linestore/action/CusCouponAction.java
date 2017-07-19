package com.linestore.action;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.linestore.vo.CusCoupon;
import com.linestore.vo.Customer;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class CusCouponAction extends ActionSupport implements ModelDriven<CusCoupon> {
	
	private CusCoupon cusCoupon = new CusCoupon();
	
	private Map<String, Object> request;

	@Override
	public CusCoupon getModel() {
		// TODO Auto-generated method stub
		return cusCoupon;
	}
	
	
	public String grouping() {
		Customer customer = (Customer) ActionContext.getContext().getSession().get("user");
		if (customer != null) {
			Set used = new HashSet(0);
			Set usable = new HashSet(0);
			Set expired = new HashSet(0);

			Set coupons = customer.getCusCoupons();
			for (Iterator it = coupons.iterator(); it.hasNext();) {
				CusCoupon coupon = (CusCoupon) it.next();
				if (DateCompara(coupon.getBusCoupon().getBcEndDate())) {
					if (coupon.getBusCoupon().getBcStatus() == 0) {
						used.add(coupon);
					} else {
						usable.add(coupon);
					}
				} else {
					expired.add(coupon);
				}
			}
			request = (Map<String, Object>) ActionContext.getContext().get("request");
			request.put("used", used);
			request.put("expired", expired);
			request.put("usable", usable);
			return "gotoCoupon";
		}
		
		return "gotoLogin";
	}
	
	private boolean DateCompara(Date date){
		Date today = new Date();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		try {
			if (df.parse(date.toString()).after(today)) {
				return true;
			} else {
				return false;
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return false;
	}
}
