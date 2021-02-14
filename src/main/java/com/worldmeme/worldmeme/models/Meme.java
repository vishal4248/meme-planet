package com.worldmeme.worldmeme.models;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;


@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Meme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String memeOwnerName;

    @Column(nullable = false)
    private String memeCaption;

    @Column(nullable = false)
    private String memeImgUrl;

    @Column(nullable = false)
    private Timestamp memePublishedAt;
}
