package com.example.SpringBootBasicBoard.dto;

import com.example.SpringBootBasicBoard.model.Board;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class BoardDetailResponseDTO {
    private String title;
    private String content;
    private String userId;
    private String filePath;
    private LocalDateTime created;

    public Board toBoard() {
        return Board.builder()
                .title(title)
                .userId(userId)
                .created(created)
                .content(content)
                .filePath(filePath)
                .build();

    }
}
