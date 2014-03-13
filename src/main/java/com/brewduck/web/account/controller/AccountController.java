package com.brewduck.web.account.controller;

import com.brewduck.framework.crypto.SimpleCrypto;
import com.brewduck.framework.security.LoginAuthorityType;
import com.brewduck.framework.security.UserAuthenticationSuccessHandler;
import com.brewduck.web.account.service.AccountService;
import com.brewduck.web.domain.Account;
import com.brewduck.web.domain.User;
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
@RequestMapping(value = "/account")
public class AccountController {

    private static final Logger logger = LoggerFactory.getLogger(AccountController.class);
    private static String ENABLE  = "ENABLE";   // 계정 활성화
    private static String DISABLE = "DISABLE";  // 계정 비활성화

    @Autowired
    private AccountService accountService;

    @Autowired
    @Qualifier(value = "authenticationManager")
    private AuthenticationManager authenticationManager;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public LoginStatus getStatus() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null && !auth.getName().equals("anonymousUser") && auth.isAuthenticated()) {
            return new LoginStatus(true, auth.getName());
        } else {
            return new LoginStatus(false, null);
        }
    }

    @RequestMapping(value = "/userAuthenticate", method = RequestMethod.POST)
    @ResponseBody
        public LoginStatus login(@RequestParam("j_username") String name,
                             @RequestParam("j_password") String password) {

        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(name, password);

        logger.warn("name : " + name);
        logger.warn("password : " + password);

        User details = new User();
        token.setDetails(details);

        try {
            Authentication auth = authenticationManager.authenticate(token);
            SecurityContextHolder.getContext().setAuthentication(auth);
            return new LoginStatus(auth.isAuthenticated(), auth.getName());
        } catch (BadCredentialsException e) {
            return new LoginStatus(false, null);
        }
    }

    public class LoginStatus {

        private final boolean loggedIn;
        private final String username;

        public LoginStatus(boolean loggedIn, String username) {
            this.loggedIn = loggedIn;
            this.username = username;
        }

        public boolean isLoggedIn() {
            return loggedIn;
        }

        public String getUsername() {
            return username;
        }
    }

    /**
     * 회원 가입 페이지
     *
     * @return
     */
    @RequestMapping(value = "/signin", method = RequestMethod.GET)
    public String signin(Model model) {
        logger.debug("회원 가입 페이지");

        Account account = new Account();

        model.addAttribute("account", account);

        return "account/signin";
    }

    /**
     * 회원 가입 처리
     *
     * @param account
     * @param result
     * @param model
     * @return
     */
    @RequestMapping(value = "/join", method = RequestMethod.POST)
    public String join(@ModelAttribute @Valid Account account,
                       BindingResult result,
                       // RedirectAttributes redirectAttributes,
                       Model model) {
        // 필수값 미입력시 가입 페이지로 전환
        if (result.hasErrors()) {
            logger.debug("가입 실패 : " + account.toString());
            return "account/signin";
        }

        int insertCount = accountService.insertAccount(account);

        int duplicateEmail = -99;
        if (insertCount == duplicateEmail) {
            logger.error("동일한 이메일이 존재합니다.");
            model.addAttribute("message", "동일한 이메일이 존재합니다.");
            return "account/signin";
        }
        if (insertCount == 0) {
            logger.error("회원 가입 중 저장이 실패하였습니다.");
            model.addAttribute("message", "회원 가입 중 저장이 실패하였습니다.");
            return "account/signin";
        }

        model.addAttribute("account", account);

        // TODO -> 회원 가입 후 브라우저 URL 주소 변환 안되고 있어서 아래와 같이 수정 필요
        // 1. RedirectAttributes
        // redirectAttributes.addFlashAttribute("account", account);

        // 2.1 RequestContextUtils를 이용하여 FlashMap에 "message" 값을 저장
        // FlashMap fm = RequestContextUtils.getOutputFlashMap(request);
        // fm.put("message", "update successed");

        // 2.2 FlashMap에 저장된 message 값을 꺼내옴
        // Map<String, ?> fm = RequestContextUtils.getInputFlashMap(request);
        // if (fm != null) {
        //    String message = (String) fm.get("message");
        // }

        return "redirect:/account/confirm";
    }

    /**
     * 로그인 페이지
     *
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        logger.debug("### 로그인 페이지");
        return "account/login";
    }

    /**
     * 가입 완료 페이지
     *
     * @return
     */
    @RequestMapping(value = "/confirm", method = RequestMethod.GET)
    public String confirm() {
        logger.debug("### 가입 완료 페이지");
        return "account/confirm";
    }

    /**
     * 로그아웃
     *
     * @return
     */
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout() {
        logger.debug("### 로그아웃");
        return "account/logout";
    }

    /**
     * 로그인 인증
     *
     * @param request
     * @param response
     * @param email
     * @param password
     * @throws java.io.IOException
     * @throws javax.servlet.ServletException
     */
    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    private void login(HttpServletRequest request,
                       HttpServletResponse response,
                       String email,
                       String password) throws IOException, ServletException {

        logger.warn("@@@@@@@@@@@@@@@@@@@@@@@@@");

        logger.warn("로그인 인증 프로세스 시작");
        logger.warn("username : " + email);
        logger.warn("password : " + password);

        // 계정과 암호로 토큰 생성
        UsernamePasswordAuthenticationToken authRequest =
                        new UsernamePasswordAuthenticationToken(email, password);
        // 인증
        Authentication authentication = authenticationManager.authenticate(authRequest);

        // 세션에 저장
        SecurityContext securityContext = new SecurityContextImpl();
        securityContext.setAuthentication(authentication);
        SecurityContextHolder.setContext(securityContext);

        HttpSession session = request.getSession();
        session.setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY, securityContext);

        // 로그인 성공 처리
        UserAuthenticationSuccessHandler handler = new UserAuthenticationSuccessHandler();
        handler.onAuthenticationSuccess(request, response, authentication);
    }

    /**
     * 이메일 인증키로 계정 활성화
     *
     * @param model
     * @param authKey
     * @return
     */
    @RequestMapping(value = "/activation/{authKey}", method = RequestMethod.GET)
    public String activation(Model model,
                             @PathVariable("authKey") String authKey) {
        int result = 0;
        String userId = null;

        try {
            // authKey(userId) 복호화
            userId = SimpleCrypto.decrypt(SimpleCrypto.seed, authKey);
            logger.debug("userId : " + userId);
        } catch (Exception e) {
            logger.error("이메일 인증키 복호화를 실패하였습니다.", e);
            result = -1;
        }

        Account account = new Account();
        account.setId( Integer.parseInt(userId) );
        account.setAuthority(LoginAuthorityType.ROLE_USER.name());    // ROLE_USER
        account.setActivation(ENABLE);    // 계정 활성화(ENABLE)

        // UserId로 회원 존재하는 체크
        Account currentAccount = accountService.selectAccount(account);

        // 회원이 존재하지 않으면 가입 페이지로 이동
        if (currentAccount == null) {
            return "redirect:/account/signin";
        }

        // 회원이 존재하면 userId로 해당 계정 활성화 업데이트
        result = accountService.updateAccount(account);

        if (result == -1) {
            model.addAttribute("message", "이메일 인증키 복호화를 실패하였습니다.");
        } else if (result == 0) {
            model.addAttribute("message", "회원 정보 수정이 실패하였습니다.");
        }

        return "redirect:/account/login";
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Account test() {
        logger.warn("start of json");
        Account account = new Account();
        account.setEmail("hukoru@naver.com");

        Account responseAccount = accountService.selectAccount(account);
        logger.debug("Response Account : " + responseAccount);

        return responseAccount;
    }

    @RequestMapping(value = "/test", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Account test(@RequestBody Account requestAccount) {
        logger.debug("### Request Account : " + requestAccount);

        return requestAccount;
    }

}
