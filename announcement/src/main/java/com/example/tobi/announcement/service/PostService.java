package com.example.tobi.announcement.service;

import com.example.tobi.announcement.dto.PostResponseDTO;
import com.example.tobi.announcement.mapper.PostMapper;
import com.example.tobi.announcement.model.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostMapper postMapper;

    public void insertPost(Post post) {
        postMapper.insertPost(post);
    }
    public List<PostResponseDTO> getAllPosts() {
        List<Post> posts = postMapper.getAllposts();
        return posts.stream().map(Post::toPostListResponseDTO)
                .collect(Collectors.toList());
    }

    public List<PostResponseDTO> getPostByFind(String search) {
        List<Post> posts = postMapper.getPostByFind(search);
        return posts.stream().map(Post::toPostListResponseDTO)
                .collect(Collectors.toList());
    }
    public void deletePost(Long postId) {
        postMapper.deletePost(postId);
    }
    public void updatePost(Post post) {
        postMapper.updatePost(post);
    }


    public PostResponseDTO getOnePost(Long id) {
        Post post= postMapper.getOnePost(id);
        return post.toPostListResponseDTO();
    }

    public String checkUserPost(Long id) {
        return postMapper.getOnePost(id).getAuthor();
    }
}
