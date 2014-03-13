package com.brewduck.web.common.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


/**
 * The Class AccountController.
 */
@Controller
@RequestMapping(value = "/common")
public class CommonController {

    private static final Logger logger = LoggerFactory.getLogger(CommonController.class);


    /**
     * 회원 가입 페이지
     *
     * @return
     */
    @RequestMapping(value = "/getBirthYear", method = RequestMethod.GET)
    @ResponseBody
    public List getBirthYear() {
        List birthYearList = null;

        for(int i=1900; i < 2001; i++){
           logger.warn("i = " + i);
            birthYearList.add(i, "1");

        }

        return birthYearList;
    }



}
