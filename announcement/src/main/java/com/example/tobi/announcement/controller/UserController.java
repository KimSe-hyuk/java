package com.example.tobi.announcement.controller;

import com.example.tobi.announcement.dto.MemberCreateRequestDTO;
import com.example.tobi.announcement.dto.MemberLoginRequestDTO;
import com.example.tobi.announcement.dto.MemberResponseDTO;
import com.example.tobi.announcement.dto.RedirectResponseDTO;
import com.example.tobi.announcement.service.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;


    @GetMapping("/create")
    public String createForm() {
        return "/create-user";
    }
    @PostMapping("/create")
    public ResponseEntity<RedirectResponseDTO> createUser(@RequestBody MemberCreateRequestDTO request, RedirectAttributes redirectAttributes) {
        boolean checkUser = userService.createUser(request.toUser());
        if (checkUser) {
            String redirectUrl = "/post";
            redirectAttributes.addFlashAttribute("alertMessage", "회원가입 성공");
            RedirectResponseDTO response = new RedirectResponseDTO(redirectUrl,true);
            return  ResponseEntity.ok(response);
        } else {
            String redirectUrl = "/users/create";
            RedirectResponseDTO response = new RedirectResponseDTO(redirectUrl,true);
            redirectAttributes.addFlashAttribute("alertMessage", "회원가입 실패");
            return  ResponseEntity.ok(response);
        }
    }
    @GetMapping("/login")
    public String loginForm(
            HttpSession session,
            Model model
    ) {
        MemberResponseDTO loginUser = (MemberResponseDTO) session.getAttribute("loginUser");
        if(loginUser!=null){
            model.addAttribute("loginUser", loginUser);
        }
        return "/login-user";
    }
//    @PostMapping("/login")
//    public String loginUser(@RequestBody MemberLoginRequestDTO request, HttpSession session, RedirectAttributes redirectAttributes) {
//        MemberResponseDTO loginSuccess = userService.loginUser(request.toUser());
//        if (loginSuccess != null) {
//            session.setAttribute("loginUser", loginSuccess);
//            redirectAttributes.addFlashAttribute("alertMessage", "로그인 성공");
//            return "redirect:/post";
//        } else {
//            redirectAttributes.addFlashAttribute("alertMessage", "로그인 실패");
//            return "redirect:/users/login";
//        }
//    }

    @PostMapping("/login")
    @ResponseBody
    public ResponseEntity<Map<String, String>> loginUser(@RequestBody MemberLoginRequestDTO request, HttpSession session) {
        MemberResponseDTO loginSuccess = userService.loginUser(request.toUser());

        Map<String, String> response = new HashMap<>();
        if (loginSuccess != null) {
            session.setAttribute("loginUser", loginSuccess);
            response.put("status", "success");
            response.put("message", "로그인 성공");
            response.put("redirectUrl", "/post"); // 리다이렉트할 URL 추가
        } else {
            response.put("status", "error");
            response.put("message", "로그인 실패");
        }
        return ResponseEntity.ok(response);
    }

    @GetMapping("/logout")
    public String logout(HttpSession session,RedirectAttributes redirectAttributes) {
        session.invalidate();
        redirectAttributes.addFlashAttribute("alertMessage", "로그아웃");
        return "redirect:/users/login";
    }

}
