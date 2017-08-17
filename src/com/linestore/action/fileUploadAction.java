package com.linestore.action;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import javassist.expr.NewArray;
import me.chanjar.weixin.mp.api.WxMpMessageRouter;
import net.sf.json.JSONObject;

public class fileUploadAction extends ActionSupport implements ServletRequestAware, ServletResponseAware {
	private HttpServletRequest request;
	private HttpServletResponse response;
	protected WxMpMessageRouter wxMpMessageRouter;

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

	// 上传文件者
	private String uploader;
	// 上传的文件
	private File upload;
	// 上传文件类型
	private String uploadContentType;
	// 上传文件的文件名
	private String uploadFileName;
	// 上传文件的保存路径
	private String savePath;

	private String result;

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String execute() throws Exception {
		String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
				+ request.getContextPath() + "/";
		String fileType;
		fileType = getUploadFileName().substring(getUploadFileName().lastIndexOf(".") + 1);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		String savePath = "uploadFiles/" + sdf.format(new Date());
		setSavePath(savePath);
		setUploadFileName(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + "." + fileType);
		// 设置上传文件保存路径
		String realpath = getSavePath();
		// 判断上传文件是否为空
		if (upload != null) {

			// 根据路径以及文件名，新建一个File文件实例
			File savefile = new File(realpath, getUploadFileName());
			// 判断此路径是否已经存在
			if (!savefile.getParentFile().exists())
				savefile.getParentFile().mkdirs();

			// 把上传文件拷贝到新路径下，完成上传
			FileUtils.copyFile(upload, savefile);
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("fileName", getUploadFileName());
			map.put("filePath", basePath + savePath + '/' + getUploadFileName());
			map.put("msg", "success");

			this.result = JSONObject.fromObject(map).toString();
			System.out.println(this.result);
			return SUCCESS;
		}
		// 其他情况，上传失败
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("msg", "failed");
		return SUCCESS;
	}

	public void delFile() {
	}

	public String getUploader() {
		return uploader;
	}

	public void setUploader(String uploader) {
		this.uploader = uploader;
	}

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public String getSavePath() {
		// String basePath = request.getScheme() + "://" +
		// request.getServerName() + ":" + request.getServerPort()
		// + request.getContextPath() + "/";
		return ServletActionContext.getServletContext().getRealPath(savePath) + "/";
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}
}
