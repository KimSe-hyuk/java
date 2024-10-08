package com.example.tobi.announcement.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class PostResponseDTO {
   private Long id;
   private String title;
   private String content;
   private String date;
   private String author;


}
