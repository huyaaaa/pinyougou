package com.huyaaaaaa.utils;

import java.io.Serializable;

public class MessageChnResolver implements Serializable {
    private String message;

    public MessageChnResolver(String message) {
        this.message = message;
    }

    public MessageChnResolver() {
    }

    public String getMessage() {

        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
