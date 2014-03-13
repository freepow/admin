package com.brewduck.web;

import com.brewduck.framework.security.AuthenticationUtils;
import com.brewduck.web.domain.Account;
import com.brewduck.web.user.service.UserService;
import com.brewduck.web.account.service.AccountService;
import com.brewduck.web.common.service.CommonService;
import com.brewduck.web.profile.service.ProfileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


/**
 * The Class AccountController.
 */
@Controller
public class HomeController {

    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    private ProfileService profileService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private UserService userService;

    @Autowired
    private CommonService commonService;


    /**
     * 회원 가입 페이지
     *
     * @return
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Model model,
                       HttpServletRequest request) {
        logger.warn("메인 페이지");

        Account account = AuthenticationUtils.getUser();
        logger.warn("### Id    : {}", account.getId());
        logger.warn("### Name  : {}", account.getName());
        logger.warn("### Email : {}", account.getEmail());
        logger.warn("### Password   : {}", account.getPassword());
        logger.warn("### Activation : {}", account.getActivation());
        logger.warn("### Authority  : {}", account.getAuthority());

        model.addAttribute("account", account);

        return "home";
    }

}
