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

	public TagService getTagService() {
		return tagService;
	}

	public void setTagService(TagService tagService) {
		this.tagService = tagService;
	}
	
}
