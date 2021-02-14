package com.worldmeme.worldmeme.controllers;

import com.worldmeme.worldmeme.NotFoundException;
import com.worldmeme.worldmeme.models.Meme;
import com.worldmeme.worldmeme.models.MemeList;
import com.worldmeme.worldmeme.models.Request;
import com.worldmeme.worldmeme.services.MemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import javax.persistence.EntityNotFoundException;
import java.util.List;


@RestController
public class DataController {

    @Autowired
    MemeService memeService;

    @GetMapping("/memes")
    public List<Meme> getMemes() {
        return memeService.getLatestMemes();
    }

    @GetMapping("/getMemes")
    public MemeList findMemes() {
        MemeList memeList = new MemeList();
        memeList.setMemeList(memeService.getLatestMemes());
        return memeList;
    }

    @PostMapping("/memes")
    public RedirectView newPostUpload(Request request) {
        memeService.addNewPost(request);
        return new RedirectView("http://localhost:8081/");
    }

    @GetMapping("/memes/{id}")
    public Object findMeme(@PathVariable("id") Long id) {

        try {
            return memeService.findMeme(id);
        } catch (EntityNotFoundException e) {
            throw new NotFoundException();
        }
    }
}
