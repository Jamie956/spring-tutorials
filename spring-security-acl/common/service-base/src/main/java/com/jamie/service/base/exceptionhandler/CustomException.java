package com.jamie.service.base.exceptionhandler;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CustomException extends RuntimeException {
    private Integer code;
    private String msg;
}
