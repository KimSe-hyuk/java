package com.example.SpringBootBasicBoard.dto;

import com.example.SpringBootBasicBoard.model.Board;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class BoardListResponseDTO {
    List<Board> boards;
    boolean last;
}
