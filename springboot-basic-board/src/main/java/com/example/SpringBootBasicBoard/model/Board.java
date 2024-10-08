package com.example.SpringBootBasicBoard.model;

import lombok.Builder;
import lombok.Getter;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.time.LocalDateTime;

@Getter
@Builder
public class Board {
    private Long id;
    private String title;
    private String content;
    private String userId;
    private String filePath;
    private LocalDateTime created;
}
