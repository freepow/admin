package com.brewduck.web.group.controller;

import com.brewduck.web.domain.Group;
import com.brewduck.web.group.service.GroupService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * The Class GroupController.
 */
@Controller
public class GroupController {

	/** The Constant logger. */
	private static final Logger logger = LoggerFactory
			.getLogger(GroupController.class);

	@Autowired
	private GroupService groupService;
	
	/**
	 * Gets the all.
	 * 
	 * @param map 
	 * @return the all
	 * @throws Throwable 
	 */
	@RequestMapping(value = "/group/getAll", method = RequestMethod.GET)
	public final void getAll(final ModelMap map,
			final HttpServletRequest request) throws Throwable {
		List<Group> groups = this.groupService.getSelectOne(new Group());
		
		map.put("groups", groups);
	}
}
