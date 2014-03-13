package com.nanooda.framework.util.ajax;

import flexjson.JSONSerializer;
import org.springframework.web.servlet.view.AbstractView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;


public class AjaxView extends AbstractView {
	
	public AjaxView() {
		setContentType("text/plain; charset=utf-8");
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	protected void renderMergedOutputModel(Map map, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		JSONSerializer serializer = new JSONSerializer();         
		String jsonString = serializer.serialize(map);      
	
		response.getOutputStream().write( jsonString.getBytes() );
	}

}
