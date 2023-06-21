package com.example.study_servlet.commons;

import java.util.UUID;

public class Commons {
    public String generateUUID() {
        return UUID.randomUUID().toString();
    }
    
}
