package com.attractor.controller;


import com.attractor.dto.RegisUser;
import com.attractor.repository.UserRepository;
import com.attractor.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.security.Principal;


@Controller
@RequiredArgsConstructor
@RequestMapping()
public class UserController {
    private final UserService service;
    private final UserRepository repository;


    private final static String CAPTCHA_URL = "https:/www.google.com/recaptcha/api/siteverify";
    @Autowired
    private RestTemplate restTemplate;


    @GetMapping("/profile")
    public String pageCustomerProfile(Model model, Principal principal)
    {
        var user = service.getByEmail(principal.getName());
        model.addAttribute("dto", user);
        return "profile";
    }

    @PreAuthorize("hasAuthority('Admin')")
    @GetMapping("/register")
    public String pageRegisterCustomer(Model model) {

        if (!model.containsAttribute("dto")) {
            model.addAttribute("dto", new RegisUser());
        }

        return "register";
    }

    @PreAuthorize("hasAuthority('Admin')")
    @PostMapping("/register")
    public String registerPage(@Valid RegisUser customerRequestDto,
                               BindingResult validationResult,
                               RedirectAttributes attributes,
                               Model model) {

        attributes.addFlashAttribute("dto", customerRequestDto);

        if (validationResult.hasFieldErrors()) {
            attributes.addFlashAttribute("errors", validationResult.getFieldErrors());
            return "redirect:/register";
        }

        service.register(customerRequestDto);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String loginPage(@RequestParam(required = false, defaultValue = "false") Boolean error, Model model) {

        model.addAttribute("error", error);
        return "login";
    }

    @RequestMapping(value = {"", "/showTask"})
    public String logout(HttpServletRequest request) {
        SecurityContextHolder.clearContext();
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        return "redirect:" + "/showTask";
    }







}








