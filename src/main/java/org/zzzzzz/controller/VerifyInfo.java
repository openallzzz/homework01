package org.zzzzzz.controller;

import com.alibaba.fastjson.JSON;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zzzzzz.pojo.User;
import org.zzzzzz.service.UserService;
import org.zzzzzz.validator.UserValidator;

import javax.annotation.Resource;
import javax.validation.Valid;

@Controller
@RequestMapping("/students")
public class VerifyInfo {

    private static final Log logger = LogFactory.getLog(VerifyInfo.class);

    @Autowired
    private UserService userService;

    @Resource
    private UserValidator userValidator;

    @RequestMapping("/input")
    public String input(Model model) {
        model.addAttribute("user", new User());
        return "userinfo";
    }

    @RequestMapping("/save")
    public String save(@Valid User user, BindingResult result, Model model) {
        this.userValidator.validate(user, result);

        if(result.hasErrors()) {
            return "userinfo"; // 存在错误，显示在输入信息的页面中
        }

        userService.save(user);
        logger.info("添加成功");
        model.addAttribute("userList", userService.list());

        return "success";
    }

    @RequestMapping("/input-to-json")
    public String inputToJSON(Model model) {
        model.addAttribute("user", new User());
        return "info";
    }

    @RequestMapping("/show")
    public String show(Model model, User user) {

        String jsonString = JSON.toJSONString(user);

        model.addAttribute("data", jsonString);

        return "json-data";
    }

}
