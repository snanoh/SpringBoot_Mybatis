package com.hancom.entity;


import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Board {
    private Long idx;
    private String title;
    private String content;
    private String writer;
    private int boardHit;
    private LocalDateTime createDate;
}
