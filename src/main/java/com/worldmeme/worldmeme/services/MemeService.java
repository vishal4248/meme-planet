package com.worldmeme.worldmeme.services;

import com.worldmeme.worldmeme.NotFoundException;
import com.worldmeme.worldmeme.models.Meme;
import com.worldmeme.worldmeme.models.Request;
import com.worldmeme.worldmeme.repos.MemeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
public class MemeService {

    @Autowired
    MemeRepository memeRepository;

    public List<Meme> getLatestMemes() {
        return memeRepository.getLatestMemes();
    }

    public void addNewPost(Request request) {

        Meme newMeme = Meme.builder()
                .memeOwnerName(request.getMemeOwner())
                .memeCaption(request.getMemeCaption())
                .memeImgUrl(request.getMemeImgUrl())
                .memePublishedAt(new Timestamp(System.currentTimeMillis()))
                .build();

        memeRepository.save(newMeme);
    }

    public Meme findMeme(Long id) {

        Optional<Meme> optionalMeme = memeRepository.findById(id);

        if(optionalMeme.isPresent())
            return optionalMeme.get();
        else
            throw  new NotFoundException();
    }
}
