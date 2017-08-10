package com.linestore.action;

import java.lang.reflect.InvocationTargetException;

import com.linestore.service.PicturesService;
import com.linestore.util.ReturnUpdateHql;
import com.linestore.vo.Pictures;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class PicturesAction extends ActionSupport implements ModelDriven<Pictures> {

	private Pictures pictures = new Pictures();
	
	private PicturesService picturesService;
	
	@Override
	public Pictures getModel() {
		return pictures;
	}
	
	public void add() {
		picturesService.addPicture(pictures);
	}
	
	public void update() {
		try {
			String hql = ReturnUpdateHql.ReturnHql(Pictures.class, pictures, pictures.getPicId());
			picturesService.updatePicture(hql);
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
		
	}
	

	public PicturesService getPicturesService() {
		return picturesService;
	}

	public void setPicturesService(PicturesService picturesService) {
		this.picturesService = picturesService;
	}
	
	
	

}
