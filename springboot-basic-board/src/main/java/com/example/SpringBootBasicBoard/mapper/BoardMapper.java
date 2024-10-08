package com.example.SpringBootBasicBoard.mapper;

import com.example.SpringBootBasicBoard.model.Board;
import com.example.SpringBootBasicBoard.model.Paging;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    List<Board> selectBoardList(Paging page);
    int countBoards();
    Board selectBoardDetail(long id);
    void insertBoards(Board board);
    void saveArticle(Board board);
    void deleteBoardById(long id);
    void updateArticle(Board board);
}
