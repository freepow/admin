package com.nanooda.web;

import com.nanooda.framework.crypto.SimpleCrypto;
import com.nanooda.framework.security.AuthenticationUtils;
import com.nanooda.framework.security.LoginAuthorityType;
import com.nanooda.framework.security.UserAuthenticationSuccessHandler;
import com.nanooda.web.account.service.AccountService;
import com.nanooda.web.common.service.CommonService;
import com.nanooda.web.domain.Account;
import com.nanooda.web.domain.User;
import com.nanooda.web.profile.service.ProfileService;
import com.nanooda.web.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.IOException;


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
