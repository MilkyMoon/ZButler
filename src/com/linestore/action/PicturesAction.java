package com.linestore.action;

import java.util.List;

import com.linestore.service.PicturesService;
import com.linestore.vo.Business;
import com.linestore.vo.Pictures;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class PicturesAction extends ActionSupport implements ModelDriven<Pictures> {

	private Pictures pictures = new Pictures();
	
	private PicturesService picturesService;
	
	@Override
	public Pictures getModel() {
		return pictures;
	}
	
	public String add() {
		picturesService.addPicture(pictures);
		return "add";
	}
	
//	public void update() {
//		try {
//			String hql = ReturnUpdateHql.ReturnHql(Pictures.class, pictures, pictures.getPicId());
//			picturesService.updatePicture(hql);
//		} catch (NoSuchMethodException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SecurityException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IllegalArgumentException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (InvocationTargetException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	}
	
	public String del() {
		picturesService.delPicture(pictures.getPicId());
		return "del";
	}
	
	public String Img() {
		Business bus = (Business) ActionContext.getContext().getSession().get("store");
		List<Pictures> pics = picturesService.queryByOtherId(bus.getBusId());
		return "Img";
	}
	

	public PicturesService getPicturesService() {
		return picturesService;
	}

	public void setPicturesService(PicturesService picturesService) {
		this.picturesService = picturesService;
	}

}
