package com.example.spring.apringbootsecuritykimseheak.controller;

import com.example.spring.apringbootsecuritykimseheak.dto.BoardListResponseDTO;
import com.example.spring.apringbootsecuritykimseheak.model.Board;
import com.example.spring.apringbootsecuritykimseheak.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/board")
public class BoardApiController {
    private final BoardService boardService;

    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping
    public BoardListResponseDTO getBoardList(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        // 게시글 목록 가져오기
        List<Board> boards = boardService.getBoardList(page, size);

        // 전체 게시글 수 가져오기
        int totalBoards = boardService.getTotalBoards();

        // 마지막 페이지 여부 계산
        boolean last = (page * size) >= totalBoards;

        return BoardListResponseDTO.builder()
                .boards(boards)
                .last(last)
                .build();
    }

//    @GetMapping("/{id}")
//    @PreAuthorize("hasRole('ROLE_ADMIN') or @boardService.isOwner(authentication.name, #id)")
//    public BoardDetailResponseDTO getBoardDetail(@PathVariable long id) {
//        Board boardDetail = boardService.getBoardDetail(id);
//        return BoardDetailResponseDTO.builder()
//                .title(boardDetail.getTitle())
//                .content(boardDetail.getContent())
//                .created(boardDetail.getCreated())
//                .userId(boardDetail.getUserId())
//                .filePath(boardDetail.getFilePath())
//                .build();
//    }
}
