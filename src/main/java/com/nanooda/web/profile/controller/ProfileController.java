package com.nanooda.web.profile.controller;

import com.nanooda.framework.security.AuthenticationUtils;
import com.nanooda.web.account.service.AccountService;
import com.nanooda.web.common.service.CommonService;
import com.nanooda.web.domain.Account;
import com.nanooda.web.domain.Common;
import com.nanooda.web.domain.Profile;
import com.nanooda.web.domain.User;
import com.nanooda.web.profile.service.ProfileService;
import com.nanooda.web.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Enumeration;
import java.util.List;


// The Class ProfileController.
@Controller
@RequestMapping(value = "/profile")
public class ProfileController {

    // The Constant logger.
    private static final Logger logger = LoggerFactory.getLogger(ProfileController.class);

    @Autowired
    private ProfileService profileService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private UserService userService;

    @Autowired
    private CommonService commonService;


    /**
     * 프로필 메인 페이지
     *
     * @param model
     * @param request
     */
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public void index(@ModelAttribute Profile profile, Model model,
                      HttpServletRequest request) {

        Account account = AuthenticationUtils.getUser();
        logger.warn("### Id    : {}", account.getId());
        logger.warn("### Name  : {}", account.getName());
        logger.warn("### Email : {}", account.getEmail());
        logger.warn("### Password   : {}", account.getPassword());
        logger.warn("### Activation : {}", account.getActivation());
        logger.warn("### Authority  : {}", account.getAuthority());


    }

    /**
     * 프로필 수정 페이지
     *
     * @param model
     * @param request
     */
    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public void update(@ModelAttribute Profile profile, Model model,
                      HttpServletRequest request) {

                //List<Common> genderList = commonService.selectGenderList();
        //request.setAttribute("userGender", genderList);

        profileService.checkProfile();  //프로필이 없으면 프로필 생성
        userService.checkUser();        //유저정보 없으면 기초정보 생성

        int accountId = accountService.selectAccountId(); //접속 중인 ID

        //TODO : User 서비스 공통으로 뺼 것
        User user = new User();
        user.setAccountId(accountId);
        user = userService.selectUser(user);

        String userName = user.getName();

        profile.setUserName(userName);      //이름
        profile.setUserHeight(user.getHeight()+"");       //키
        profile.setUserWeight(user.getWeight()+"");       //몸무게
        profile.setUserGender(user.getGender()+"");          //성별
        model.addAttribute("profile", profile);


        //TODO : view(profile/index)단에서 조회
    }

    @RequestMapping(value = "/update_bio", method = RequestMethod.POST)
    public String join(@ModelAttribute @Valid Profile profile,
                       BindingResult result,
                       Model model) {

        //TODO : user 기본정보 저장

        int accountId = accountService.selectAccountId(); //접속 중인 ID

        String userHeight =  profile.getUserHeight().replaceAll("cm","");
        String userWeight =  profile.getUserWeight().replaceAll("kg","");

        User user = new User();
        user.setAccountId(accountId);
        user.setGender(Integer.parseInt(profile.getUserGender()));
        user.setHeight(Integer.parseInt(userHeight));
        user.setWeight(Integer.parseInt(userWeight));
        user.setBirthYear(profile.getUserBirthYear());
        user.setBirthMonth(profile.getUserBirthMonth());
        user.setBirthDay(profile.getUserBirthDay());

        int updateCnt = userService.updateUser(user);

        //TODO : profile 기본정보 저장

        logger.warn("################### updateCnt" + updateCnt);
        userService.updateUser(user);
        return "redirect:/profile/update";
    }

}
