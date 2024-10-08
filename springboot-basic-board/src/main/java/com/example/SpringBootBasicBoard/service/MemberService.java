package com.example.SpringBootBasicBoard.service;

import com.example.SpringBootBasicBoard.dto.SignInRequestDTO;
import com.example.SpringBootBasicBoard.dto.SignInResponseDTO;
import com.example.SpringBootBasicBoard.mapper.MemberMapper;
import com.example.SpringBootBasicBoard.model.Member;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberMapper memberMapper;

    public void signUp(Member member) {
        memberMapper.signUp(member);
    }
    public SignInResponseDTO signIn(Member member, HttpSession session) {
        Member getMember = memberMapper.signIn(member.getUserId());
        if(getMember == null) {
            return makeSignInrequestDTO(false,"존재하지 않는 회원입니다.","/member/login",null);

        }
        if( !member.getPassword().equals(getMember.getPassword())) {
            return makeSignInrequestDTO(false,"비밀번호가 틀렸습니다.","/member/login",null);
        }
        //세션 설정
        session.setAttribute("userId",getMember.getUserName());
        session.setAttribute("userName",getMember.getUserName());

        return makeSignInrequestDTO(true,"로그인이 성공했습니다.","/",getMember);
    }
    private SignInResponseDTO makeSignInrequestDTO(boolean isloogedIn, String message, String url,  Member member){
        return SignInResponseDTO.builder()
                .isLoggedIn(true)
                .message(message)
                .url(url)
                .userId(isloogedIn?member.getUserId():null)
                .userName(isloogedIn?member.getUserName():null)
                .build();
    }
}
