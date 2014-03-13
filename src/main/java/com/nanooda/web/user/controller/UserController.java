package com.nanooda.web.user.controller;

import com.nanooda.web.domain.User;
import com.nanooda.web.user.service.UserService;
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
 * The Class UserController.
 */
@Controller
public class UserController {

	/** The Constant logger. */
	private static final Logger logger = LoggerFactory
			.getLogger(UserController.class);

	@Autowired
	private UserService userService;
	
	/**
	 * Gets the all.
	 * 
	 * @param map 
	 * @return the all
	 * @throws Throwable 
	 */
	@RequestMapping(value = "/user/getAll", method = RequestMethod.GET)
	public final void getAll(final ModelMap map,
			final HttpServletRequest request) throws Throwable {
		List<User> users = this.userService.getSelectOne(new User());
		
		map.put("users", users);
	}
}
