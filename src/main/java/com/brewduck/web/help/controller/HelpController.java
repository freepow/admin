package com.brewduck.web.help.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * The Class CompanyController.
 */
@Controller
@RequestMapping(value = "/help")
public class HelpController {

	/** The Constant logger. */
	private static final Logger logger = LoggerFactory
			.getLogger(HelpController.class);


    /**
     *
     * 자주하는 질문	help_faq.html
     * 1:1 질의응답/제안
     * 이용설명서	help_guide.html
     * 가이드라인	help_guideline.html
     */


	/**
	 * 자주하는 질문
	 */
	@RequestMapping(value = "/faq", method = RequestMethod.GET)
    public String faq() {
        return "/help/faq";
    }

    /**
     * 1:1 질의응답/제안
     */
    @RequestMapping(value = "/qna", method = RequestMethod.GET)
    public String qna() {
        return "/help/qna";
    }

    /**
     * 이용설명서
     */
    @RequestMapping(value = "/guide", method = RequestMethod.GET)
    public String guide() {
        return "/help/guide";
    }

    /**
     * 가이드라인
     */
    @RequestMapping(value = "/guideline", method = RequestMethod.GET)
    public String policiesTerms() {
        return "/help/guideline";
    }

}
