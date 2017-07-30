package com.linestore.action;

import com.linestore.vo.Template;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateData;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;

public class TemplateMessageAction extends WeXinConfigAction {

	private static final String TEMPLATE_FRONT_COLOR = "#32CD32";

	/**
	 * 账号绑定成功模板消息通知
	 * 
	 * @example:{{first.DATA}} 帐号：{{keyword1.DATA}} 备注：{{keyword2.DATA}}
	 *                         {{remark.DATA}}
	 * 
	 * @templeteId:EMVf7ggfoatK7AgrFu_eY4pKb6cnIh0T6kMoXa46zp0
	 * 
	 * @param template
	 * @throws WxErrorException
	 */
	public String registerSuccessNotify() throws WxErrorException {
		
		Template template =(Template) ActionContext.getContext().getSession().get("template");

		WxMpTemplateMessage templateMessage = new WxMpTemplateMessage();
		templateMessage.setToUser(template.getOpenId());
		templateMessage.setTemplateId("EMVf7ggfoatK7AgrFu_eY4pKb6cnIh0T6kMoXa46zp0");
		templateMessage.setUrl("");
		WxMpTemplateData firstdata = new WxMpTemplateData("first",
				wxService.getUserService().userInfo(template.getOpenId()).getNickname() + template.getFirst(),
				TEMPLATE_FRONT_COLOR);
		WxMpTemplateData keyword1 = new WxMpTemplateData("keyword1", template.getKeyword().get("keyword1"));
		WxMpTemplateData keyword2 = new WxMpTemplateData("keyword2", template.getKeyword().get("keyword2"));
		WxMpTemplateData remarkData = new WxMpTemplateData("remark", template.getRemark(), TEMPLATE_FRONT_COLOR);

		templateMessage.addWxMpTemplateData(firstdata);
		templateMessage.addWxMpTemplateData(keyword1);
		templateMessage.addWxMpTemplateData(keyword2);
		templateMessage.addWxMpTemplateData(remarkData);

		try {
			wxService.getTemplateMsgService().sendTemplateMsg(templateMessage);
		} catch (WxErrorException e) {
			// TODO: handle exception
			System.out.println(e.getMessage().toString());
		}
		
		return "goPersonalCenter";

	}

	// 订单取消模板消息通知
	// 下单成功模板消息通知
	// UKwXMihVIwvd09EPkHymNuNQntVCYdGsxirPjIfs6wI

	/**
	 * 零钱充值模板消息通知
	 * 
	 * @example:{{first.DATA}} 用户名：{{keyword1.DATA}} 订单号：{{keyword2.DATA}}
	 *                         订单金额：{{keyword3.DATA}} 商品信息：{{keyword4.DATA}}
	 *                         {{remark.DATA}}
	 * 
	 * 
	 * @templeteId UKwXMihVIwvd09EPkHymNuNQntVCYdGsxirPjIfs6wI
	 * 
	 * @param template
	 * @throws WxErrorException
	 */
	public void RechargeMoneyNotify(Template template) throws WxErrorException {
		WxMpTemplateMessage templateMessage = new WxMpTemplateMessage();
		templateMessage.setToUser(template.getOpenId());
		templateMessage.setTemplateId("EMVf7ggfoatK7AgrFu_eY4pKb6cnIh0T6kMoXa46zp0");
		templateMessage.setUrl("");
		WxMpTemplateData firstdata = new WxMpTemplateData("first",
				wxService.getUserService().userInfo(template.getOpenId()).getNickname() + template.getFirst(),
				TEMPLATE_FRONT_COLOR);
		WxMpTemplateData keyword1 = new WxMpTemplateData("keyword1", template.getKeyword().get("keyword1"));
		WxMpTemplateData keyword2 = new WxMpTemplateData("keyword2", template.getKeyword().get("keyword2"));
		WxMpTemplateData keyword3 = new WxMpTemplateData("keyword3", template.getKeyword().get("keyword3"));
		WxMpTemplateData keyword4 = new WxMpTemplateData("keyword4", template.getKeyword().get("keyword4"));
		WxMpTemplateData remarkData = new WxMpTemplateData("remark", template.getRemark(), TEMPLATE_FRONT_COLOR);

		templateMessage.addWxMpTemplateData(firstdata);
		templateMessage.addWxMpTemplateData(keyword1);
		templateMessage.addWxMpTemplateData(keyword2);
		templateMessage.addWxMpTemplateData(keyword3);
		templateMessage.addWxMpTemplateData(keyword4);
		templateMessage.addWxMpTemplateData(remarkData);

		try {
			wxService.getTemplateMsgService().sendTemplateMsg(templateMessage);
		} catch (WxErrorException e) {
			// TODO: handle exception
			System.out.println(e.getMessage().toString());
		}

	}

	/**
	 * 积分转换模板消息通知
	 * 
	 * @example:{{first.DATA}} 获得时间：{{keyword1.DATA}} 获得积分：{{keyword2.DATA}}
	 *                         获得原因：{{keyword3.DATA}} 当前积分：{{keyword4.DATA}}
	 *                         {{remark.DATA}}
	 * 
	 * @templeteId 7uFOmfuFEGV8tumMbZnFGV6w7NJn7wts9WE5dWQFt0Y
	 * 
	 * @param template
	 * @throws WxErrorException
	 */
	public void IntegralVariationNotify(Template template) throws WxErrorException {

		WxMpTemplateMessage templateMessage = new WxMpTemplateMessage();
		templateMessage.setToUser(template.getOpenId());
		templateMessage.setTemplateId("EMVf7ggfoatK7AgrFu_eY4pKb6cnIh0T6kMoXa46zp0");
		templateMessage.setUrl("");
		WxMpTemplateData firstdata = new WxMpTemplateData("first",
				wxService.getUserService().userInfo(template.getOpenId()).getNickname() + template.getFirst(),
				TEMPLATE_FRONT_COLOR);
		WxMpTemplateData keyword1 = new WxMpTemplateData("keyword1", template.getKeyword().get("keyword1"));
		WxMpTemplateData keyword2 = new WxMpTemplateData("keyword2", template.getKeyword().get("keyword2"));
		WxMpTemplateData keyword3 = new WxMpTemplateData("keyword3", template.getKeyword().get("keyword3"));
		WxMpTemplateData keyword4 = new WxMpTemplateData("keyword4", template.getKeyword().get("keyword4"));
		WxMpTemplateData remarkData = new WxMpTemplateData("remark", template.getRemark(), TEMPLATE_FRONT_COLOR);

		templateMessage.addWxMpTemplateData(firstdata);
		templateMessage.addWxMpTemplateData(keyword1);
		templateMessage.addWxMpTemplateData(keyword2);
		templateMessage.addWxMpTemplateData(keyword3);
		templateMessage.addWxMpTemplateData(keyword4);
		templateMessage.addWxMpTemplateData(remarkData);

		try {
			wxService.getTemplateMsgService().sendTemplateMsg(templateMessage);
		} catch (WxErrorException e) {
			// TODO: handle exception
			System.out.println(e.getMessage().toString());
		}
	}
	
	public void a(Template template){
		
	}
	
}
