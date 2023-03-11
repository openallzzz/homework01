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

    /**
     * 格式1对应的输入控制
     * @param model 使用model实现数据绑定
     * @return 跳转到信息输入页面
     */
    @RequestMapping("/input")
    public String input(Model model) {
        model.addAttribute("user", new User());
        return "userinfo";
    }

    /**
     * 格式2对应的输入控制
     * @param model 使用model实现数据绑定
     * @return 跳转到信息输入页面
     */
    @RequestMapping("/input-to-json")
    public String inputToJSON(Model model) {
        model.addAttribute("user", new User());
        return "info"; // 返回到输入页面
    }

    /**
     * 将学生信息保存至数组中（模拟的dao层）
     * @param user 封装的用户信息
     * @param result 保存相关字段错误的信息
     * @return 提交url : context-path/success，进行控制
     */
    @RequestMapping("/save")
    public String save(@Valid User user, BindingResult result) {
        this.userValidator.validate(user, result);

        if(result.hasErrors()) {
            return "userinfo"; // 存在错误，显示在输入信息的页面中
        }

        userService.save(user);
        logger.info("添加成功");
        return "redirect:success";
    }

    @RequestMapping("/save-of-one")
    public String saveOfOne(@Valid User user, BindingResult result, Model model) {
        this.userValidator.validate(user, result);

        if(result.hasErrors()) {
            return "info"; // 存在错误，显示在输入信息的页面中
        }

        userService.save(user);
        logger.info("添加成功");

        return show(model, user);
    }

    @RequestMapping("/success")
    public String showInfo(Model model) {
        model.addAttribute("userList", userService.list());
        return "success";
    }


    @RequestMapping("/show")
    public String show(Model model, User user) {

        String jsonString = JSON.toJSONString(user);

        model.addAttribute("data", jsonString);

        return "json-data";
    }

    @RequestMapping("/clear")
    public String removeAll() {
        userService.removeAll();
        return "redirect:/students/success";
    }

}
