package com.hancom.entity;

import lombok.Data;

@Data
public class Response {
    private String code;
    private String message;
    private Object info;
}
