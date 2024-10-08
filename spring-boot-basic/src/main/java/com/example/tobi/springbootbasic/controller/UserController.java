package com.example.tobi.springbootbasic.controller;

import com.example.tobi.springbootbasic.dto.*;
import com.example.tobi.springbootbasic.service.UserService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    
    @GetMapping
    public String findAllUsers(Model model) {
        List<MemberResponseDTO> users = userService.findAll();
        model.addAttribute("users",users);
        return "user-list";
    }

    @GetMapping("/register")
    public String registerForm(Model model) {
        return "sign-up";
    }


    @GetMapping("/update/{id}")
    public String updateForm(@PathVariable Long id, Model model) {
        System.out.println("id :: "+id);
        //로직을 추가... -> id를 조건으로 조회한 데이터를
        // 프론트(수정)화면에 뿌릴 것.
        MemberResponseDTO user = userService.findOne(id);
        model.addAttribute("user",user);
        return "user-update";
    }
    /*
    @PutMapping("/user-update/{id}")
    public ResponseEntity<String> updateUser(@PathVariable Long id, @RequestBody MemberUpdateRequestDTO request) {
        // 해당 id에 맞는 사용자 업데이트 로직 수행
        if (userService.updateUser(id, request.toUser())) {
            return ResponseEntity.ok("사용자 정보가 성공적으로 수정되었습니다.1");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("해당 사용자를 찾을 수 없습니다1.");
        }
    }*/
    @PutMapping
    public ResponseEntity<String> update(@RequestBody MemberUpdateRequestDTO request) {
        userService.updateUser( request.toUser() );
        return ResponseEntity.ok("Updated");
    }
    //    @GetMapping("/update")
//    public String updateForm(@RequestParam("id") Long id, Model model) {
//        System.out.println("id :: "+id);
//        return "user-update";
//    }
//    @PutMapping("/update/{id}")
//    public String updateUser(@PathVariable Long id, Model model) {
//        System.out.println(request);
//        userService.createUser(request.toUser());
//        return "redirect:/users";
//    }

//
//@GetMapping("/delete/{id}")
//public String deleteForm(@PathVariable Long id, Model model) {
//    MemberResponseDTO user = userService.findOne(id); // ID로 사용자 조회
//    model.addAttribute("user", user);
//    return "user-delete"; // 삭제 폼 페이지로 이동
//}
//@DeleteMapping("/user-delete")
//public ResponseEntity<?> deleteUser(@RequestBody MemberCreateRequestDTO request, RedirectAttributes redirectAttributes) {
//    if (userService.deleteUser(request.toUser())) {
//        redirectAttributes.addFlashAttribute("successMessage", "사용자가 삭제되었습니다.");
//        return ResponseEntity.ok().build();
//    } else {
//        redirectAttributes.addFlashAttribute("errorMessage", "사용자 삭제에 실패했습니다.");
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("삭제 실패");
//    }
//}

    @GetMapping("/delete")
    public String deleteForm(@RequestParam("id") Long id,@RequestParam("userid") String userid,  Model model) {

        model.addAttribute("user",  MemberDeleteUserResponsDTO.builder()
                .id(id)
                .userid(userid)
                .build());
        return "user-delete"; // 삭제 폼 페이지로 이동
    }

    @DeleteMapping("/delete")
    public ResponseEntity<HttpStatus> delete(@RequestBody MemberDeleteUserRequestDTO request) {

        userService.deleteUser(request.toUser());
        return ResponseEntity.ok(HttpStatus.OK);
    }



    @PostMapping("/register")
    public String createUser(@RequestBody MemberCreateRequestDTO request) {
        System.out.println(request);
        userService.createUser(request.toUser());
        return "redirect:/users";
    }
}
