package com.thoughtworks.basic.Exception;

public class FlagRepeatException extends RuntimeException {
    public FlagRepeatException() {
        super("请不要重复输入相同的flag");
    }
}
