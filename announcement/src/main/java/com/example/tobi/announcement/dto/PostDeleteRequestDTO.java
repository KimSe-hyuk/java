package com.example.tobi.announcement.dto;

import com.example.tobi.announcement.model.Post;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PostDeleteRequestDTO {
    private Long id;
}
