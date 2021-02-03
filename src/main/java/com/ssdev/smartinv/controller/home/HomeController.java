package com.ssdev.smartinv.controller.home;

import com.ssdev.smartinv.dto.AuthenticationDTO;
import com.ssdev.smartinv.model.user.User;
import com.ssdev.smartinv.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "home/index";
    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login(@ModelAttribute("message") String message, HttpServletRequest request) {
        request.setAttribute("message", message);
        return "home/login";
    }

    @RequestMapping(value = "authenticate", method = RequestMethod.POST)
    public RedirectView authenticate(@ModelAttribute AuthenticationDTO authenticationDTO, HttpServletRequest request, RedirectAttributes attributes) {
        User user = this.userService.authenticateUser(authenticationDTO);
        if(user != null) {
            this.userService.doAfterLoginUserTask(user);
            return new RedirectView(request.getContextPath());
        }
        else {
            attributes.addFlashAttribute("message", "Wrong email or password");
            return new RedirectView("login");
        }
    }

    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public RedirectView logout(HttpServletRequest request, RedirectAttributes attributes) {
        this.userService.logout(request);
        attributes.addFlashAttribute("message", "Log out successful");
        return new RedirectView("login");
    }
}
