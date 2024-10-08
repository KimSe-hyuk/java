package com.example.tobi.announcement.dto;


import com.example.tobi.announcement.model.Post;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostCreateRequestDTO {
    private Long id;
    private String title;
    private String content;
    private String author;
    private Long authorid;

    public Post toPost(){
        return Post.builder()
                .title(title)
                .content(content)
                .author(author)
                .authorid(authorid)
                .build();
    }


}
