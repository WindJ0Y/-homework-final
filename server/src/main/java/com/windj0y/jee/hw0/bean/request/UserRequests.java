package com.windj0y.jee.hw0.bean.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

public class UserRequests {

    public interface Authentication {
        int getUid();
        String getToken();
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class LoginRequest {
        @NotNull String username;
        @NotNull String password;
        @NotNull int role;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class LogoutRequest implements Authentication {
        @NotNull int uid;
        @NotNull String token;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class InfoRequest implements Authentication {
        @NotNull int uid;
        @NotNull String token;
    }

}
