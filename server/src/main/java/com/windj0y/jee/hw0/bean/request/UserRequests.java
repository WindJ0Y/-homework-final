package com.windj0y.jee.hw0.bean.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

public class UserRequests {

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class LoginRequest {
        @NotNull String username;
        @NotNull String password;
        @NotNull int role;
    }

}
