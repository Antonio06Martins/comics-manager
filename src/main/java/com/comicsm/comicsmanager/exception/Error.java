package com.comicsm.comicsmanager.exception;

public class Error {

    private String msgUser;
    private String msgDeveloper;

    public Error(String msgUser, String msgDeveloper) {
        this.msgUser = msgUser;
        this.msgDeveloper = msgDeveloper;
    }

    public String getMsgUser() {
        return msgUser;
    }

    public String getMsgDeveloper() {
        return msgDeveloper;
    }
}
