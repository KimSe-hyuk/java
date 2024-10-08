package com.example.tobi.announcement.model;

import com.example.tobi.announcement.dto.PostResponseDTO;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Post {
    private long id;
    private String title;
    private String content;
    private String date;
    private String author;
    private long authorid;

    public PostResponseDTO toPostListResponseDTO(){
        return PostResponseDTO.builder()
                .id(id)
                .title(title)
                .content(content)
                .date(date)
                .author(author)
                .build();
    }
};
