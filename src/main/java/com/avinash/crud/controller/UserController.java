package com.avinash.crud.controller;

import com.avinash.crud.dao.UserDao;
import com.avinash.crud.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {


    @Autowired
    UserDao dao;

    @Autowired
    HttpSession session;

    @RequestMapping(value = {"/", "/login"})
    public String index()
    {
        return "login";
    }



    @RequestMapping("/home")
    public String home(@RequestParam("username") String username, @RequestParam("password") String password)
    {

        User user = dao.findCustomerByUsernameAndHash(username, password);
        if( user !=null) {
            session.setAttribute("user", username);
            return "redirect:profile";
        }
        else
            return "login";
    }

    @RequestMapping("/register")
    public String register()
    {
        return "register";
    }

    @RequestMapping("/registered")
    public String register(User user)
    {
        dao.save(user);
        return "login";
    }

    @RequestMapping("/delete")
    public String delete()
    {
        String username = (String)session.getAttribute("user");
        User user = dao.findByUsername(username);
        dao.delete(user);
        session.invalidate();
        return "login";
    }

    @RequestMapping("/logout")
    public String logout()
    {
        session.invalidate();
        return "login";
    }

    @RequestMapping("/profile")
    public ModelAndView profile()
    {
        ModelAndView mav = new ModelAndView();
        String username = (String)session.getAttribute("user");
        System.out.println(username);
        User user = dao.findByUsername(username);
        System.out.print(user);
        mav.addObject("p", user);
        mav.setViewName("profile");
        return mav;
    }

    @RequestMapping(value = "/profileUpdate", method = RequestMethod.POST)
    public ModelAndView profileUpdate(User user)
    {
        String username = (String)session.getAttribute("user");
        User existing = dao.findByUsername(username);
        if(existing!=null){
            existing.setUsername(user.getUsername());
            existing.setHash(user.getHash());
            existing.setFirstName(user.getFirstName());
            existing.setLastName(user.getLastName());
            existing.setAddress(user.getAddress());
        }
        session.setAttribute("username", username);
        dao.save(existing);
        ModelAndView mav = new ModelAndView();
        mav.addObject("p", user);
        mav.setViewName("profile");
        return mav;
    }
}
