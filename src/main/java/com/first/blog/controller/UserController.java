package com.first.blog.controller;

import com.first.blog.domain.User;
import com.first.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


/**
 *  UserController
 */
@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    /**
     * 查询所有的用户
     * @param model
     * @return
     */
    @GetMapping
    public ModelAndView list(Model model){
        model.addAttribute("userList",userRepository.listUser());
        model.addAttribute("title","用户管理");
        return new ModelAndView("users/list","userModel",model);
    }

    /**
     * 根据id查询用户
     * @param id
     * @param model
     * @return
     */
    @GetMapping("{id}")
    public ModelAndView userById(@PathVariable("id")Long id, Model model){
        User user = userRepository.getUserById(id);
        model.addAttribute("user",user);
        model.addAttribute("title","查看用户");
        return new ModelAndView("users/view","userModel",model);
    }

    /**
     * 创建表单页面
     * @param model
     * @return
     */
    @GetMapping("/form")
    public ModelAndView createForm(Model model){
        model.addAttribute("user",new User());
        model.addAttribute("title","创建用户");
        ModelAndView mv = new ModelAndView();
        mv.setViewName("users/form");
        mv.addObject("userModel",model);
        return mv;
    }

    @PostMapping
    public ModelAndView saveOrUpdateUser(User user){
        user = userRepository.saveOrUpdateUser(user);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:/users");
        return mv;
    }

    /**
     * 根据id  删除用户
     * @param id
     * @return
     */
    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id")Long id){
        userRepository.deleteUser(id);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:/users");//重定向到list页面
        return mv;
    }

    /**
     * 修改用户
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/modify/{id}")
    public ModelAndView modify(@PathVariable("id")Long id,Model model){
        ModelAndView modelAndView = new ModelAndView();
        User user = userRepository.getUserById(id);
        model.addAttribute("user",user);
        model.addAttribute("title","修改用户");
        modelAndView.setViewName("users/form");
        modelAndView.addObject("userModel",model);
        return modelAndView;
    }

}
