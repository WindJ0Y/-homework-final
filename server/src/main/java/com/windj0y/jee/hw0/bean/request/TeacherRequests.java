package com.windj0y.jee.hw0.bean.request;
import com.windj0y.jee.hw0.bean.request.UserRequests.Authentication;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

public class TeacherRequests {

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ListHomeworkRequest implements Authentication {
        @NotNull int uid;
        @NotNull String token;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class InfoHomeworkRequest implements Authentication {
        @NotNull int uid;
        @NotNull String token;
        @NotNull int hid;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SubmitHomeworkRequest implements Authentication {
        @NotNull int uid;
        @NotNull String token;
        @NotNull int sid;
        @NotNull String content;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AddHomeworkRequest implements Authentication {
        @NotNull int uid;
        @NotNull String token;
        @NotNull String title;
        @NotNull String content;
    }

}
