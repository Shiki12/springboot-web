package com.shiki.springbootweb.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller

@RequestMapping("/login")
public class LoginController {

    @RequestMapping("/user")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Model model, HttpSession session){

        if (username.equals("admin")&&password.equals("123456")){

            session.setAttribute("loginUser",username);
            return "redirect:/main.html";
        }
        else {
            model.addAttribute("msg","用户名或者密码错误");
            return "index";
        }
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:index.html";
    }

}
