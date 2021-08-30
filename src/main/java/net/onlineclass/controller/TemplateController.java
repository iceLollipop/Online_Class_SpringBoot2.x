package net.onlineclass.controller;

import net.onlineclass.config.WXConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("template")
public class TemplateController {
    @Autowired
    private WXConfig wxConfig;

    @GetMapping("freemaker")
    public String indexFreemaker(ModelMap modelMap){
        modelMap.addAttribute("setting",wxConfig);
        return "user/fm/index";
    }

    @GetMapping("thymeleaf")
    public String indexThymeleaf(ModelMap modelMap){
        modelMap.addAttribute("setting",wxConfig);
        return "thymeleaf/index";
    }
}
