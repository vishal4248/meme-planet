package com.worldmeme.worldmeme.models;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Request {
    private String memeOwner;
    private String memeCaption;
    private String memeImgUrl;
}
