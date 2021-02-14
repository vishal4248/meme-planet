package com.worldmeme.worldmeme.controllers;


import com.worldmeme.worldmeme.models.Meme;
import com.worldmeme.worldmeme.models.MemeList;
import com.worldmeme.worldmeme.models.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;
import java.util.List;


@Controller
public class HomeController {

    @GetMapping("/")
    public ModelAndView showHomePage(ModelAndView homeView) {

        String memeURI = "http://localhost:8081/getMemes";
        RestTemplate restTemplate = new RestTemplate();
        MemeList memeList = restTemplate.getForObject(memeURI, MemeList.class);

        if (memeList==null) {
            homeView.addObject("Memes",null);
        } else {
            Collections.reverse(memeList.getMemeList());
            homeView.addObject("Memes",memeList.getMemeList());
        }
        homeView.setViewName("index");

        return homeView;
    }

    @GetMapping("/createPost")
    public String createPost(Model model) {
        model.addAttribute("request",new Request());
        return "new_post_details";
    }


}
