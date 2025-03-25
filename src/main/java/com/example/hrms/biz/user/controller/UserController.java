package com.example.hrms.biz.user.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {

    @RequestMapping("")
    public String openUserView(Model model, HttpSession session) {
        if (session.getAttribute("user") == null) {
            return "redirect:/users/login"; // Nếu session hết hạn, chuyển về login
        }
        return "user";
    }

    @RequestMapping("/login")
    public String loginPage() {
        return "login";
    }

    @RequestMapping("/create")
    public String createAccountPage(HttpSession session) {
        if (session.getAttribute("user") == null) {
            return "redirect:/users/login";
        }
        return "createaccount";
    }

    @RequestMapping("/home")
    public String homePage(Model model, HttpSession session) {
        if (session.getAttribute("user") == null) {
            return "redirect:/users/login";
        }
        return "index";
    }

    @GetMapping("/update/{username}")
    public String updateAccountPage(HttpSession session) {
        if (session.getAttribute("user") == null) {
            return "redirect:/users/login";
        }
        return "updateaccount";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate(); // Hủy session khi logout
        }
        return "redirect:/users/login";
    }
}
