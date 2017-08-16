package com.linestore.action;

import java.util.List;
import java.util.Map;

import com.linestore.service.TagService;
import com.linestore.vo.Tag;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;


public class TagAction extends ActionSupport implements ModelDriven<Tag> {
	
	private Tag tag = new Tag();
	
	private TagService tagService;
	
	private Map<String, Object> request;
	
	private Tag tagResalut;

	@Override
	public Tag getModel() {
		return tag;
	}
	
	public String tag() {
		List<Tag> tags = tagService.queryAll();
		request = (Map<String, Object>) ActionContext.getContext().get("request");
		request.put("tags", tags);
		return "gotoCusLabel";
	}
	
	public String selectAll(){
		tag();
		return "selectAll";
	}
	
	public String add(){
		
		return "add";
	}
	
	public String save(){
		tagService.save(tag);
		return "select";
	}
	
	public String edit(){
		tagResalut = tagService.selectById(tag.getTagId());
		request = (Map<String, Object>) ActionContext.getContext().get("request");
		request.put("tag", tagResalut);
		return "edit";
	}
	
	public String update(){
		tagService.update(tag);
		return "select";
	}

	public String delete(){
		tagService.delete(tag.getTagId());
		return "select";
	}
	
	public TagService getTagService() {
		return tagService;
	}

	public void setTagService(TagService tagService) {
		this.tagService = tagService;
	}
	
}
