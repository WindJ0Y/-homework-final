package com.windj0y.jee.hw0.bean.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class UserResponses {

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class LoginResponse {
        int state;
        String msg;
        int uid;
        String token;
    }

}
