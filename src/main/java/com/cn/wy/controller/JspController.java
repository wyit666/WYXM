package com.cn.wy.controller;

import com.cn.wy.entity.Permission;
import com.cn.wy.entity.User;
import com.cn.wy.service.JspService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/jsp")
public class JspController {

    @Autowired
    private JspService jspService;
    @Autowired
    private HttpSession session;

    @GetMapping("/login")
    public String Login(){
        return "login";
    }

    @GetMapping("/index")
    public String Index(){
        return "view/index";
    }

    @GetMapping("/head")
    public ModelAndView Head(){
        ModelAndView modelAndView = new ModelAndView();
        try {
            User user = (User) session.getAttribute(session.getId());
            modelAndView.addObject("user", user);
            modelAndView.setViewName("view/head");
        }catch (Exception e){
            System.out.println(e);
        }
        return modelAndView;
    }

    @GetMapping("/left")
    public ModelAndView Left(){
        ModelAndView modelAndView = new ModelAndView();
        try {
            User user = (User) session.getAttribute(session.getId());
            if(user!=null){
                List<Permission> permissions = jspService.selUserPermission(user.getId());
                modelAndView.addObject("permissions", permissions);
            }
            modelAndView.setViewName("view/left");
        }catch (Exception e){
            System.out.println(e);
        }
        return modelAndView;
    }

    @GetMapping("/main")
    public String Main(){
        return "view/main";
    }
}
