package com.comicsm.comicsmanager.service.util;

import org.springframework.stereotype.Component;

@Component
public class Timestamp {

    public static String createTimestamp() {
        return String.valueOf(new java.sql.Timestamp(System.currentTimeMillis()).getTime());
    }
}
