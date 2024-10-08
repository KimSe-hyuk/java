package com.example.tobi.announcement.controller;


import com.example.tobi.announcement.dto.MemberResponseDTO;
import com.example.tobi.announcement.dto.PostCreateRequestDTO;
import com.example.tobi.announcement.dto.PostDeleteRequestDTO;
import com.example.tobi.announcement.dto.PostResponseDTO;
import com.example.tobi.announcement.service.PostService;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
@Controller
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {
    private final PostService postService;

    @GetMapping
    public String postList(Model model, RedirectAttributes redirectAttributes) {
        List<PostResponseDTO> posts=  postService.getAllPosts();
        model.addAttribute("posts", posts);
        Object alertMessage = model.getAttribute("alertMessage");
        System.out.println("alertMessage: " + alertMessage);
        return "post-list";
    }
    @PostMapping("/search")
    public String searchPost(
            @RequestParam String searchTerm,
            Model model
    ) {
        List<PostResponseDTO> posts = postService.getPostByFind(searchTerm);
        model.addAttribute("posts", posts);
        return "post-list";
    }

    @GetMapping("/insert")
    public String insertPost(Model model) {
        return "insert-post";
    }
    @PostMapping("/insert")
    public String postInsert(@RequestBody PostCreateRequestDTO request, HttpSession session,RedirectAttributes redirectAttributes) {
        MemberResponseDTO loginUser = (MemberResponseDTO) session.getAttribute("loginUser");
        if(loginUser!=null){
            request.setAuthor(loginUser.getName());
            request.setAuthorid(loginUser.getId());
            postService.insertPost(request.toPost());
            redirectAttributes.addFlashAttribute("alertMessage", "글 작성 성공");
            return "redirect:/post";
        }else {
            redirectAttributes.addFlashAttribute("alertMessage", "로그인 하시오.");
            return "redirect:/users/login";
        }
    }
    @GetMapping("/update/{id}")
    public String postUpdate(@PathVariable("id") Long  postId, Model model,HttpSession session,
                             RedirectAttributes redirectAttributes) {
        if(checkPostWrite(postId, session)){
            PostResponseDTO  post = postService.getOnePost(postId);
            model.addAttribute("posts",post);
            return "update-post";
        }else{
            String alterMessage= session.getAttribute("loginUser")!=null?"로그인 하시오":"작성자가 아님";
            redirectAttributes.addFlashAttribute("alertMessage",alterMessage);
            return "redirect:/users/login";
        }
    }
    @PostMapping("/update")
    public String postUpdate(@RequestBody PostCreateRequestDTO request, HttpSession session,
                             RedirectAttributes redirectAttributes) {
        MemberResponseDTO loginUser = (MemberResponseDTO) session.getAttribute("loginUser");
        request.setAuthor(String.valueOf(loginUser.getId()));
        postService.updatePost(request.toPost());
        redirectAttributes.addFlashAttribute("alertMessage","업데이트 성공");
        return "redirect:/post";
    }
 /*
   @GetMapping("/delete/{id}/{author}")
    public String postDelete(@PathVariable("id") Long postId,
                             @PathVariable("author") Long authorId,
                             Model model,
                             HttpSession session) {
        // 게시물 작성자 확인
        if(checkPostWrite(postId, session)){
            PostResponseDTO post = postService.getOnePost(postId);
            model.addAttribute("posts", post);
            return "redirect:/delete-post"; // 게시물 삭제 페이지로 리다이렉트
        } else {
            return "redirect:/post"; // 작성자가 아니면 포스트 목록으로 리다이렉트
        }
    }
 */
    @GetMapping("/delete")
    public String deletePost(
            @RequestParam("id") Long postId,
            @RequestParam("author") String author,
            Model model,
            HttpSession session,
            RedirectAttributes redirectAttributes
    ) {
        MemberResponseDTO loginUser = (MemberResponseDTO) session.getAttribute("loginUser");
        if(loginUser!=null && loginUser.getName().equals(author)){
            PostResponseDTO  post = postService.getOnePost(postId);
            model.addAttribute("posts",post);
            return "delete-post";
        }else{
            redirectAttributes.addFlashAttribute("alertMessage", "로그인 하시오");
            return "redirect:/users/login";
        }
    }
    @PostMapping("/delete")
    public String postDelete(@RequestBody PostDeleteRequestDTO request, RedirectAttributes redirectAttributes) {
        postService.deletePost(request.getId());
        redirectAttributes.addFlashAttribute("alertMessage", "삭제 성공");
        return "redirect:/post";
    }

    public boolean checkPostWrite(Long postId, HttpSession session) {
        MemberResponseDTO loginUser = (MemberResponseDTO) session.getAttribute("loginUser");
        // 로그인 여부와,게시글 작성자이름과 로그인이름 같은지 확인
        if(loginUser!=null&&loginUser.getName().equals(postService.checkUserPost(postId))){
            return true;
        }else{
            return false;
        }
    }
    @GetMapping("/details/{id}")
    public String details(@PathVariable("id") Long  postId,Model model) {
        PostResponseDTO post = postService.getOnePost(postId);
        model.addAttribute("post",post);
        return "details-post";
    }


}
