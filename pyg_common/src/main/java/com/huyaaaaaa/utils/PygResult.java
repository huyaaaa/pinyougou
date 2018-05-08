package com.huyaaaaaa.utils;

import java.io.Serializable;

public class PygResult implements Serializable{

    /**
     *
     */
    private static final long serialVersionUID = -5340854706154469236L;

    //
    private boolean success;

    private String message;



    public PygResult(boolean success, String message) {
        super();
        this.success = success;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }



}
