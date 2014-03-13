package com.brewduck.web.discover.controller;

import com.brewduck.web.domain.Discover;
import com.brewduck.web.discover.service.DiscoverService;
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
 * The Class DiscoverController.
 */
@Controller
public class DiscoverController {

	/** The Constant logger. */
	private static final Logger logger = LoggerFactory
			.getLogger(DiscoverController.class);

	@Autowired
	private DiscoverService discoverService;
	
	/**
	 * Gets the all.
	 * 
	 * @param map 
	 * @return the all
	 * @throws Throwable 
	 */
	@RequestMapping(value = "/discover/getAll", method = RequestMethod.GET)
	public final void getAll(final ModelMap map,
			final HttpServletRequest request) throws Throwable {
		List<Discover> discovers = this.discoverService.getSelectOne(new Discover());
		
		map.put("discovers", discovers);
	}
}
