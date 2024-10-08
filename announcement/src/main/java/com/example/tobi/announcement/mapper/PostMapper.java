package com.example.tobi.announcement.mapper;

import com.example.tobi.announcement.model.Post;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PostMapper {
    void insertPost(Post post);

    void deletePost(Long id);

    void updatePost(Post post);

    List<Post> getAllposts();
    List<Post> getPostByFind(String search);
    Post getOnePost(Long id);

}
