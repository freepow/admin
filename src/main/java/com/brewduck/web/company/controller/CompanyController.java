package com.brewduck.web.company.controller;

import com.brewduck.web.company.service.CompanyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * The Class CompanyController.
 */
@Controller
@RequestMapping(value = "/company")
public class CompanyController {

	/** The Constant logger. */
	private static final Logger logger = LoggerFactory
			.getLogger(CompanyController.class);

	@Autowired
	private CompanyService companyService;

    /**
     *
     * 언론보도	company_news.html
     * 후원 및 광고	company_sponsor.html
     * 나누다 소개	company_introduce.html
     * 이용약관	policies_terms.html
     * 개인정보처리방침	policies_privacy.html
     */


	/**
	 * 언론보도
	 */
	@RequestMapping(value = "/news", method = RequestMethod.GET)
    public String news() {
        return "/company/news";
    }

    /**
     * 후원 및 광고
     */
    @RequestMapping(value = "/sponsor", method = RequestMethod.GET)
    public String sponsor() {
        return "/company/sponsor";
    }

    /**
     * 나누다 소개
     */
    @RequestMapping(value = "/introduce", method = RequestMethod.GET)
    public String introduce() {
        return "/company/introduce";
    }

    /**
     * 이용약관
     */
    @RequestMapping(value = "/policies_terms", method = RequestMethod.GET)
    public String policiesTerms() {
        return "/company/policies_terms";
    }

    /**
     * 개인정보처리방침
     */
    @RequestMapping(value = "/policies_privacy", method = RequestMethod.GET)
    public String policiesPrivacy() {
        return "/company/policies_privacy";
    }
}
