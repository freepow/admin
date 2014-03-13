package com.nanooda.framework.upload;

/**
 * Created with IntelliJ IDEA.
 * User: hukoru
 * Date: 13. 8. 19
 * Time: 오후 1:53
 * To change this template use File | Settings | File Templates.
 */

import com.nanooda.framework.ajax.AjaxUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/fileupload")
public class FileUploadController {

    private static final Logger logger = LoggerFactory.getLogger(FileUploadController.class);

    @ModelAttribute
    public void ajaxAttribute(WebRequest request, Model model) {
        model.addAttribute("ajaxRequest", AjaxUtils.isAjaxRequest(request));
    }

    @RequestMapping(method= RequestMethod.GET)
    public void fileUploadForm() {
    }

    @RequestMapping(method= RequestMethod.POST)
    public String processUpload(@RequestParam MultipartFile file, Model model) throws IOException {
        logger.warn("### 파일업로드 페이지");
        logger.warn("File " + file.getOriginalFilename());
        String fileName = file.getOriginalFilename();
        file.transferTo(new File("C:/upload/"+fileName));

        model.addAttribute("message", "File '" + file.getOriginalFilename() + "' uploaded successfully");
        return "redirect:/profile/index";
    }

}