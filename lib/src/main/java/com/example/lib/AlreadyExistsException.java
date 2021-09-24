package com.example.lib;

public class AlreadyExistsException extends Throwable {

    private static final long serialVersionUID = 1L;
    public AlreadyExistsException(String s) {
        super(s);
    }
}
