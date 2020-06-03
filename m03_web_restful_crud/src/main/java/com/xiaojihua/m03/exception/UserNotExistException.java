package com.xiaojihua.m03.exception;

/**
 * 自定义异常
 */
public class UserNotExistException extends RuntimeException {
    public UserNotExistException(){
        super("自定义异常：用户不存在");
    }
}
