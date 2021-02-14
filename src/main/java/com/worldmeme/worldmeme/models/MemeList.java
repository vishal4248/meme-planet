package com.worldmeme.worldmeme.models;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class MemeList {

    private List<Meme> memeList;

    public MemeList() {
        memeList = new ArrayList<>();
    }
}
