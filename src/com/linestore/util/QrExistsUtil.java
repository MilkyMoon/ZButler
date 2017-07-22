+package com.linestore.util;
 +
 +import java.io.File;
 +import java.io.IOException;
 +
 +import javax.servlet.http.HttpServletRequest;
 +
 +import org.apache.struts2.ServletActionContext;
 +
 +import com.linestore.vo.Customer;
 +
 +public class QrExistsUtil {
 +
 +	public static boolean isExists;
 +	public static final String REG_PATH = "http://localhost:8080/User_register?cus_id=";
 +
 +	// 判断二维码图片是否存在
 +	public static boolean qrExists(String qrPath) {
 +		System.out.println("qrPath:"+qrPath);
 +		File file = new File(qrPath);
 +		if (file.exists()) {
 +			System.out.println("file exists");
 +			isExists = true;
 +		} else {
 +			System.out.println("file not exists");
 +			isExists = false;
 +		}
 +		return isExists;
 +	}
 +
 +	// 生成二维码
 +	public static Customer qrCreate(Customer customer) {
 +
 +		// 生成用户邀请注册链接，并构造对应二维码图片，将图片url存入数据库
 +		// 邀请注册链接,含邀请人id参数
 +		String url = REG_PATH + customer.getCusId();
 +
 +		// 二维码图片存放路径
 +		StringBuffer sb = new StringBuffer("");
 +		// tomcat运行时的项目所在路径
 +		HttpServletRequest request = ServletActionContext.getRequest();
 +		String realPath = request.getSession().getServletContext().getRealPath("");
 +		// 暂时用手写的项目路径代替
 +		// String realPath="/Users/wutianci/GitHub/ZButler/WebRoot/";
 +		sb.append(realPath);
 +		sb.append("home/qr");
 +		String qrPath = sb.toString();
 +		// 文件名
 +		String fileName = customer.getCusId() + ".jpg";
 +		// 执行二维码生成及保存文件
 +		QrCodeUtil.createQrCode(url, qrPath, fileName);
 +
 +		// 图片全路径
 +		String imgPath = qrPath + "/" + fileName;
 +
 +		// 用户邀请链接、二维码路径存放到数据表
 +		customer.setCusShareUrl(url);
 +		customer.setCusTdCode(imgPath);
 +		return customer;
 +	}
 +}
