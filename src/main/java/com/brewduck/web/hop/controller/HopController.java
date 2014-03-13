package com.brewduck.web.hop.controller;

import com.brewduck.web.domain.Hop;
import com.brewduck.web.hop.service.HopService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * <pre>
 * 맥주 홉 Controller.
 * </pre>
 *
 * @author jaeger
 * @version 1.0, 2014.02.14
 */
@Controller
@RequestMapping(value = "/hop")
public class HopController {
    private static final Logger logger = LoggerFactory.getLogger(HopController.class);

    /**
     * HopService Dependency Injection.
     */
    @Autowired
    private HopService hopService;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String selectRecipeDetail(Model model) {

        logger.info("hops main : {}");

        return "hop/index";
    }

    /**
     * <pre>
     * 맥주 홉 목록 조회.
     * </pre>
     *
     * @param model Model
     * @return 맥주 홉 목록
     */
    @ResponseBody
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Hop> HopList(Model model) {
        logger.info("Hop List");
        Hop hop = new Hop();

        // 맥주 홉 목록 조회
        List<Hop> list = hopService.selectHopList(hop);
        logger.info("Hop List Size : {}", list.size());

        return list;
    }

    /**
     * <pre>
     * 맥주 홉 상세 조회.
     * </pre>
     *
     * @param model Model
     * @param name 맥주 홉 영문명
     * @return 맥주 홉 상세.
     */
    @ResponseBody
    @RequestMapping(value = "/detail/{name}", method = RequestMethod.GET)
    // public String HopDetail(Model model, @PathVariable("name") String name) {
    public Hop HopDetail(Model model, @PathVariable("name") String name) {
        logger.info("Hop Name : {}", name);

        Hop hop = new Hop();
        hop.setName(name);

        // 맥주 홉 상세 조회
        Hop hopDetail = hopService.selectHopDetail(hop);

        // model.addAttribute("Hop", Hop);
        // return "/Hop/HopView";

        return hopDetail;
    }

    /**
     * <pre>
     * 맥주 홉 저장.
     * </pre>
     *
     * @param model Model
     * @param name 맥주 홉 영문명
     * @param paramHop 맥주 홉 VO
     * @return 맥주 홉 저장 여부
     */
    @ResponseBody
    @RequestMapping(value = "/insert/{name}", method = RequestMethod.POST)
    public Hop insertHop(Model model, @PathVariable("name") String name, @RequestBody Hop paramHop) {
        logger.info("Insert Hop : {}", paramHop);

        // 맥주 홉 저장
        Boolean insertFlag = hopService.insertHop(paramHop);

        // 맥주 홉 저장했는지 성공 세팅
        Hop returnHop = new Hop();
        returnHop.setName(name);
        returnHop.setInsertFlag(insertFlag);

        return returnHop;
    }
    /**
     * <pre>
     * 맥주 홉 수정.
     * </pre>
     *
     * @param model Model
     * @param name 맥주 홉 영문명
     * @param paramHop 맥주 홉 VO
     * @return 맥주 홉 수정 여부
     */
    @ResponseBody
    @RequestMapping(value = "/update/{name}", method = RequestMethod.POST)
    public Hop updateHop(Model model, @PathVariable("name") String name, @RequestBody Hop paramHop) {
        logger.info("Update Hop : {}", paramHop);

        // 맥주 홉 수정
        Boolean updateFlag = hopService.updateHop(paramHop);

        // 맥주 홉 수정했는지 성공 세팅
        Hop returnHop = new Hop();
        returnHop.setName(name);
        returnHop.setUpdateFlag(updateFlag);

        return returnHop;
    }

    /**
     * <pre>
     * 맥주 홉 삭제.
     * </pre>
     *
     * @param model Model
     * @param name 맥주 홉 영문명
     * @param paramHop 맥주 홉 VO
     * @return 맥주 홉 삭제 여부
     */
    @ResponseBody
    @RequestMapping(value = "/delete/{name}", method = RequestMethod.POST)
    public Hop deleteHop(Model model, @PathVariable("name") String name, @RequestBody Hop paramHop) {
        logger.info("Delete Hop : {}", paramHop);

        // 맥주 홉 삭제
        Boolean deleteFlag = hopService.deleteHop(paramHop);

        // 맥주 홉 삭제했는지 성공 세팅
        Hop returnHop = new Hop();
        returnHop.setName(name);
        returnHop.setDeleteFlag(deleteFlag);

        return returnHop;
    }

}

