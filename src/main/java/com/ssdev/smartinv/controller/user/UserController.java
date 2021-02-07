package com.ssdev.smartinv.controller.user;

import com.ssdev.smartinv.dto.UserDTO;
import com.ssdev.smartinv.model.user.Role;
import com.ssdev.smartinv.service.user.UserService;
import com.ssdev.smartinv.util.common.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create(Model model) {
        Map<String, String> selectItems = CommonUtil.prepareMapForSelect(Role.class);
        model.addAttribute("selectItems", selectItems);
        model.addAttribute("user", new UserDTO());
        return "user/create";
    }
}
